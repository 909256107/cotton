package dfq.web.servlet;
import dfq.daomain.Cotton;
import dfq.service.CottonService;
import dfq.service.impl.CottonServiceImpl;
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

@WebServlet("/addCottonServlet")
public class AddCottonServlet extends HttpServlet {
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
            request.getRequestDispatcher("/addCotton.jsp").forward(request,response);
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        Cotton cotton = new Cotton();
        try {
            BeanUtils.populate(cotton,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        CottonService cottonService = new CottonServiceImpl();
        cottonService.addCotton(cotton);
        response.sendRedirect(request.getContextPath()+"/findCottonByPageServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
