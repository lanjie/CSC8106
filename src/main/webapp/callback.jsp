<html>
<head>
<title>Welcome page</title>
</head>
<body>
	<%
		String username = request.getParameter("name");
		String email = request.getParameter("email");
	%>
	<br><br><br><br>
	<table>
		<tr>
			<td><font size="3" ><%= username %></font></td>
		</tr>
		<tr>
			<td><font size="3" ><%= email %></font></td>
		</tr>
	</table>
</body>
</html>