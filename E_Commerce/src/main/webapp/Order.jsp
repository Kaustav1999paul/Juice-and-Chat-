
 <%@ page import="java.io.*,java.util.*, javax.servlet.*, java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>

.mainClass{
 padding-top: 50px;
  padding-right: 150px;
  padding-bottom: 50px;
  padding-left: 150px;
}

</style>
</head>
<body>


<form class="mainClass" method="post" action="addOrder">
	<h1>Add Order</h1><br><br><br>
	
	
	<div class="row mb-4">
    <div class="col">
      <div class="form-outline">
      	<div class="form-group col-md-6">
      		<label for="inputEmail4">&emsp;ID &emsp;&emsp;&emsp; Worker Name</label>
        <select class="form-select form-select-lg" style="padding: 10px; border-radius: 10px;" name="Worker">
				<% try{
						Class.forName("com.mysql.jdbc.Driver");    
        				String url="jdbc:mysql://localhost:3306/mydb_mysql";    
        				String user="root";    
        				String password="root";    
        				Connection con=DriverManager.getConnection(url, user, password); 
        				Statement st = con.createStatement();
        				String query = "select * from worker";
        				ResultSet rs = st.executeQuery(query);
        
        				while (rs.next()){
        					%>
        					<option><%=rs.getString("ID") %> | &emsp;&emsp;&emsp;&emsp; <%=rs.getString("First_Name") %> <%=rs.getString("Last_Name") %> </option>
        	
        					<% }}catch(Exception e){} %>

		</select>
		</div>
      </div>
    </div>
    
    <div class="col">
      <div class="form-outline">
      	<div class="form-group col-md-6">
      		<label for="inputEmail4">&emsp;ID &emsp;&emsp;Item Name</label>
      			<select class="form-select form-select-lg" style="padding: 10px; border-radius: 10px;" name="Item">
					<% try{
						Class.forName("com.mysql.jdbc.Driver");    
        				String url="jdbc:mysql://localhost:3306/mydb_mysql";    
        				String user="root";    
        				String password="root";    
        				Connection con=DriverManager.getConnection(url, user, password); 
        				Statement st = con.createStatement();
        				String query = "select * from item";
        				ResultSet rs = st.executeQuery(query);
        
        				while (rs.next()){
        					%>
        					<option><%=rs.getString("Item_Id") %> | &emsp;&emsp; <%=rs.getString("Name") %>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; ₹<%=rs.getString("Selling_Price") %> </option>
        	
        					<% }}catch(Exception e){} %>
				</select>
        </div>
      </div>
    </div>
    
  </div>


 <!-- Text input -->
  <div class="form-outline mb-4">
    <input type="number" id="form6Example4" class="form-control" name="Quantity" min="1" placeholder="Enter Quantity"/>
  </div>


 <!-- Submit button -->
  		<button type="submit" class="btn btn-primary btn-block mb-4">Place Order</button>
	</form>
  </body>
</html>