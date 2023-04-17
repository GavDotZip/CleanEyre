
import java.sql.*;  
 
public class loginDAO {  
    public static boolean validate(String name,String pass){  
        boolean status=false;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://mysql1.it.nuigalway.ie:3306/mydb6348","mydb6348cg","ja6pen");  
     
            PreparedStatement ps=con.prepareStatement( "select * from user where name=? and pass=?");  
            ps.setString(1,name);  
            ps.setString(2,pass);  
     
            ResultSet rs=ps.executeQuery();  
            status=rs.next();  
         
        }catch(Exception e){System.out.println(e);}  
        return status;
    }  
}  