package servlet.software;

import softwareClientPart.com.intergration.demo.SoftwarePortServiceLocator;
import softwareClientPart.com.intergration.demo.SoftwarePort_PortType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = { "/softwareChooseCourse" },loadOnStartup=1)
public class ChooseCourseServlet extends HttpServlet {

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
            SoftwarePortServiceLocator locator = new SoftwarePortServiceLocator();
            SoftwarePort_PortType service = locator.getSoftwarePort();
            HttpSession httpSession = request.getSession(false);

            System.out.println(request.getParameter("courseId"));

            String result = service.chooseCourse((String) httpSession.getAttribute("studentId"), request.getParameter("courseId"));
            if (result.equals("true")) {
                response.sendRedirect("courseList.jsp");
            }
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }
    }
}
