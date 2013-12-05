<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="uk.ac.ncl.csc8106.po.User" %>
<%
	User user = null;
	if(session.getAttribute("user") != null) {
		user = (User)session.getAttribute("user");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sign In</title>
<style type="text/css">
body,td,th {
	font-size: 12px;
}
</style>
</head>
<body>
<h1 align="center">Main Page</h1>
<div style="margin-left:80%;">
<a href="signinwithgoogle.jsp">Sign In with Google</a>&nbsp;
<a href="login.jsp">Sign In</a>&nbsp;
<a href="register.jsp">Sign Up</a>&nbsp;
<a href="SignOutServlet">Sign Out</a>
</div>
<%
	if(user != null) {
%>
<table width="400" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30" colspan="2" align="center">User Information</td>
  </tr>
  <tr>
    <td width="89" height="25" align="center">Username:</td>
    <td width="305" height="25"><%= user.getUsername() %></td>
  </tr>
  <tr>
    <td height="25" align="center">Name:</td>
    <td height="25"><%=user.getName() %></td>
  </tr>
  <tr>
    <td height="25" align="center">Email：</td>
    <td height="25"><%=user.getEmail() %></td>
  </tr>
</table>
<%
	}
%>
</body>
</html>


