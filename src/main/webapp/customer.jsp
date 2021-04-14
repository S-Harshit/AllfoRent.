<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Houses</title>






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
<%

out.println("<div align=\"right\"></Form><Form method='post' action='/AllfoRent/Logout'><input type='submit' value='Logout' class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\"></Form><Form method='post' action='editprofie.jsp'><input type='submit' value='Edit Profile'   class = \"w3-button w3-black w3-padding-large w3-large w3-margin-top\"></Form></div>");

%>>

<body>
	<form action="SearchResult.jsp" method="post">
	<br><br><br>
		<table align="center" style="width: 50%" border="1" >

			<tr align="center">
				<th>Filter by type of house</th>
				<th>Filter by Interior</th>
				<th>Filter by Price</th>
			</tr>

			<tr align="center">
				 <td><select name="type" > <option>Select type<option>Flat <option>Villa <option>PG <option>Office Space <option>Shop</select></td>
                 <td><select name = "name" ><option>Select BHKs<option>1 BHK <option>2 BHK <option>3 BHK <option>4 BHK <option>5 BHK <option>6 BHK <option>7 BHK <option>8 BHK <option>9 BHK <option>10 BHK</select></td>
                 <td><input type="type" step="any" name="price" size="100" placeholder="Search Price range Seprated By(-)"/></td>
			</tr>
			
		</table>
		<div align="center"><br><input type="submit" value='Search'></div>
		<br><br>
	</form>
<% 

//retreiving session details
HttpSession ses = request.getSession();
//change attribute according to harshit session
String id = ses.getAttribute("customer").toString();
//String name= ses.getAttribute("Name").toString();
//String id = "1";

 

boolean flag=true;



Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/allforent", "root", "qwerty");
Statement stmt1 = con.createStatement();
Statement stmt2 = con.createStatement();


//compare owner ID in houses table
String query2 = "select ownerID from houses";
ResultSet rs1 = stmt1.executeQuery(query2);
//out.println("Image&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Locality&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Type&emsp;&emsp;&emsp;Price Per Month&emsp;&emsp;Area in sq. feet&emsp;&emsp;Interior Type&emsp;&emsp;&emsp;House ID&emsp;&emsp;&emsp;Options<br>");
out.println("<h4>Image</div>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Locality&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Type&emsp;&emsp;&emsp;Price Per Month&emsp;&emsp;Area in sq. feet&emsp;&emsp;Interior Type&emsp;&emsp;&emsp;House ID&emsp;&emsp;&emsp;<div style=\"float: right; width: 130px\"></div></h4><br>");

//add and logout button




//print the matching details
while(rs1.next()&&flag){
	String ownerID = rs1.getString("ownerID");
	
		String query3="select * from houses";// where ownerID = "+"'"+ownerID+"'";
		ResultSet rs2 = stmt2.executeQuery(query3);
		while(rs2.next()){
			response.setContentType("text/html");
			//out.println("<img src='getImage.jsp' width='200px'/>"+rs2.getString(2)+"  "+rs2.getString(3)+"  "+rs2.getDouble(4)+"  "+rs2.getDouble(5)+"  "+rs2.getString(6)+" "+rs2.getString(9)+"<div align='right'><Form method='post' action='/AllfoRent/DeleteProcess'><input type='hidden' name='houseID' value= '"+houseID+"'><input type='submit' value='Delete'></Form></div>"+"<br>");
			
			
			out.println("<form method='post' action='/AllfoRent/GetImage'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'><div style=\"float: left; width: 360px\"><input type='submit' value='View Image'/></div></form><h5><div style=\"float: left; width: 200px\">"+rs2.getString(2)+"</div><div style=\"float: left; width: 140px\">"+rs2.getString(3)+"</div><div style=\"float: left; width: 200px\">  "+rs2.getDouble(4)+"</div><div style=\"float: left; width: 130px\"> "+rs2.getDouble(5)+"</div><div style=\"float: left; width: 180px\"> "+rs2.getString(6)+"</div><div style=\"float: left; width: 130px\"></h5> "+rs2.getString(9)+"</div><div align='right'><Form method='post' action='/AllfoRent/DeleteProcess'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'></Form><Form method='post' action='update.jsp'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'></Form></div>"+"<br>");
		
			//out.println("<form method='post' action='/AllfoRent/GetImage'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'><div style=\"float: left; width: 360px\"><input type='submit' value='View Image'/></div></form>"+rs2.getString(2)+"  "+rs2.getString(3)+"  "+rs2.getDouble(4)+"  "+rs2.getDouble(5)+"  "+rs2.getString(6)+" "+rs2.getString(9)+"<div align='right'><Form method='post' action='/AllfoRent/DeleteProcess'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'></Form><Form method='post' action='update.jsp'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'></Form></div>"+"<br>");
		}
		rs2.close();
		flag=false;
}

//closing resources
rs1.close();
stmt1.close();
stmt2.close();
con.close();

%>
<%-- <form method='post' action='/AllfoRent/GetImage'><input type='hidden' name='houseID' value= '"+rs2.getString(9)+"'><input type='submit' value='View Image'/></form> --%>







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