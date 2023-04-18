import java.io.*;  
import java.sql.*;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*; 
import javax.servlet.http.HttpSession;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
 
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  
            
            String n=request.getParameter("user");  
            String p=request.getParameter("pass");
            String r=request.getParameter("repass"); 
            
   /* String username=(String) request.getAttribute("user");*/
          
            
           
            if (!r.contentEquals(p)){
                
                out.print("Sorry username or password error");  
                RequestDispatcher rd=request.getRequestDispatcher("index.html");  
                rd.include(request,response);  
            }  
            
            else{
                
                try{  
                     
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(  
                    "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb6348","mydb6348cg","ja6pen"); 
                    
                    PreparedStatement ps=con.prepareStatement(  
                    "insert into user values(?,?)");  
 
                    ps.setString(1,n);  
                    ps.setString(2,p);
                     
                    
                    int i=ps.executeUpdate();  
                    if(i>0)  
                    out.print("You are successfully registered..."); 
                        
   
                }catch (ClassNotFoundException | SQLException e2) {System.out.println(e2);} 
                
                    RequestDispatcher rd=request.getRequestDispatcher("/home.html");  
                    rd.forward(request,response); 
                         
            }   
           HttpSession session = request.getSession(true);
            String username=(String) request.getAttribute("user");
            session.setAttribute("user", n);
           request.getSession(true).setAttribute("user", n);
           
            RequestDispatcher rd = request.getRequestDispatcher("home.html");
            rd.forward(request, response); 
     
           /* out.close();*/
    }
                    
}     