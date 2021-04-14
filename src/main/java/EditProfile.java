

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditProfile
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		if(session.getAttribute("owner") != null || session.getAttribute("customer") != null) {
		
			//out.println(request.getParameter("name"));
			
    		if(request.getParameter("submit").equals("Editname")) {
    			out.print("<html>\r\n" + 
    					"<head>\r\n" + 
    					"<meta charset=\"ISO-8859-1\">\r\n" + 
    					"<title>Owner Profile</title>\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"<link rel=\"stylesheet\" type=\"text/css\" href=\"styling.css\">\r\n" + 
    					" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n" + 
    					" \r\n" + 
    					" \r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					" <!--w3 ones-->\r\n" + 
    					" \r\n" + 
    					" \r\n" + 
    					" <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n" + 
    					"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\r\n" + 
    					"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\r\n" + 
    					"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
    					"<style>\r\n" + 
    					"body,h1,h2,h3,h4,h5,h6 {font-family: \"Lato\", sans-serif}\r\n" + 
    					".w3-bar,h1,button {font-family: \"Montserrat\", sans-serif}\r\n" + 
    					".fa-anchor,.fa-coffee {font-size:100px}\r\n" + 
    					"</style>\r\n" + 
    					" <!--               /////////////////////////////////// -->\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"</head>\r\n" + 
    					"<body>\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"  <div class=\"head\">\r\n" + 
    					"  <a href=\"#\" class=\"logo\"><img src=\"AllfoRentlogo.png\" alt=\"Logo Image Not Found\" ></a>\r\n" + 
    					"  </div>\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"");
    			out.println("<html>");
        		out.println("<head></head>");
        		out.println("<body><div align=\"center\"><h2>Enter New Name</h2></div>");
        		out.println("<form class=\"form1\" method = \"post\" action=\"NameEdit\">");
        		
    		out.println("<input name=\"name\"  class =\"un\" type=\"text\" placeholder=\"Full Name\" required=\"required\">");
    		}
    		
    		else if(request.getParameter("submit").equals("Editpassword")) {
    			out.println("\r\n" + 
    					"\r\n" + 
    					"<link rel=\"stylesheet\" type=\"text/css\" href=\"styling.css\">\r\n" + 
    					" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n" + 
    					" \r\n" + 
    					" \r\n" + 
    					" <!--w3 ones-->\r\n" + 
    					" \r\n" + 
    					" \r\n" + 
    					" <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n" + 
    					"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\r\n" + 
    					"<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\r\n" + 
    					"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
    					"<style>\r\n" + 
    					"body,h1,h2,h3,h4,h5,h6 {font-family: \"Lato\", sans-serif}\r\n" + 
    					".w3-bar,h1,button {font-family: \"Montserrat\", sans-serif}\r\n" + 
    					".fa-anchor,.fa-coffee {font-size:100px}\r\n" + 
    					"</style>\r\n" + 
    					" <!--               /////////////////////////////////// -->\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"  <div class=\"head\">\r\n" + 
    					"  <a href=\"#\" class=\"logo\"><img src=\"AllfoRentlogo.png\" alt=\"Logo Image Not Found\"  width=\"200\" height=\"200\" ></a>\r\n" + 
    					"  </div>\r\n" + 
    					"\r\n" + 
    					"\r\n" + 
    					"");
    			out.println("<html>");
        		out.println("<head></head>");
        		out.println("<body><h2>Enter New Password</h2>");
        		out.println("<form  class=\"form1\" method = \"post\" action=\"PasswordEdit\"><input name=\"name\" type=\"password\" class =\"un\" type=\"text\" placeholder=\"New Password\" required=\"required\">");
        		out.println("<input name=\"name\"  class =\"un\" type=\"password\" placeholder=\"Confirm\" required=\"required\">");
    			 out.println();
 
    		}
    		
    		out.println("<div align=\"center\"><input  class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\" \name =\" submit\" type=submit value=\"CONFIRM EDIT\"></form></div>");
    		out.println("</body></html>");
    		
    		out.flush();
		} 
		
			
		
	}

}
