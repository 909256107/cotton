package dfq.web.servlet;

import dfq.daomain.Cotton;
import dfq.daomain.Cotton_News;
import dfq.daomain.PageBean;
import dfq.service.CottonService;
import dfq.service.Cotton_NewService;
import dfq.service.impl.CottonServiceImpl;
import dfq.service.impl.Cotton_NewServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
@WebServlet("/findCottonByPageServlet")
public class FindCottonByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取参数
        String currentPage = request.getParameter("currentPage");//获取当前页码
        String rows = request.getParameter("rows");//每页显示的条数
        if(currentPage==null || "".equals(currentPage)){
            currentPage="1";
        }
        if(rows==null || "".equals(rows)){
            rows="5";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //调用Service查询
        CottonService service2 = new CottonServiceImpl();
        PageBean<Cotton> pb= service2.findCottonByPage(currentPage, rows,condition);
        int totalPage =pb.getTotalPage();
        //将PageBean存入request域中
        request.setAttribute("pb",pb);
        //调用service|方法把表头输入到页面上
        Cotton_NewService cn = new Cotton_NewServiceImpl();
        List<Cotton_News> all = cn.findAll();
        System.out.println(all);

        request.setAttribute("all",all);
        //转发
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
