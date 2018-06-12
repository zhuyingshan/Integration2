package servlet.all;

import commercialClientPart.demo.CommercialPortServiceLocator;
import commercialClientPart.demo.CommercialPort_PortType;
import dataUtils.ParseXML;
import format.Format;
import format.TransformType;
import format.UniteParseXML;
import po.Course;
import po.Selection;
import softwareClientPart.com.intergration.demo.SoftwarePortServiceLocator;
import softwareClientPart.com.intergration.demo.SoftwarePort_PortType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(asyncSupported = true, urlPatterns = { "/integrationAllCourse" },loadOnStartup=1)
public class IntegrationAllCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    public void init() throws ServletException {
        System.out.println("创建servlet！");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);

            request.setCharacterEncoding("utf-8");
            SoftwarePortServiceLocator softwareLocator = new SoftwarePortServiceLocator();
            SoftwarePort_PortType softwareService = softwareLocator.getSoftwarePort();

            CommercialPortServiceLocator commercialPortServiceLocator = new CommercialPortServiceLocator();
            CommercialPort_PortType commercialPort_portType = commercialPortServiceLocator.getCommercialPort();

            String studentId = request.getParameter("studentId");
            String name = request.getParameter("name");
            String department = request.getParameter("department");

            ArrayList<Course> softwareCourses = UniteParseXML.paserUniteCourse(Format.formatXML(softwareService.findAllCourse("88"), TransformType.COURSETOUNITE));
            System.out.println(commercialPort_portType.findAllCourse("88"));
            String str=commercialPort_portType.findAllCourse("88");
            System.out.println("1*****"+str);
            str=Format.formatXML(commercialPort_portType.findAllCourse("88")
                    , TransformType.COURSETOUNITE);
            ArrayList<Course> commercialCourses = UniteParseXML.paserUniteCourse(str);

            System.out.println(commercialCourses.size()+"******");
            ArrayList<Course> all = new ArrayList<>();
            System.out.println(">>>>>>>>>>>>>"+department);
            if (department.equals("software")) {
                all.addAll(softwareCourses);
            } else {
                for (Course c:softwareCourses) {
                    System.out.println(">>>>>>>>>>>>>"+c.isShare);
                    if (c.isShare == 'Y') {
                        all.add(c);
                    }
                }
            }
            if (department.equals("commercial")) {
                all.addAll(commercialCourses);
            } else {
                for (Course c:commercialCourses) {
                    System.out.println(">>>>>>>>>>>>>"+c.isShare);
                    if (c.isShare == 'Y') {
                        all.add(c);
                    }
                }
            }

            session.setAttribute("allCourse", all);

            ArrayList<Selection> mySoftwareCourse = UniteParseXML.paserUniteSelection(Format.formatXML(softwareService.findMyCourse(studentId), TransformType.SELECTIONTOUNITE));
            System.out.println("software"+mySoftwareCourse.size());
            String string =commercialPort_portType.findMyCourse(studentId);
            System.out.println(string);
            string=Format.formatXML(string,TransformType.SELECTIONTOUNITE);
            System.out.println(string );
            ArrayList<Selection> myCommercialCourse =UniteParseXML.paserUniteSelection(string );
            System.out.println(myCommercialCourse.size());
            //ArrayList<Selection> myCommercialCourse = UniteParseXML.paserUniteSelection(Format.formatXML(commercialPort_portType.findMyCourse(studentId), TransformType.SELECTIONTOUNITE));
            System.out.println("commercial"+myCommercialCourse.size());

            ArrayList<Selection> myCourse = new ArrayList<>();
            myCourse.addAll(myCommercialCourse);
            myCourse.addAll(mySoftwareCourse);

            session.setAttribute("myCourse", myCourse);


            String res = softwareService.login(studentId+","+name, name);



            if (res.equals("SUCCESS")) {
                session.setAttribute("studentId", studentId);
                session.setAttribute("department", department);

                System.out.println("+++++++++++++++++++++++++++++++++++++");

                response.sendRedirect("integrationAllCourse.jsp");
            } else if (res.equals("ERROR")) {
                response.getWriter().println("登录失败");
            } else {
                response.getWriter().println("用户不存在");
            }
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
