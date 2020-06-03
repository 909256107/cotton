package dfq.web.servlet;

import dfq.service.CottonService;
import dfq.service.impl.CottonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delCottonServlet")
public class DelCottonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("id");
        //调用service删除
        CottonService service = new CottonServiceImpl();
        service.deleteCotton(id);
        //跳转
        response.sendRedirect(request.getContextPath()+ "/findCottonByPageServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
