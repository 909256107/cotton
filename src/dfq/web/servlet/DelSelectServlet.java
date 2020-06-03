package dfq.web.servlet;
import dfq.service.CottonService;
import dfq.service.impl.CottonServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectServlet")
public class DelSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有的id
        String[] ids = request.getParameterValues("uid");
        //调用service方法
        CottonService service = new CottonServiceImpl();
        service.deleSelectedCotton(ids);
        //跳转
        response.sendRedirect(request.getContextPath()+ "/findCottonByPageServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
