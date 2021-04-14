

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class addProcess
 */
@WebServlet("/AddProcess")
@MultipartConfig(maxFileSize = 100000000)
public class AddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//getting session details
		HttpSession ses = request.getSession();
		
		String owner = (String) ses.getAttribute("Name");
		String ownerID = (String) ses.getAttribute("owner");
		
		//to get image from user
		Part part = request.getPart("pic");
		InputStream pic = part.getInputStream();
		
		//other fields
		String locality = request.getParameter("locality");
		String type = request.getParameter("type");
		Double price = Double.parseDouble(request.getParameter("price"));
		Double area = Double.parseDouble(request.getParameter("area"));
		String name = request.getParameter("name");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent", "root", "qwerty");
			
			
			//for adding new row
			PreparedStatement ps = con.prepareStatement("insert into houses(pic,locality,type,price,area,name,owner,ownerID) values(?,?,?,?,?,?,?,?)");
			ps.setBlob(1, pic);
			ps.setString(2, locality);
			ps.setString(3, type);
			ps.setDouble(4, price);
			ps.setDouble(5, area);
			ps.setString(6, name);
			ps.setString(7, owner);
			ps.setString(8, ownerID);
			ps.executeUpdate();
			
			//closing resources
			pic.close();
			ps.close();
			con.close();
			
			//redirecting to owner.jsp
			response.sendRedirect("owner.jsp");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
