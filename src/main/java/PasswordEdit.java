

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PasswordEdit
 */
public class PasswordEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		PrintWriter out = response.getWriter();
		out.println("HELLO FROM SERVLET");
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		
		
//IT CHECKS WETHER IT IS OWNER OR CUSTOMER AND EXECTUES THE QUERY RESPECTIVELY
		String name = request.getParameter("name");
		String id="";
		if(session.getAttribute("owner")!=null ) {
		
			id = (String) session.getAttribute("owner");
		
		}
		else if(session.getAttribute("customer")!=null) {
			 id = (String) session.getAttribute("customer");
		}
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
			e.printStackTrace();
				}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent","root","qwerty");
			PreparedStatement ps = con.prepareStatement("UPDATE personalinfo Set password = ?  WHERE id = ?");
			if(name!=null) {
			ps.setString(1, name);
			ps.setString(2, id);
			out.print("Password=" + name + "</br>");
			out.print("id = "+ id);
			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("editprofie.jsp");  
	        rd.include(request, response);  
	        out.println("Password Changed Succesfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
	}

}
