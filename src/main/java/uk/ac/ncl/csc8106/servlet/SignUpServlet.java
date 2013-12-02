package uk.ac.ncl.csc8106.servlet;

/**   
 *    
 * Project Name：CSC8106   
 * Class Name：Signup   
 * Author：Jie Lan  
 * Time：2013年11月28日 下午8:56:18     
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.ncl.csc8106.po.User;
import uk.ac.ncl.csc8106.service.UserService;
import uk.ac.ncl.csc8106.service.UserServiceImplement;


public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignUpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		
		UserService userService = new UserServiceImplement();
		userService.addUser(user);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
