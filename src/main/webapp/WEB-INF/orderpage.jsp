<%-- 
    Document   : order
    Created on : 12-10-2017, 23:40:44
    Author     : ezl
--%>
<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.StykList"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    User user = (User) session.getAttribute("user");
    List<Order> orders = (List<Order>)session.getAttribute("orders");
    StykList stykList = null;
    for(int i = 0; i < orders.size(); i++)
    {
        if(orders.get(i).getId() == i)
            stykList = orders.get(i).getStykList();
    }
    int[] side1 = stykList.side1();
    int[] side2 = stykList.side2();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Blocks</th>
                    <th>Side 1</th>
                    <th>Side 2</th>
                    <th>Side 3</th>
                    <th>Side 4</th>
                    <th>Total lego blocks</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <td>2x4</td>
                        <td><%=side1[0]/2%></td>
                        <td><%=side2[0]/2%></td>
                        <td><%=side1[0]/2%></td>
                        <td><%=side2[0]/2%></td>
                        <td><%=(side1[0]+side2[0])*stykList.getHigh()%></td>
                    </tr>
                    <tr>
                        <td>2x2</td>
                        <td><%=side1[1]/2%></td>
                        <td><%=side2[1]/2%></td>
                        <td><%=side1[1]/2%></td>
                        <td><%=side2[1]/2%></td>
                        <td><%=(side1[2]+side2[2])*stykList.getHigh()%></td>
                    </tr>
                    <tr>
                        <td>2x1</td>
                        <td><%=side1[2]/2%></td>
                        <td><%=side2[2]/2%></td>
                        <td><%=side1[2]/2%></td>
                        <td><%=side2[2]/2%></td>
                        <td><%=(side1[2]+side2[2])*stykList.getHigh()%></td>
                    </tr>
            </tbody>
        </table>
    </body>
</html>
