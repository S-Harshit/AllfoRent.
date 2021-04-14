

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationHandler
 */
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationHandler() {
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
	 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent","root","qwerty");  
			PreparedStatement ps = con.prepareStatement("insert into personalinfo values(?,?,?,?,?)");  
			HttpSession session=request.getSession();  
			String  id= request.getParameter("id"); 
			String name = request.getParameter("fullname"); 
			String password = request.getParameter("password"); 
			String repassword = request.getParameter("repassword"); 
			String customer = request.getParameter("customer"); 
			String subcheck = request.getParameter("submit");
			String owner = request.getParameter("owner");

			if(password.equals(repassword)) {
				
			
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,password);


			if(customer.equals("TRUE")) {
				ps.setInt(4,1);	
//				session.setAttribute("customer", id);
//				session.setAttribute("Name", name);
				}
			else {
				ps.setInt(4,0);
//				session.setAttribute("owner", id);
//				session.setAttribute("Name", name);
//				
			}
			
			
			ps.setString(5,"NULL");

			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	        rd.include(request,response);  
	    	out.println("<html>");
    		out.println("<head><title></title></head>");
			out.println("<body><div align=\"center\"><h4>Sign up Succesfull! Please Login To Continue!<h4><div></body>");
			out.print("</html>");
			
			
			}
			else {
				
				RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");  
		        rd.include(request,response);  
		    	out.println("<html>");
	    		out.println("<head><title></title></head>");
				out.println("<body><div align=\"center\"><h4>Passwords Didn't Match!<h4><div></body>");
				out.print("</html>");
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
	}

}
