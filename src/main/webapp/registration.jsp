<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>

<link rel="stylesheet" type="text/css" href="styling.css">
  <link rel="stylesheet" href="css/style.css">
<title>Sign Up</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
</style>
<!--<style>
img {
  width: 100%;
}-->
</style>
</head>

 
<body>







<div class="head">
  <a href="	index.jsp" class="logo"><img src="AllfoRentlogo.png" alt="Logo Image Not Found"></a>
</div>

<div class="registration">
<form method="post" action = "RegistrationHandler">
 <p class="sign" align="center">AllfoRent</p>
	<input class = "un" type = "text" name="fullname" placeholder="Full Name" required/><br /><br />
  	<input class = "un" type = "text" name="id" placeholder="Email or Phone No." required/><br /><br />
    <input class = "pass" type="password" name="password" placeholder="Password"required/><br /><br />
    <input class = "pass" type="password" name="repassword" placeholder="Retype Password" required/><br />
   
  <p class ="radiooc" >	
    <input type="radio"  name="customer" value="TRUE"/> Customer
    <input type="radio" name="customer" value="FALSE"/> Owner 
 </p>

  <input type="hidden" name="secret" value="888" />
  <div align="center"><input class = "w3-button w3-black w3-padding-large w3-large w3-margin-top" name="submit" type = submit value="SignUp" /><br><br></div>
  <div align="center"><a  href="login.jsp"><h5>Already Have An Account? Login Here</h5> </a></div>
  
</form>
</div>


<!-- debugging purpose
<h2>Session ID:</h2><% out.print(session.getId());%>
-->

</body>
</html>