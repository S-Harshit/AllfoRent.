

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer Integertracker;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		PrintWriter out = response.getWriter();
		String customer = null; 
		String name;
		boolean flag = false;
		  	
		
		
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent","root","qwerty"); //JDBC CONNECTION
			PreparedStatement ps = conn.prepareStatement("select * from personalinfo");  
		    ResultSet st = ps.executeQuery();
		    
		    while (st.next()) {
		    	String ids = st.getString("id");
		    	String password = st.getString("password");
		    	if(ids.equals(id) && password.equals(pass)) { // if id and password match from database flag will turn true else false
		    		flag = true;
		    		HttpSession session = request.getSession();  
		    		customer = st.getString("customer");
		    		name = st.getString("fullname");
		    		
		    		if(customer.equals("1")) {
						session.setAttribute("customer", id);
						session.setAttribute("Name", name);
						}
					else {
						session.setAttribute("owner", id);
						session.setAttribute("Name", name);
						
						
					}
		    	
		    	}
		    }
		    
		    if(flag == true && customer.equals("0")) {
		    	RequestDispatcher rd=request.getRequestDispatcher("owner.jsp");  
		        rd.include(request, response);  
		        out.print(customer);
//		    	out.println("<html>");
//	    		out.println("<head></head>");
//	    		out.println("<body><h2>Hello from Servlet!!Hello! You Have Succesfully logged in</h2>");
//	    		Date today = new Date();
//	    		out.println("<h3 algin = center> Today's Date is: </h3>"+today);
//	    		HttpSession session = request.getSession();  
//	    		
//	    		if(session.getAttribute("owner") == null && session.getAttribute("customer") == null)  { 
//	      			out.print("NOT LOGGED IN");
//	      		}
//	      		else {      	
//	      	 	out.print("Welcome\n" + session.getAttribute("Name")+"\n");
//	      		}
//	    		out.println("</body></html>");
//	    		out.flush();
//	    	
		    }
		    else if(flag == true && customer.equals("1")) {
		    	RequestDispatcher rd=request.getRequestDispatcher("customer.jsp");  
		        rd.include(request, response);
		    }
		    
		    else {
		    	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
		        rd.include(request, response);  
//		    	out.println("<html>");
//	    		out.println("<head><title></title></head>");
	    		out.println("<h4 align=\"center\" valign=\"top\">Username and Password didn't Match To AnyExistsent Account</h4>;");
//	    		out.println(customer);
	    //		out.println("</html>");
		    }
		     
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		 
	}

}
