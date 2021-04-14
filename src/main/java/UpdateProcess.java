

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpdateProcess
 */
@WebServlet("/UpdateProcess")
@MultipartConfig(maxFileSize = 100000000)
public class UpdateProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProcess() {
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
		
		//to get image input
		Part part = request.getPart("pic");
		InputStream pic = part.getInputStream();
		
		//to get other fields
		Double price = 0.0;
		Double area = 0.0;
		
		String locality = request.getParameter("locality");
		String type = request.getParameter("type");
		String price1 = request.getParameter("price");
		String area1 = request.getParameter("area");
		String name = request.getParameter("name");
		String houseID = request.getParameter("houseID");
				
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent", "root", "qwerty");
			String query = "select * from houses where houseID = '"+houseID+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			//for adding new row
			PreparedStatement ps = con.prepareStatement("update houses set pic=?, locality=?, type=?, price=?, area=?, name=?, owner=?, ownerID=? where houseID=?");
			rs.next();
			
			price=rs.getDouble(4);
			area=rs.getDouble(5);

			if(locality.equals("")) {
				locality=rs.getString(2);
			}
			if(!price1.equals("")) {
				price = Double.parseDouble(price1);
			}
			if(!area1.equals("")) {
				area= Double.parseDouble(area1);
			}
			
			ps.setBlob(1, pic);
			ps.setString(2, locality);
			ps.setString(3, type);
			ps.setDouble(4, price);
			ps.setDouble(5, area);
			ps.setString(6, name);
			ps.setString(7, owner);
			ps.setString(8, ownerID);
			ps.setString(9, houseID);

			ps.executeUpdate();
			
			//closing resources
			pic.close();
			ps.close();
			stmt.close();
			rs.close();
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
