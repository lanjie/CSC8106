/*package uk.ac.ncl.csc8106.servlet;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FederatedLoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	
	private final String clientId = "387344679095-a0duvi52qsqr4oro061st3gtaf45k685.apps.googleusercontent.com";
	private final String scope = "https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email";
	private final String redirectUrl = "http://localhost:8080/federatedLogin";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        OAuthClientRequest request = null;
        try {
            request = OAuthClientRequest
                    .authorizationProvider(OAuthProviderType.GOOGLE)
                    .setClientId(clientId)
                    .setRedirectURI(redirectUrl)
                    .setResponseType("code")
                    .setScope(scope)
                    .buildQueryMessage();
            resp.sendRedirect(request.getLocationUri());
        } catch (OAuthSystemException e) {
            throw new ServletException(e);
        }
    }
}*/