<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <div id="wrapper">

            <jsp:include page="../Includes/menu.jsp" />

            <h1>Hello <%=request.getParameter("email")%> </h1>
            You are now logged in as a customer of our wonderful site.
            <form action="FrontController" method="POST">
                <input type="hidden" name="command" value="createOrder">
                <label for="wide">Blocks wide</label>
                <input type="text" placeholder="Wide" name="wide">
                <label for="length">Blocks Long</label>
                <input type="text" placeholder="Long" name="long">
                <label for="high">Blocks high</label>
                <input type="text" placeholder="High" name="high">
                <button type="submit" value="Submit">Place order</button>
            </form>
        </div>
    </body>
</html>
