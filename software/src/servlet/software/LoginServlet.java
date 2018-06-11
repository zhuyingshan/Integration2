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

@WebServlet(asyncSupported = true, urlPatterns = { "/softwareLogin" },loadOnStartup=1)
public class LoginServlet extends HttpServlet {

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
            SoftwarePortServiceLocator locator = new SoftwarePortServiceLocator();
            SoftwarePort_PortType service = locator.getSoftwarePort();

            String studentId = request.getParameter("studentId");
            String name = request.getParameter("name");

            String res = service.login(studentId, name);

            if (res.equals("SUCCESS")) {
                HttpSession session = request.getSession(false);
                session.setAttribute("studentId", studentId);

                response.sendRedirect("courseList.jsp");
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
