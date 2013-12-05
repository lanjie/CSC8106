<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sign Up</title>
<style type="text/css">
body,td,th {
	font-size: 12px;
}
</style>
<script src="js/jquery-1.9.1.js" type="text/javascript"></script>
<script type="text/javascript">
	
	function register() {
		
		var username = $("#username").val();
		if(trim(username) == "") {
			alert("Empty Username!");
			$("#username").focus();
			return false;
		}
		
		var password = $("#password").val();
		if(trim(password) == "") {
			alert("Empty Password!");
			$("#password").focus();
			return false;
		}
		
		var confirmpassword = $("#confirmpassword").val();
		
		if(trim(confirmpassword) != trim(password)) {
			$("#confirmpassword").focus();
			alert("Different Password!");
			return false;
		}
		
		var name = $("#name").val();
		if(trim(name) == "") {
			$("#name").focus();
			alert("Empty Name!");
			return false;
		}
		
		var email = $("#email").val();
		if(trim(email) == "") {
			$("#email").focus();
			alert("Empty Email!");
			return false;
		}
		
		if(!isEmail(email)) {
			$("#email").focus();
			alert("Icorrect Email Format!");
			return false;
		}
		return true;
	}
	
	//Check email format
	function isEmail(eml) {
		if(trim(eml)!='') {
		  var re=new RegExp("@[\\w]+(\\.[\\w]+)+$");
		  return(re.test(eml));
		}
		else
		  return(true);
	}
	
	//del space from left
	function ltrim(str) { 
		if(str.length==0)
			return(str);
		else {
			var idx=0;
			while(str.charAt(idx).search(/\s/)==0)
				idx++;
			return(str.substr(idx));
		}
	}

	//del space from right
	function rtrim(str) { 
		if(str.length==0)
			return(str);
		else {
			var idx=str.length-1;
			while(str.charAt(idx).search(/\s/)==0)
				idx--;
			return(str.substring(0,idx+1));
		}
	}

	//del space from middle
	function trim(str) { 
		return(rtrim(ltrim(str)));
	}
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="SignUpServlet" onsubmit="return register()" >
  <table width="400" border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="30" colspan="2" align="center">Sign Up Your information</td>
    </tr>
    <tr>
      <td width="113" height="25" align="center">Username:</td>
      <td width="281" height="25" align="left"><label for="username"></label>
      <input type="text" name="username" id="username"></td>
    </tr>
    <tr>
      <td height="25" align="center">Password:</td>
      <td height="25" align="left"><label for="password"></label>
      <input type="password" name="password" id="password"></td>
    </tr>
    <tr>
      <td height="25" align="center">Confirm Password:</td>
      <td height="25" align="left"><label for="confirmpassword"></label>
      <input type="password" name="confirmpassword" id="confirmpassword"></td>
    </tr>
    <tr>
      <td height="25" align="center">Name:</td>
      <td height="25" align="left"><label for="name"></label>
      <input type="text" name="name" id="name"></td>
    </tr>
    <tr>
      <td height="25" align="center">Email Address:</td>
      <td height="25" align="left"><label for="email"></label>
      <input type="text" name="email" id="email"></td>
    </tr>
    <tr>
      <td height="25" colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Submit">&nbsp;&nbsp;
      <input type="reset" name="reset" id="reset" value="Reset"></td>
    </tr>
  </table>
</form>
</body>
</html>