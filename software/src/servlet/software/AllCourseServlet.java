package servlet.software;

import dataUtils.ParseXML;
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

@WebServlet(asyncSupported = true, urlPatterns = { "/softwareAllCourse" },loadOnStartup=1)
public class AllCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    public void init() throws ServletException {
        System.out.println("创建servlet！");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ParseXML parseXML = new ParseXML();
        try {
            SoftwarePortServiceLocator locator = new SoftwarePortServiceLocator();
            SoftwarePort_PortType service = locator.getSoftwarePort();

            String studentId = request.getParameter("studentId");
            String name = request.getParameter("name");

            System.out.println(name);

            ArrayList<Course> courses = parseXML.paserSoftwareCourse(service.findAllCourse("666"));
//            ArrayList<Course> courses = new ArrayList<>();
//            Course c = new Course("22", "44", "55", 'f');
//            Course c1 = new Course("23", "44", "55", 'f');
//            Course c2 = new Course("24", "44", "55", 'f');
//            courses.add(c);
//            courses.add(c1);
//            courses.add(c2);

            HttpSession httpSession = request.getSession(false);
            httpSession.setAttribute("allCourse", courses);
            ArrayList<Selection> myCourse = parseXML.paserSoftwareSelection(service.findMyCourse(studentId));

//            ArrayList<Selection> myCourse = new ArrayList<>();
//            Selection s = new Selection("22", "22", 90);
//            Selection s1 = new Selection("23", "22", 90);
//            myCourse.add(s);
//            myCourse.add(s1);

            httpSession.setAttribute("myCourse", myCourse);


            studentId = studentId+","+name;
            String res = service.login(studentId, name);

            System.out.println("============"+res);

            if (res.equals("SUCCESS")) {
                httpSession.setAttribute("studentId", studentId);
                response.sendRedirect("courseList.jsp");
            } else if (res.equals("ERROR")) {
                response.sendRedirect("login.jsp");
                response.getWriter().println("登录失败");
            } else {
                response.sendRedirect("login.jsp");
                response.getWriter().println("用户不存在");
            }


        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }

    }
}
