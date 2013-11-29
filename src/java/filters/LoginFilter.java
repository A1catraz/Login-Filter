package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/LoginServlet"})
public class LoginFilter implements Filter {
  
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest  req = (HttpServletRequest)  request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        Throwable problem = null;
        try {
            if (session.getAttribute("username")!= null && session.getAttribute("loginTime")!=null){
                chain.doFilter(request, response);
            }
            else {
                session.setAttribute("error_mes", "You are not logged in. Please, log in first...");
                res.sendRedirect("index.jsp");
            }
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }
        }

    public void destroy() { 
        
    }
   
    public void init(FilterConfig filterConfig) {
        
    }
    
}
