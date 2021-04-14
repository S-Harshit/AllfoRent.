

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddImage
 */
@WebServlet("/AddProcess")
@MultipartConfig(maxFileSize = 100000000)
public class AddImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddImage() {
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
		HttpSession session = request.getSession();
		String id;
		if(session.getAttribute("customer")!=null) {
		 	id = (String)session.getAttribute("customer");
		 	
			}
		else {	
			id = (String)session.getAttribute("owner");	
				
			 	
			}
		
		Part part = request.getPart("pic");
		InputStream pic = part.getInputStream();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent", "root", "qwerty");
			
			
			//for adding new row
			PreparedStatement ps = con.prepareStatement("update personalinfo set displaypicture =? where id='"+id+"'");
			ps.setBlob(1, pic);
			ps.executeUpdate();
			
			//closing resources
			pic.close();
			ps.close();
			con.close();
			
			//redirecting to owner.jsp
			
			
			if(session.getAttribute("customer")!=null) {
			 
			 	response.sendRedirect("customer.jsp");
			 	
				}
			else {	
			
				response.sendRedirect("owner.jsp");
					
				 	
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
