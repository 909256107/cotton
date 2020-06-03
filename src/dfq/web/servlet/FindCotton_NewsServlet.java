package dfq.web.servlet;


import dfq.daomain.Cotton_News;

import dfq.service.Cotton_NewService;

import dfq.service.impl.Cotton_NewServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findCotton_NewsServlet")
public class FindCotton_NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id =request.getParameter("id");
        Cotton_NewService service2 = new Cotton_NewServiceImpl();
        Cotton_News cn = service2.findCotton_NewsById(id);
        request.setAttribute("cn",cn);
        System.out.println(cn);
        request.getRequestDispatcher("/updateCotton_News.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
