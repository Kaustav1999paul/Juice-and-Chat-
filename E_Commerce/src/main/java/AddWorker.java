

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/AddWorker")
public class AddWorker extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

    public AddWorker() {
        super();
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        
        PrintWriter pw;    
        response.setContentType("text/html");    
        pw=response.getWriter();       
            
        String First_Name = request.getParameter("First_Name");
		String Last_Name = request.getParameter("Last_Name");
		int Age = Integer.parseInt(request.getParameter("Age"));
		int Ph_No = Integer.parseInt(request.getParameter("Ph_No"));
		String Address = request.getParameter("Address");  
            
            
        try{    
            Class.forName("com.mysql.jdbc.Driver");    
            String url="jdbc:mysql://localhost:3306/mydb_mysql";    
            String user="root";    
            String password="root";    
                
            Connection con=DriverManager.getConnection(url, user, password);  
            
            String query="Insert into worker(First_Name,Last_Name,Age,Ph_No,Address) values (?,?,?,?,?);";    
            PreparedStatement ps=con.prepareStatement(query);    
            ps.setString(1, First_Name);
    		ps.setString(2, Last_Name);
    		ps.setInt(3, Age);
    		ps.setInt(4, Ph_No);
    		ps.setString(5, Address);   
                
            int x=ps.executeUpdate();    
                
            if(x==1){    
            	pw.println("Values Inserted Successfully");    
            }else {
            	pw.println("Error !!");
            }    
                
        }catch(Exception e){    
             e.printStackTrace();    
        }        
        pw.close();    
    }    
    
}   