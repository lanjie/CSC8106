<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	if(request.getAttribute("errMsg") != null) {
		String errMsg = String.valueOf(request.getAttribute("errMsg"));
		out.print(errMsg);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Main Page</title>
<style type="text/css">
body,td,th {
	font-size: 12px;
}
</style>
</head>
<body>
<form name="form1" method="post" action="SignInServlet">
  <table width="400" border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="30" colspan="2" align="center">Sign In</td>
    </tr>
    <tr>
      <td width="107" height="25" align="center">Username:</td>
      <td width="287" height="25"><label for="username"></label>
      <input type="text" name="username" id="username"></td>
    </tr>
    <tr>
      <td height="25" align="center">Password:</td>
      <td height="25"><label for="password"></label>
      <input type="password" name="password" id="password"></td>
    </tr>
    <tr>
      <td height="25" colspan="2" align="center"><input type="submit" name="login" id="login" value="Sign In">&nbsp;&nbsp;
      <input type="reset" name="reset" id="reset" value="Reset"></td>
    </tr>
  </table>
</form>
</body>
</html>