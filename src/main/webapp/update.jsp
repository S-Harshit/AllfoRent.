<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
 








<title>Owner Profile</title>
</head>
<body>




<!--THIS IS FOR HEADER -->
 <div class="head">
  <a href="#" class="logo"><img src="AllfoRentlogo.png" alt="Logo Image Not Found" ></a>
  </div>
<!--  -->


<%
String houseID = request.getParameter("houseID");

out.println("<form action='/AllfoRent/UpdateProcess' method='post' enctype='multipart/form-data'><input type='hidden' name = 'houseID' value='"+houseID+"'/><br><br><table align=\"center\" border='1'><tr><td>House photo: </td><td><input type='file' name='pic' required='required' size='100' accept='image/*'/></td></tr><tr><td>Location of house: </td><td><input type='text' name='locality' size='100'/></td></tr><tr><td>Type of the house: </td><td><select name='type' > <option>Flat <option>Villa <option>PG <option>Office Space <option>Shop</select></td></tr><tr><td>Price per month in Rupee: </td><td><input type='number' step='any' name='price' size='100' /></td></tr><tr><td>Area in square feet: </td><td><input type='number' step='any' name='area' size='100' /></td></tr><tr><td>Interior type: </td><td><select name = 'name' > <option>1 BHK <option>2 BHK <option>3 BHK <option>4 BHK <option>5 BHK <option>6 BHK <option>7 BHK <option>8 BHK <option>9 BHK <option>10 BHK</select></td></tr><tr><td colspan='2' align='center'><input type='submit' value='Update'></td></tr></table></form>");
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
 <p>Help Taken From  <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>
     

</body>
</html>