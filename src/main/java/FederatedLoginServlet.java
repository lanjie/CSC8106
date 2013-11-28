import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FederatedLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        OAuthClientRequest request = null;
        try {
            request = OAuthClientRequest
                    .authorizationProvider(OAuthProviderType.GOOGLE)
                    .setClientId("APPLICATION_ID")
                    .setRedirectURI("REDIRECT_URI")
                    .buildQueryMessage();
            resp.sendRedirect(request.getLocationUri());
        } catch (OAuthSystemException e) {
            throw new ServletException(e);
        }

    }
}
