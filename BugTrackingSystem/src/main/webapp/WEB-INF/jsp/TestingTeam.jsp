<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>BUG TRACKING SYSTEM</title>
  <meta charset="utf-8">
  <meta http-equiv="Cache-control" content="no-cache">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#AddBug").click(function(){
    $("#div1").load("AddBug");
  });
  $("#UpdateBug").click(function(){
	    $("#div1").load("UpdateBug");
	  });
  $("#UpdateProfile").click(function(){
	    $("#div1").load("UpdateProfile");
	  });
});
</script>
  <style>
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    .row.content {height: 450px}
    
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a id="AddBug">ADD NEW BUG</a></li>
        <li><a id="UpdateBug">UPDATE BUG STATUS</a></li>
         <li><a id="UpdateProfile">UPDATE PROFILE</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout">LOGOUT</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    
    <div class="col-sm-12 text-left"> 
      <div id="div1"></div>

    </div>
    
  </div>
</div>
<p>${sessionScope.admin}</p>

<footer class="container-fluid text-center">
</footer>

</body>
</html>