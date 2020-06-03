package dfq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
完成登录过滤的验证器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //强制转换
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding("utf-8");
        //获取资源请求路径
        String uri = ((HttpServletRequest) req).getRequestURI();
        //判断是否包含登录相关路径
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/checkCodeServlet")||uri.contains("/css")||uri.contains("/fonts")||uri.contains("/img")||uri.contains("/js")||uri.contains("/resign.jsp")||uri.contains("/resignServlet")){
            //证明用户就是想登陆放行
            chain.doFilter(req, resp);
        }else{
            //非法  需要验证
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //已经登录
                chain.doFilter(req, resp);
            }else {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>");
                out.print("alert('您还没有登录！请前往登录');");
                out.print("window.location.href='login.jsp'");
                out.print("</script>");
                out.close();
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
