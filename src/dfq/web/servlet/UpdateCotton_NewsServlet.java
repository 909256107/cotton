package dfq.web.servlet;


import dfq.daomain.Cotton_News;
import dfq.service.Cotton_NewService;
import dfq.service.impl.Cotton_NewServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateCotton_NewsServlet")
public class UpdateCotton_NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Cotton_News cn = new Cotton_News();
        try {
            BeanUtils.populate(cn,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Cotton_NewService impl = new Cotton_NewServiceImpl();
        impl.update(cn);
        response.sendRedirect(request.getContextPath()+ "/findCottonByPageServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
