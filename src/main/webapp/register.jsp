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
			alert("鐢ㄦ埛璐﹀彿涓嶈兘涓虹┖!");
			$("#username").focus();
			return;
		}
		
		var password = $("#password").val();
		if(trim(password) == "") {
			alert("瀵嗙爜涓嶈兘涓虹┖!");
			$("#password").focus();
			return;
		}
		
		var confirmpassword = $("#confirmpassword").val();
		
		if(trim(confirmpassword) != trim(password)) {
			$("#confirmpassword").focus();
			alert("涓ゆ瀵嗙爜涓嶇浉鍚�");
			return;
		}
		
		var name = $("#name").val();
		if(trim(name) == "") {
			$("#name").focus();
			alert("鐢ㄦ埛鍚嶇О涓嶈兘涓虹┖!");
			return;
		}
		
		var email = $("#email").val();
		if(trim(email) == "") {
			$("#email").focus();
			alert("杈撳叆email涓嶈兘涓虹┖!");
			return;
		}
		
		if(!isEmail(email)) {
			$("#email").focus();
			alert("email鏍煎紡涓嶆纭�");
			return;
		}
		
		$("#submitForm").submit();
		
	}
	
	//鏍￠獙鏄惁鏄疎mail
	function isEmail(eml) {
		if(trim(eml)!='') {
		  var re=new RegExp("@[\\w]+(\\.[\\w]+)+$");
		  return(re.test(eml));
		}
		else
		  return(true);
	}
	
	//鍒犻櫎瀛楃涓插乏杈圭殑绌烘牸
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

	//鍒犻櫎瀛楃涓插彸杈圭殑绌烘牸
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

	//鍒犻櫎瀛楃涓插乏鍙充袱杈圭殑绌烘牸
	function trim(str) { 
		return(rtrim(ltrim(str)));
	}
</script>
</head>
<body>
<form name="submitForm" id="submitForm" method="post" action="/SignUpServlet">
  <table width="400" border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="30" colspan="2" align="center">Sign Up</td>
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
      <td height="25" colspan="2" align="center"><input type="submit" onclick="register()" name="submit" id="submit" value="Submit">&nbsp;&nbsp;
      <input type="reset" name="reset" id="reset" value="Reset"></td>
    </tr>
  </table>
</form>
</body>
</html>