

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Servlet implementation class GetImage
 */
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetImage() {
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

		//retrieving session details
		HttpSession ses = request.getSession(); 
		String id = ses.getAttribute("owner").toString();

		String houseID = request.getParameter("houseID");


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent", "root", "qwerty");
			Statement stmt1 = con.createStatement();
			Statement stmt2 = con.createStatement();
	
	
			//compare owner ID in houses table
			String query2 = "select ownerID from houses";
			ResultSet rs1 = stmt1.executeQuery(query2);
			
			Blob blob=null;
			OutputStream o =null;
			byte image[]=null;
	
			//acquiring image according to session details
			while(rs1.next()){
				String ownerID = rs1.getString("ownerID");
				if(ownerID.equals(id)){
					String query3="select * from houses where ownerID = "+"'"+ownerID+"' and houseID='"+houseID+"'";
					ResultSet rs2 = stmt2.executeQuery(query3);
					while(rs2.next()){
						
						blob = rs2.getBlob(1);
						image=blob.getBytes(1,(int)blob.length());
						
						response.setContentType("image/gif");
				
						o = response.getOutputStream();
						o.write(image);
						
						o.flush();
						o.close();
						
					}
					
					rs2.close();
				}
			}
	
			//closing resources
			rs1.close();
			stmt1.close();
			stmt2.close();
			con.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
