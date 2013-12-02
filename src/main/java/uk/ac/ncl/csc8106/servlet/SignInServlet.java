package uk.ac.ncl.csc8106.servlet;

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
import javax.servlet.http.HttpSession;

import uk.ac.ncl.csc8106.po.User;
import uk.ac.ncl.csc8106.service.UserService;
import uk.ac.ncl.csc8106.service.UserServiceImplement;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignInServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userService = new UserServiceImplement();
		
		User user = userService.getUser(username, password);
		
		if(user == null) {
			request.setAttribute("errMsg", "<script>alert('账号或密码错误，请重新输入!')</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}
	}

}
