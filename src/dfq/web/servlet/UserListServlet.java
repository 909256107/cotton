package dfq.web.servlet;


import dfq.daomain.User;


import dfq.service.UserService;


import dfq.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.����UserService��ɲ�ѯ
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
        //2.��list����request��
        request.setAttribute("users",users);
        //3.ת����list.jsp
        request.getRequestDispatcher("/list_User.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
