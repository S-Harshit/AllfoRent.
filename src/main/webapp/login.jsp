<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

      
 <html>  

 
<head>
<link rel="stylesheet" type="text/css" href="styling.css">
 <meta name="viewport" content="width=device-width, initial-scale=1" />
 
 
 <!--custom ones-->
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
  <title>Sign in</title>
</head>

<body>



<!--  FOR DEBUGING PURPOSE
<% 
  		if(session.getAttribute("owner") == null && session.getAttribute("customer") == null)  { 
  			out.print("NOT LOGGED IN");
  		}
  		else {
  		if(session.getAttribute("customer") != null) {
  		out.print("Logged in as \n" + session.getAttribute("customer")+"\n");
  		}
  		else {
  		out.print("Logged in as \n" + session.getAttribute("owner")+"\n");
  		}
  	 	out.print("Welcome\n" + session.getAttribute("Name")+"\n");
  		}
  %>
  <h2>Session ID:</h2><% out.print(session.getId());%>
     
  -->
  




  <div class="head">
  <a href="index.jsp" class="logo"><img src="AllfoRentlogo.png" alt="Logo Image Not Found"  width="200" height="200" ></a>
  </div>

  <div class="login">
   
    <form class="form1" method = "post" action="Login">
     <p class="sign" align="center">AllfoRent</p>
      <input name="id"  class ="un" type="text" placeholder="Email or Phone No." required="required">
      <input name = "password" class="pass" type="password" placeholder="Password" required="required">
      <div align="center"><input class = "w3-button w3-black w3-padding-large w3-large w3-margin-top" name="submit" type = submit value="Sign In" /><br><br></div>
        <div align="center"><a  href="registration.jsp"><h5>Already Have An Account? Register Here</h5></a></div>
    </form>         
    </div>
     
     
     
     
     
     
     
     
     
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
 
 
 
 <p>Help Taken by Harshit From  <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>
     
     
     
     
     
</body>

</html>

   
 