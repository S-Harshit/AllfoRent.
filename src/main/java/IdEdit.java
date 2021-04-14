

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
 * Servlet implementation class IdEdit
 */
public class IdEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdEdit() {
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
			PreparedStatement ps = con.prepareStatement("UPDATE personalinfo Set id = ?  WHERE id = ?");
			if(name!=null) {
			ps.setString(1, name);
			ps.setString(2, id);
			out.print("id=" + name + "</br>");
			out.print("id = "+ id);
			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("editprofie.jsp");  
	        rd.include(request, response);  
	        out.println("Id Changed Succesfully");
	    	if(session.getAttribute("owner")!=null ) {
	    		
				session.setAttribute("owner", name);
			
			}
			else if(session.getAttribute("customer")!=null) {
				session.setAttribute("owner", name);
			}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
