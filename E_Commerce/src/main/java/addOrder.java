

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/addOrder")
public class addOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addOrder() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw;    
        response.setContentType("text/html");    
        pw=response.getWriter();
        
        
        String Worker = request.getParameter("Worker");
		String Item = request.getParameter("Item");
		int Quantity = Integer.parseInt(request.getParameter("Quantity"));
		
		
		String workerID="";
		for(int i=0;i<=Worker.length();i++) {
			if(Worker.charAt(i) != '|') {
				workerID += Worker.charAt(i);
			}else {
				break;
			}
		}
		
		String itemID="";
		for(int i=0;i<=Item.length();i++) {
			if(Item.charAt(i) != '|') {
				itemID += Item.charAt(i);
			}else {
				break;
			}
		}
		
		
//		Get price from DB
		char ch;
		String price = "";
		String finalPrice="";
		
		
		for(int i=Item.length()-1; i>Item.length()-3;i--) {
			if(Item.charAt(i) != '₹') {
				price += Item.charAt(i);
			}else {
				break;
			}
		}
		
//		Logic to reverse a String
		for (int i=0; i<price.length(); i++) { 
	        ch= price.charAt(i);  
	        finalPrice= ch+finalPrice; 
	    } 
		
        int total = Integer.parseInt(finalPrice) * Quantity;  
        
        
        Date date = new Date();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
        
        
        
		
//		got workerID;
//		got itemID;
//		got Quantity;
//		got date;
//      got total;
		
		
		
		try{    
            Class.forName("com.mysql.jdbc.Driver");    
            String url="jdbc:mysql://localhost:3306/mydb_mysql";    
            String user="root";    
            String password="root";    
            
            Connection con=DriverManager.getConnection(url, user, password);  
            
            String query="Insert into sell(ID,Item_Id,Quantity,Date,Total) values (?,?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(query);    
            ps.setString(1, workerID);
    		ps.setString(2, itemID);
    		ps.setInt(3, Quantity);
    		ps.setString(4, modifiedDate);
    		ps.setInt(5, total);
    		
    		
    		int x=ps.executeUpdate();    
            
            if(x==1){    
            	pw.println("Item Details added Successfully!!");    
            }else {
            	pw.println("Error !!");
            } 
            
		}catch(Exception e) {
			e.printStackTrace();    
        }        
        pw.close(); 
		
		
	}

}
