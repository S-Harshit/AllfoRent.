<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styling.css">
<meta charset="ISO-8859-1">






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
  <a href="#" class="logo"><img src="AllfoRentlogo.png" alt="Logo Image Not Found" ></a>
  </div>







<title>Insert title here</title>
</head>
<body>


<%@page import="java.sql.*" %>
<%
String id;


if(session.getAttribute("customer")!=null) {
 	id = (String)session.getAttribute("customer");
 	out.println("<div align=\"right\"><a href=\"customer.jsp\"><h4>Go Back</h4></a><d/iv>");
	}
else {	
	id = (String)session.getAttribute("owner");	

	out.println("<div align=\"right\"><a href=\"owner.jsp\"><h4>Go Back</h4></a><d/iv>");
	 	
	}

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent","root","qwerty");  
	PreparedStatement ps = con.prepareStatement("select * from personalinfo where id= ?");  
	ps.setString(1, id);
	
	ResultSet st = ps.executeQuery();
	while(st.next()) {
	
	
	out.println("<div align=\"center\"><h2>ID : "+st.getString("id")+"</h2></div>");
	out.println("<div align=\"center\"><h2>FullName : "+st.getString("fullname")+"</h2>");
	
	}
	

} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}  

%>


<% 

if(session.getAttribute("customer")!=null) {
 	id = (String)session.getAttribute("customer");
 	
	}
else {	
	id = (String)session.getAttribute("owner");	
		
	 	
	}
out.print("<div align=\"center\"><form method=\"Post\" action =\"/AllfoRent/EditProfile\"><input name =\"submit\" value=\"Editname\" type=\"submit\"  class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\">  <input name =\"submit\" value=\"Editpassword\" type=\"submit\"  class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\"></form></div>");
out.print("<div align=\"center\"><form method = \"post\" action = \"/AllfoRent/UploadImage\"><input name =\"submit\" value=\"Profile Picture\" type=\"submit\"   class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\"><input name =\"id\" type=\"hidden\"  value='"+id+"' ></form></div>");
out.print("<div align=\"center\"><form method= \"post\" action = \"/AllfoRent/AddImage\" enctype=\"multipart/form-data\"><input type=\"submit\" value=\"Upload Image\"  class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\"><br><input type=\"file\" name = 'pic' required ='required' accect='image/* '></form></div>");


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