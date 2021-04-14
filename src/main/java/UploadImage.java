

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UploadImage
 */
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() {
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
		
		String id = request.getParameter("id");
		
		String query = "select * from personalinfo where id='"+id+"'";
		

		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent","root","qwerty");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			 if(rs.next()) {
				 
				 Blob blob = rs.getBlob(5);
					byte image[]=blob.getBytes(1,(int)blob.length());
					
					response.setContentType("image/gif");
			
					OutputStream o = response.getOutputStream();
					o.write(image);
					
					o.flush();
					o.close();
			 }
		  
		  
		  }
		  catch(Exception e) {
			  
			  e.printStackTrace();
		  }
	}
	
	
	

}
