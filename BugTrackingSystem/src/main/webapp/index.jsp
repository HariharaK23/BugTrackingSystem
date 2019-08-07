<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>




<html>
    <head>
        <title>Bug Tracker</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
    
*{
    margin: 0;
    padding:0;
    box-sizing: border-box;
}
body{
    overflow: hidden;
}
header{
    background-color: skyblue;
    padding: 2%;
    color: white;
    font-weight: bold;
}
.container{
    height: 100vh;
    background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url('../images/banner.jpg');
    background-size: cover;
}
.title{
    text-align: center;
    padding-top: 15%;
}
.title h1{
    font-size: 500%;
    color:white;
    
    </style>
    <body>
        <header>
            <nav><h1>BTS</h1></nav>
        </header>
        <section class="container">
            <div class="title">
                <h1>BUG TRACKING SYSTEM</h1>
            </div>
            <form action="login">
            <button type="submit">ADMIN</button>
            </form>
            <form action="emplogin">
            <button type="submit">EMPLOYEE</button>
            </form>
        </section>     
    </body>
</html>