/*package uk.ac.ncl.csc8106.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.parser.JSONParser;

import uk.ac.ncl.csc8106.po.User;

public class CallbackServlet extends HttpServlet {


	private final String clientId = "387344679095-a0duvi52qsqr4oro061st3gtaf45k685.apps.googleusercontent.com";
	private final String redirectUrl = "http://localhost:8080/federatedLogin";
	private final String clientSecret = "hkBewmSbKqUC93YkJBgEdfQm"; 
	
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		    
		   if (req.getParameter("error") != null) {
		    resp.getWriter().println(req.getParameter("error"));
		    return;
		   }
		    
		   // google returns a code that can be exchanged for a access token
		   String code = req.getParameter("code");
		    
		   // get the access token by post to Google
		   String body = post("https://accounts.google.com/o/oauth2/token", ImmutableMap.<String,String>builder()
		     .put("code", code)
		     .put("client_id", clientId)
		     .put("client_secret", clientSecret)
		     .put("redirect_uri", "http://localhost:8089/callback")
		     .put("grant_type", "authorization_code").build());
		 

		    
		   JSONObject jsonObject = null;
		    
		   // get the access token from json and request info from Google
		   try {
		    jsonObject = (JSONObject) new JSONParser().parse(body);
		   } catch (ParseException e) {
		    throw new RuntimeException("Unable to parse json " + body);
		   }
		    
		   // google tokens expire after an hour, but since we requested offline access we can get a new token without user involvement via the refresh token
		   String accessToken = getAccessToken(code);
		      
		   // you may want to store the access token in session
		   req.getSession().setAttribute("access_token", accessToken);
		    
		   // get some info about the user with the access token
		   String json = get(new StringBuilder("https://www.googleapis.com/oauth2/v1/userinfo?access_token=").append(accessToken).toString());
		    
		   // now we could store the email address in session
		    
		   // return the json of the user's basic info
		   resp.getWriter().println(json);
		  } 
		 		  
		 // makes a GET request to url and returns body as a string
		 public String get(String url) throws ClientProtocolException, IOException {
		  return execute(new HttpGet(url));
		 }
		  
		 // makes a POST request to url with form parameters and returns body as a string
		 public String post(String url, Map<String,String> formParameters) throws ClientProtocolException, IOException { 
		  HttpPost request = new HttpPost(url);
		    
		  List <User> nvps = new ArrayList <User>();
		   
		  for (String key : formParameters.keySet()) {
		   nvps.add(new BasicNameValuePair(key, formParameters.get(key))); 
		  }
		 
		  request.setEntity(new UrlEncodedFormEntity(nvps));
		   
		  return execute(request);
		 }
		 
		 private String getAccessToken(String code) {
			 OAuthClientRequest request = null;
			 OAuthJSONAccessTokenResponse oAuthResponse = null;
			  
			 try {
			 request = OAuthClientRequest.tokenProvider(OAuthProviderType.GOOGLE)
			 .setGrantType(GrantType.AUTHORIZATION_CODE)
			 .setClientId(clientId).setClientSecret(clientSecret)
			 .setRedirectURI(redirectUrl).setCode(code).buildBodyMessage();
			  
			 OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
			 oAuthResponse = oAuthClient.accessToken(request, OAuthJSONAccessTokenResponse.class);
			 } catch (OAuthSystemException e) {
			 e.printStackTrace();
			 } catch (OAuthProblemException e) {
			 e.printStackTrace();
			 }
			  
			 String accessToken = oAuthResponse.getAccessToken();
			 return accessToken;
			}
		  
		 // makes request and checks response code for 200
		 private String execute(HttpRequestBase request) throws ClientProtocolException, IOException {
		  HttpClient httpClient = new DefaultHttpClient();
		  HttpResponse response = httpClient.execute(request);
		      
		  HttpEntity entity = response.getEntity();
		     String body = EntityUtils.toString(entity);
		 
		  if (response.getStatusLine().getStatusCode() != 200) {
		   throw new RuntimeException("Expected 200 but got " + response.getStatusLine().getStatusCode() + ", with body " + body);
		  }
		 
		     return body;
		 }

}
*/