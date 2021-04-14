<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>








<link rel="stylesheet" type="text/css" href="styling.css">
 <meta name="viewport" content="width=device-width, initial-scale=1" />
 
 
 <!--w3 ones-->
 
 
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:100px}
</style>
 <!--               /////////////////////////////////// -->




  <div class="head">
  <a href="#" class="logo"><img src="AllfoRentlogo.png" alt="Logo Image Not Found"  width="200" height="200" ></a>
  </div>

















</head>

<body>



	<jsp:declaration>
		String type = "";
		String name = "";
		String number = "";
	</jsp:declaration>

	<jsp:scriptlet>
	    type = request.getParameter("type");
		name = request.getParameter("name");
		number = request.getParameter("price");
    </jsp:scriptlet>

	<h1></h1>
	<%
	
	
	out.println("<h4>Image</div>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Locality&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Type&emsp;&emsp;&emsp;Price Per Month&emsp;&emsp;Area in sq. feet&emsp;&emsp;Interior Type&emsp;&emsp;&emsp;House ID&emsp;&emsp;&emsp;<div style=\"float: right; width: 130px\"> </div></h4><br>");

		String[] price = number.split("-");

	int from = Integer.parseInt(price[0]);
	int till = Integer.parseInt(price[1]);

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent", "root", "qwerty");
	Statement stmt1 = con.createStatement();
	String query1 = "SELECT * FROM houses WHERE type=? AND name=? AND number "; 
	
	String query = null;
	
	if(type.equals("Select type") && !name.equals("Select BHKs") && number != null){
		query = "SELECT * FROM houses WHERE name = " + "\"" + name + "\" and price"+ " BETWEEN \""
				+ from + "\"" + "AND"  + "\"" +  till+ "\"";
		
	}else if(!type.equals("Select type") && name.equals("Select BHKs") && number != null){
		query = "SELECT * FROM houses WHERE type = " + "\"" + type + "\" and price"+ " BETWEEN \""
				+ from + "\"" + "AND"  + "\"" +  till+ "\"";
		
	}else if(!type.equals("Select type") && !name.equals("Select BHKs") && number != null){
		query = "SELECT * FROM houses WHERE type = " + "\"" +type + "\"" + " AND " + "name=\"" + name + "\" and \"" + number + "\" BETWEEN \""
				+ from + "\"" + "AND"  + "\"" +  till+ "\"";
		
	}else if(type.equals("Select type") && name.equals("Select BHKs") && number != null){
		query = "SELECT * FROM houses WHERE price BETWEEN \"" + from +"\" "+  " AND "  + "\"" +  till + "\"";
	}

	//String command = "SELECT * FROM houses WHERE type = " + "\"" +type + "\"" + " AND " + "name=\"" + name + "\" and \"" + number + "\" BETWEEN \""
   // 	+ from + "\"" + "AND"  + "\"" +  till+ "\"";
	
	ResultSet rs2 = stmt1.executeQuery(query);
	try {
		while (rs2.next()) {
			
			response.setContentType("text/html");
			/* out.println("<form method='post' action='/AllfoRent/GetImage'><input type='hidden' name='houseID' value= '"
			+ rs.getString(9) + "'><div style=\"float: left; width: 360px\"><input type='submit' value='View Image'/></div></form>" + rs.getString(2) + "  "
			+ rs.getString(3) + "  " + rs.getDouble(4) + "  " + rs.getDouble(5) + "  " + rs.getString(6) + " "
			+ rs.getString(9)
			+ "<div align='right'><Form method='post' action='/AllfoRent/DeleteProcess'><input type='hidden' name='houseID' value= '"
			+ rs.getString(9)
			+ "'></Form><Form method='post' action='update.jsp'><input type='hidden' name='houseID' value= '"
			+ rs.getString(9) + "'></Form></div>" + "<br>");
 */
 
			out.println("<form method='post' action='/AllfoRent/GetImage'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'><div style=\"float: left; width: 360px\"><input type='submit' value='View Image'/></div></form><h5><div style=\"float: left; width: 200px\">"+rs2.getString(2)+"</div><div style=\"float: left; width: 140px\">"+rs2.getString(3)+"</div><div style=\"float: left; width: 200px\">  "+rs2.getDouble(4)+"</div><div style=\"float: left; width: 130px\"> "+rs2.getDouble(5)+"</div><div style=\"float: left; width: 180px\"> "+rs2.getString(6)+"</div><div style=\"float: left; width: 130px\"></h5> "+rs2.getString(9)+"</div><div align='right'><Form method='post' action='/AllfoRent/DeleteProcess'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'></Form><Form method='post' action='update.jsp'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'></Form></div>"+"<br>");
			
 
 
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		rs2.close();
		con.close();

	}
	%>
	
	
	

     <!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity">  
  <div class="w3-xlarge w3-padding-32">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
 </div>
 

	
</body>
</html>