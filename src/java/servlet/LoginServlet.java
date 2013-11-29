/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            HttpSession session = request.getSession();

            if(username.equals("Alcatraz") && password.equals("0515444788")){
                session.setMaxInactiveInterval(10);
                session.setAttribute("username",username);
                session.setAttribute("password", password);
                session.setAttribute("loginTime",new Date());
                response.sendRedirect("main.jsp");
            }
            else{
                session.setAttribute("error_mes","Username or Password is invalide. Please try again...");
                response.sendRedirect("index.jsp");
            }
        } finally{            
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
