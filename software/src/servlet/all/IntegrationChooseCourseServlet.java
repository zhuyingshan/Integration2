package servlet.all;

import commercialClientPart.demo.CommercialPortServiceLocator;
import commercialClientPart.demo.CommercialPort_PortType;
import format.Format;
import format.TransformType;
import format.UniteParseXML;
import po.Course;
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

@WebServlet(asyncSupported = true, urlPatterns = { "/integrationChooseCourse" },loadOnStartup=1)
public class IntegrationChooseCourseServlet extends HttpServlet {

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
            request.setCharacterEncoding("utf-8");
            SoftwarePortServiceLocator softwareLocator = new SoftwarePortServiceLocator();
            SoftwarePort_PortType softwareService = softwareLocator.getSoftwarePort();

            CommercialPortServiceLocator commercialPortServiceLocator = new CommercialPortServiceLocator();
            CommercialPort_PortType commercialPort_portType = commercialPortServiceLocator.getCommercialPort();
            HttpSession httpSession = request.getSession(false);

            ArrayList<Course> softwareCourses = UniteParseXML.paserUniteCourse(softwareService.findAllCourse("88"));
            String str=commercialPort_portType.findAllCourse("88");
            System.out.println("1*****"+str);
            str= Format.formatXML(commercialPort_portType.findAllCourse("88")
                    , TransformType.COURSETOUNITE);
            ArrayList<Course> commercialCourses = UniteParseXML.paserUniteCourse(str);





            String result="";


            String param = httpSession.getAttribute("studentId")+","+request.getParameter("courseId");

            if (judgeIsIn(softwareCourses, request.getParameter("courseId"))) {
                result = softwareService.chooseCourse(param, request.getParameter("courseId"));
            }
            if (judgeIsIn(commercialCourses, request.getParameter("courseId"))) {
                result = commercialPort_portType.chooseCourse(param, request.getParameter("courseId"));
            }



            System.out.println(result);
            if (result.equals("true")) {
                response.sendRedirect("courseList.jsp");
            }
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }
    }


    private boolean judgeIsIn(ArrayList<Course> list, String id) {
        for (Course c:list) {
            if (c.courseId.equals(id)) {
                return true;
            }
        }

        return false;
    }
}
