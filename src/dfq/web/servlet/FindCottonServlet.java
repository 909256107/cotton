package dfq.web.servlet;

import dfq.daomain.Cotton;
import dfq.service.CottonService;
import dfq.service.impl.CottonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findCottonServlet")
public class FindCottonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id =request.getParameter("id");
        CottonService service2 = new CottonServiceImpl();
        Cotton cottons = service2.findCottonById(id);
        request.setAttribute("cottons",cottons);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
