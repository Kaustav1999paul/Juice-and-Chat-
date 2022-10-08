

import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;


@WebServlet(
		
		urlPatterns="/LoginPage",
		initParams = {
			@WebInitParam(name="user", value = "java@gmail.com"),
			@WebInitParam(name="pass", value = "1999")
		}
		
		)
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginPage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out  = response.getWriter();
		
		ServletConfig conf = getServletConfig();
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		String username = conf.getInitParameter("user");
		String password = conf.getInitParameter("pass");
		
		if(username.equalsIgnoreCase(user) && password.equalsIgnoreCase(pass)) {
			response.sendRedirect("SuccessfulAuth.html"); 
		}else {
			out.println("Auth Unsuccessful");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
