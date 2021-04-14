<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner Profile</title>


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









</head>
<body>




  <div class="head">
  <a href="#" class="logo"><img src="AllfoRentlogo.png" alt="Logo Image Not Found" ></a>
  </div>





<% 
response.setContentType("text/html");

//retreiving session details
HttpSession ses = request.getSession(); 
String id = ses.getAttribute("owner").toString();
//String id = "1";

//adding new details to session object **no need
//ses.setAttribute("owner", id);
//ses.setAttribute("name","a");

boolean flag=true;

//add and logout button
out.println("<div align='right'><Form method='post' action='add.jsp'><input type='submit' value='Add'  class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\"></Form><Form method='post' action='/AllfoRent/Logout'><input type='submit' value='Logout'  class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\"></Form><Form method='post' action='editprofie.jsp'><input type='submit' value='Edit Profile'  class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\"></Form></div><br><br>");


Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent", "root", "qwerty");
Statement stmt1 = con.createStatement();
Statement stmt2 = con.createStatement();


//compare owner ID in houses table
String query1 = "select ownerID from houses";
ResultSet rs1 = stmt1.executeQuery(query1);
out.println("<h4>Image</div>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Locality&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Type&emsp;&emsp;&emsp;Price Per Month&emsp;&emsp;Area in sq. feet&emsp;&emsp;Interior Type&emsp;&emsp;&emsp;House ID&emsp;&emsp;&emsp;<div style=\"float: right; width: 130px\"> Options</div></h4><br>");

//print the matching details
while(rs1.next()&&flag){
	String ownerID = rs1.getString("ownerID");
	if(ownerID.equals(id)){
		String query2="select * from houses where ownerID = "+"'"+ownerID+"'";
		ResultSet rs2 = stmt2.executeQuery(query2);
		while(rs2.next()){
			out.println("<form method='post' action='/AllfoRent/GetImage'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'><div style=\"float: left; width: 360px\"><input type='submit' value='View Image'/></div></form><h5><div style=\"float: left; width: 200px\">"+rs2.getString(2)+"</div><div style=\"float: left; width: 140px\">"+rs2.getString(3)+"</div><div style=\"float: left; width: 200px\">  "+rs2.getDouble(4)+"</div><div style=\"float: left; width: 130px\"> "+rs2.getDouble(5)+"</div><div style=\"float: left; width: 180px\"> "+rs2.getString(6)+"</div><div style=\"float: left; width: 130px\"></h5> "+rs2.getString(9)+"</div><div align='right'><Form method='post' action='/AllfoRent/DeleteProcess'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'><input type='submit' value='Delete' ></Form><Form method='post' action='update.jsp'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'><input type='submit' value='Update'></Form></div>"+"<br>");
		}
		rs2.close();
		flag=false;
	}
}

//closing resources
rs1.close();
stmt1.close();
stmt2.close();
con.close();

%>








<footer class="w3-container w3-padding-64 w3-center w3-opacity">  
  <div class="w3-xlarge w3-padding-32">
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
    <i class="fa fa-pinterest-p w3-hover-opacity"></i>
    <i class="fa fa-twitter w3-hover-opacity"></i>
    <i class="fa fa-linkedin w3-hover-opacity"></i>
 </div>
</footer>
     









</body>
</html>