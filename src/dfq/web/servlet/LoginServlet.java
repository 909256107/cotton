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
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
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
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        String type=request.getParameter("type");
        if("1".equals(type)){
            //跳转到普通用户的页面
            Map<String, String[]> map = request.getParameterMap();
            //封装User对象
            User user = new User();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //调用Service查询
            UserService service = new UserServiceImpl();
            User loginUser = service.login(user);
            //判断是否登录成功
            if(loginUser != null){
                //登录成功
                //将用户存入session
                session.setAttribute("user",loginUser);
                //跳转页面
                response.sendRedirect(request.getContextPath()+"/findCottonByPageServlet2");
            }else{
                //登录失败
                //提示信息
                request.setAttribute("login_msg","用户名或密码错误！");
                //跳转登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            //跳转到管理员的页面
            Map<String, String[]> map = request.getParameterMap();
            //封装RootUser对象
            RootUser rootUser = new RootUser();
            try {
                BeanUtils.populate(rootUser,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //调用Service查询
            RootUserService service = new RootUserServiceImpl();
            RootUser login = service.login(rootUser);
            //判断是否登录成功
            if(login != null){
                //登录成功
                //将用户存入session
                session.setAttribute("user",login);
                //跳转页面
                response.sendRedirect(request.getContextPath()+"/findCottonByPageServlet");
            }else{
                //登录失败
                //提示信息
                request.setAttribute("login_msg","用户名或密码错误！");
                //跳转登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
