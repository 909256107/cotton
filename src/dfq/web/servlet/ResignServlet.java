package dfq.web.servlet;
import dfq.daomain.RootUser;
import dfq.daomain.User;
import dfq.service.RootUserService;
import dfq.service.UserService;
import dfq.service.impl.RootUserServiceImpl;
import dfq.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/resignServlet")
public class ResignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取用户填写验证码
        String verifycode = request.getParameter("verifycode");
        //验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转注册页面
            request.getRequestDispatcher("/resign.jsp").forward(request,response);
            return;
        }
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        RootUser rootUser = new RootUser();
        try {
            BeanUtils.populate(rootUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用service保存
        RootUserService service = new RootUserServiceImpl();
        service.addRootUser(rootUser);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script>");
        out.print("alert('注册成功');");
        out.print("window.location.href='login.jsp'");
        out.print("</script>");
        out.close();


//       response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
