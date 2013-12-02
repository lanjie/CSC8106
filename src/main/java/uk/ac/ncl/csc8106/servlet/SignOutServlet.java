package uk.ac.ncl.csc8106.servlet;

/**   
 *    
 * Project Name：CSC8106   
 * Class Name：SignOutServlet   
 * Author：Jie Lan  
 * Time：2013年12月2日 上午11:40:26      
 *    
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignOutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		response.sendRedirect("login.jsp");
	}

}
