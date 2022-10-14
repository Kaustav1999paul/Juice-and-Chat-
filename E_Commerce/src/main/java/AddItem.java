

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddItem() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw;    
        response.setContentType("text/html");    
        pw=response.getWriter();
        
        String Name = request.getParameter("Name");
		String Type = request.getParameter("Type");
		int Investment = Integer.parseInt(request.getParameter("Investment"));
		int Selling_Price = Integer.parseInt(request.getParameter("Selling_Price"));
		
		
		try{    
            Class.forName("com.mysql.jdbc.Driver");    
            String url="jdbc:mysql://localhost:3306/mydb_mysql";    
            String user="root";    
            String password="root";    
                
            Connection con=DriverManager.getConnection(url, user, password);  
            
            String query="Insert into item(Name,Type,Investment,Selling_Price) values (?,?,?,?);";    
            PreparedStatement ps=con.prepareStatement(query);    
            ps.setString(1, Name);
    		ps.setString(2, Type);
    		ps.setInt(3, Investment);
    		ps.setInt(4, Selling_Price);
    	   
                
            int x=ps.executeUpdate();    
                
            if(x==1){    
            	pw.println("Item Details added Successfully!!");    
            }else {
            	pw.println("Error !!");
            }    
                
        }catch(Exception e){    
             e.printStackTrace();    
        }        
        pw.close(); 
		
	}

}
