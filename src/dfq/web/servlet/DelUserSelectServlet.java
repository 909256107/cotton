package dfq.web.servlet;

import dfq.service.CottonService;
import dfq.service.UserService;
import dfq.service.impl.CottonServiceImpl;
import dfq.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserSelectServlet")
public class DelUserSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ���е�id
        String[] ids = request.getParameterValues("uid");
        //����service����
        UserService service = new UserServiceImpl();
        service.delSelectedUser(ids);
        //��ת
        response.sendRedirect(request.getContextPath()+ "/userListServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
