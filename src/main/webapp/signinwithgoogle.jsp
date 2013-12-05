<html>
<head>
<title>Demo: Getting an email address using the Google+ Sign-in
button</title>
<style type="text/css">
.hide {
	display: none;
}

.show {
	display: block;
}
</style>

<script src="https://apis.google.com/js/plusone.js"></script>
<script src="https://apis.google.com/js/client:plus.js"></script>
<script type="text/javascript">
		//name = 'me';
  		function toggleElement(id) {
	    	var element = document.getElementById(id);
	   	 	if (element.getAttribute('class') == 'hide') {
	     		element.setAttribute('class', 'show');
	     	} else {
	     		element.setAttribute('class', 'hide');
	     	}
	    }
  
  	    function loginFinishedCallback(authResult) {
  	  	    var email = '';
  	  	    var name = '';
    		if (authResult) {
      			if (authResult['error'] == undefined){
        			gapi.auth.setToken(authResult); 
        			toggleElement('signin-button'); //hide or show this button element,hide this button element
        			getUser();
        			getEmail();//self-defined function below  
        			//window.location.href='/googleDynamicAccount.jsp?email='+email+'&'+'name='+name;              
      			} else {
          			//console.log('An error occurred');
    	  		  	var el = document.getElementById('error');
  		  			var info = authResult['error']; 
  	      			el.innerText = info;
  		  			toggleElement('error');
      	        }
    		} else {
      			//console.log('Empty authResult');  
    			var el = document.getElementById('emptyAuth');
				var info = 'You have not sign in any Google account!'; 
	    		el.innerText = info;
				toggleElement('emptyAuth');
    		}
  		}

  function getUser(){
	    gapi.client.load('plus', 'v1', function() {
	    	var request = gapi.client.plus.people.get({'userId' : 'me'});
			request.execute(function(resp) {
				//var el = document.getElementById('name');
				name = '';
			    if (resp.displayName) {
					name = resp.displayName;
				}
			    //window.location.href='/googleDynamicAccount.jsp?id='+name;
			    //console.log(obj);   
			    //el.innerText = name;
				//toggleElement('name');
	    		//console.log('ID: ' + resp.id);
	    		//console.log('Display Name: ' + resp.displayName);
	  			//console.log('Image URL: ' + resp.image.url);
	  		    //console.log('Profile URL: ' + resp.url);
			});	
	    });		 
  }
  
 function getEmail(){
    gapi.client.load('oauth2', 'v2', function() {
          var request = gapi.client.oauth2.userinfo.get();
          request.execute(getEmailCallback);
        });
 }
 function getEmailCallback(obj){
    //var el = document.getElementById('email');
    var email = '';
	if (obj['email']) {
      email = 'Email: ' + obj['email'];
    }
	window.location.href='/callback.jsp?name='+name+'&email='+email;
	//console.log(obj);   
	//el.innerHTML = email;
    //toggleElement('email');
 }
  </script>
</head>

<body>
<div id="signin-button" class="show">
<div class="g-signin" data-callback="loginFinishedCallback"
	data-approvalprompt="force"
	data-clientid="127172546324-6ras7mjeh5bgoctdh2k57g75g8j95jcj.apps.googleusercontent.com"
	data-requestvisibleactions="http://schemas.google.com/AddActivity"
	data-scope="https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email"
	data-height="short" data-cookiepolicy="single_host_origin"></div>
</div>

<font color="red">
<div id="email" class="hide"></div>
</font>
<div id="name" class="hide"></div>
<font color="red" size="5">
<div id="emptyAuth" class="hide"></div>
</font>
<font color="red" size="5">
<div id="error" class="hide"></div>
</font>