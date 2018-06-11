package servlet;

import mathClientPart.demo.MathPortServiceLocator;
import mathClientPart.demo.MathPort_PortType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = { "/mathChooseCourse" },loadOnStartup=1)
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
            MathPortServiceLocator locator = new MathPortServiceLocator();

            MathPort_PortType service = locator.getMathPort();
            HttpSession httpSession = request.getSession(false);

            String result = service.chooseCourse((String) httpSession.getAttribute("studentId"), request.getParameter("courseId"));
            if (result.equals("true")) {
                response.sendRedirect("courseList.jsp");
            }
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }
    }
}
