<%-- 
    Document   : orderspage
    Created on : 12-10-2017, 19:43:21
    Author     : ezl
--%>
<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%
    User user = (User) session.getAttribute("user");
    List<Order> orders = (List<Order>)session.getAttribute("orders");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Orders</h1>
        <table>
            <thead>
                <tr>
                    <th>Order date</th>
                    <th>Blocks wide</th>
                    <th>Blocks long</th>
                    <th>Blocks high</th>
                    <th>Total block</th>
                    <th>Sendt</th>
                    <th>Info</th>
                    <%if(user.getRole().equals("employee")){%>
                    <th>Mark to send</th>
                    <%}%>
                </tr>
            </thead>
            <tbody>
                <form action="">
                <%for(int i = 0; i < orders.size(); i++){%>
                    <tr>
                        <td><%=orders.get(i).getDate()%></td>
                        <td><%=orders.get(i).getStykList().getWidth()%></td>
                        <td><%=orders.get(i).getStykList().getLength()%></td>
                        <td><%=orders.get(i).getStykList().getHigh()%></td>
                        <td><%=orders.get(i).getStykList().getTotal()%></td>
                        <td><%=orders.get(i).isSendt()%></td>
                        <td><a href="FrontController?command=getOrder&id=<%=orders.get(i).getId()%>">Styklist</a></td>
                        <%if(user.getRole().equals("employee")){%>
                        <th><input type="checkbox"></th>
                        <%}%>
                    </tr>
                <%}%>
                </form>
            </tbody>
        </table>
    </body>
</html>
