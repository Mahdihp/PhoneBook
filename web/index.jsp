<%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 8/31/18
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./static/css/materialize.css">
    <script src="./static/js/materialize.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Phone Book</title>
</head>
<body onload="loadContact()">

<style>
    body {
        font-family: IRANSans;
    }
</style>
<div class="container">
    <div class="row">
        <div class="col s12">
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo right"> </a>
                    <ul id="nav-mobile" class="left hide-on-med-and-down">
                        <li><a href="#">لیست مخاطبین</a></li>
                        <li><a href="#">مخاطب جدید</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <br>

    <div class="row" id="contactList">


    </div>
</div>
</div>
<script src="static/js/home.js">

</script>
</body>
</html>
