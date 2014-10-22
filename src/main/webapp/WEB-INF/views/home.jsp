<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
         <link rel="icon" href="<c:url value="/resources/favicon_ico.jpg" />" type="image/x-icon">
    </head>
    <style>
body  {
    background-image: url('http://jessicawoodslee.com/wp-content/uploads/2011/09/cool-library.jpg');
    background-size: 1480px 800px;
    background-repeat: no-repeat;
}
a:link {
    color: #FF0000;
}
a:visited {
    color: #00FF00;
}
a:hover {
    color: #FF00FF;
}
a:active {
    color: #0000FF;
}
</style>
    <body>
         <div style="background-color:#778899; color:black; margin:20px; opacity:0.8; padding:20px;">
 
        <h1 style="color: white; font-weight: bold;">
            Welcome in LIBRARY!  
        </h1>

        <P>  The time on the server is ${serverTime}. </P>

        <ul>
            <li>
                <a href="<c:url value="/library"/>" >Library</a>
            </li>
             <li>
                <a href="<c:url value="/kontakt"/>" >Dane kontaktowe</a>
            </li>
        </ul>
         </div>
    </body>
</html>
