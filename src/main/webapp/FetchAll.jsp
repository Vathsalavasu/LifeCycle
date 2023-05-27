<%@page import="Dto.Empdetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>
<% List<Empdetails> list=(List<Empdetails>)request.getAttribute("list");%>
<div>
<table border='1' >
<tr>
<th>ID</th><th>Name</th><th>Mobile</th><th>edit</th><th>delete</th>
</tr>
<%for(Empdetails emp:list)
{%>
<tr>
<td><%=emp.getEmpid() %></td>
<td><%=emp.getName() %></td>
<td><%=emp.getMobile() %></td>
<td><a href="Edit.jsp?id=<%=emp.getEmpid() %>"><button> Edit</button></a></td>
<td><a href="delete?id=<%=emp.getEmpid()%>"><button> Delete</button></a></td>
</tr>
<%} %>
</table>
</div> 
</body>
</html>