/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 import java.io.IOException;  
 import java.io.PrintWriter;  
  
 import javax.servlet.RequestDispatcher;  
 import javax.servlet.ServletException;  
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;  
 import javax.servlet.http.HttpServletRequest;  
 import javax.servlet.http.HttpServletResponse; 
 import javax.servlet.http.HttpSession;
 
  
  @WebServlet(name = "login", urlPatterns = {"/login"})
 public class login extends HttpServlet {  
 @Override
 public void doPost(HttpServletRequest request, HttpServletResponse response)  
         throws ServletException, IOException {  
  
     response.setContentType("text/html");  
     PrintWriter out = response.getWriter();  
 
          
     String n=request.getParameter("user");  
     String p=request.getParameter("pass");  
     
             
          
     if(!loginDAO.validate(n, p)){ 
         out.print("Sorry username or password error");  
         RequestDispatcher rd=request.getRequestDispatcher("index.html");  
         rd.include(request,response);    
     }  
     else{  
         RequestDispatcher rd=request.getRequestDispatcher("/home.html");  
         rd.forward(request,response); 
     }  
     
             HttpSession session = request.getSession(true);
             String username=(String) request.getAttribute("user");
             session.setAttribute("user", n);
             request.getSession(true).setAttribute("user", n);
 
             RequestDispatcher rd = request.getRequestDispatcher("home.html");
             rd.forward(request, response); 
          
     /*out.close();  */
     }  
 }  