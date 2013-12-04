<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
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
			alert("用户账号不能为空!");
			$("#username").focus();
			return false;
		}
		
		var password = $("#password").val();
		if(trim(password) == "") {
			alert("密码不能为空!");
			$("#password").focus();
			return false;
		}
		
		var confirmpassword = $("#confirmpassword").val();
		
		if(trim(confirmpassword) != trim(password)) {
			$("#confirmpassword").focus();
			alert("两次密码不相同!");
			return false;
		}
		
		var name = $("#name").val();
		if(trim(name) == "") {
			$("#name").focus();
			alert("用户名称不能为空!");
			return false;
		}
		
		var email = $("#email").val();
		if(trim(email) == "") {
			$("#email").focus();
			alert("输入email不能为空!");
			return false;
		}
		
		if(!isEmail(email)) {
			$("#email").focus();
			alert("email格式不正确!");
			return false;
		}
		return true;
	}
	
	//校验是否是Email
	function isEmail(eml) {
		if(trim(eml)!='') {
		  var re=new RegExp("@[\\w]+(\\.[\\w]+)+$");
		  return(re.test(eml));
		}
		else
		  return(true);
	}
	
	//删除字符串左边的空格
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

	//删除字符串右边的空格
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

	//删除字符串左右两边的空格
	function trim(str) { 
		return(rtrim(ltrim(str)));
	}
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="SignUpServlet" onsubmit="return register()" >
  <table width="400" border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="30" colspan="2" align="center">用户信息注册</td>
    </tr>
    <tr>
      <td width="113" height="25" align="center">用户账号:</td>
      <td width="281" height="25" align="left"><label for="username"></label>
      <input type="text" name="username" id="username"></td>
    </tr>
    <tr>
      <td height="25" align="center">用户密码:</td>
      <td height="25" align="left"><label for="password"></label>
      <input type="password" name="password" id="password"></td>
    </tr>
    <tr>
      <td height="25" align="center">密码确定:</td>
      <td height="25" align="left"><label for="confirmpassword"></label>
      <input type="password" name="confirmpassword" id="confirmpassword"></td>
    </tr>
    <tr>
      <td height="25" align="center">用户名称:</td>
      <td height="25" align="left"><label for="name"></label>
      <input type="text" name="name" id="name"></td>
    </tr>
    <tr>
      <td height="25" align="center">用户email:</td>
      <td height="25" align="left"><label for="email"></label>
      <input type="text" name="email" id="email"></td>
    </tr>
    <tr>
      <td height="25" colspan="2" align="center"><input type="submit" name="submit" id="submit" value="提交">&nbsp;&nbsp;
      <input type="reset" name="reset" id="reset" value="重置"></td>
    </tr>
  </table>
</form>
</body>
</html>