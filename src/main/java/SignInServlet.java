
/**   
 *    
 * Project Name：CSC8106   
 * Class Name：SignInServlet   
 * Author：Jie Lan  
 * Time：2013年11月28日 下午8:53:12  
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet
{
@WebServlet(
urlPatterns={"/register.do"},
initParams={
@WebInitParam(name = "SUCCESS_VIEW", value = "success.jsp"),
@WebInitParam(name = "ERROR_VIEW", value = "register.jsp")
		    }
		)
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
   {

        req.getRequestDispatcher("WEB-INF/signup.jsp").forward(req, resp);
       
        String username = req.getParameter("username");
        String password = req.getParameter("password");
             
    }
   
    public void doPost(HttpServletRequest req,HttpServletResponse resp)
               throws ServletException,IOException
    {
        doGet(req,resp);
    }
}