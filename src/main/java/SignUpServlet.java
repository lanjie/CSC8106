
/**   
 *    
 * Project Name：CSC8106   
 * Class Name：Signup   
 * Author：Jie Lan  
 * Time：2013年11月28日 下午8:56:18     
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SignUpServlet extends HttpServlet {

	private final String USERS = "C:/users";
	private final String SUCCESS_VIEW = "success.view";
	private final String ERROR_VIEW = "error.view";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/signup.jsp").forward(req, resp);
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * To get parameter of email, username, password
		 */
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword =req.getParameter("confirmPassword");
		
		
		ArrayList<String> errors = new ArrayList<String>();
			
			if (isInvalidEmail(email)) {
				errors.add("Input a valid email address");
			}
			
			if (isInvalidUsername(username)) {
				errors.add("Input a valid username or this username has been token");
			}
			
			if(isInvalidPassword(password, confirmPassword)) {
				errors.add("Input the same password");
			}
			
		String resultPage = ERROR_VIEW;
		if (!errors.isEmpty()) {
			req.setAttribute("errors", errors);
		}
		else {
			resultPage = SUCCESS_VIEW;
			createUserData(email, username, password);
		}
		
		req.getRequestDispatcher(resultPage).forward(req, resp);
	}		
		/**
		 * to check valid email address format
		 */
	private boolean isInvalidEmail(String email) {
			
		return email == null || !email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
	}
		
		/**
		 * to check valid username has already exist
		 */
	private boolean isInvalidUsername(String username) {
			
		for (String file : new File(USERS).list()) {
				
			if (file.equals(username)) {
					
				return true;
			}
		}
		return false;
		
	}
		
		/**
		 * to check valid password length and coincident with confirmpassword
		 */
	private boolean isInvalidPassword(String password, String confirmPassword) {
		
		return password == null || password.length() < 6 || password.length() > 16 || !password.equals(confirmPassword);
	}
	
	private void createUserData(String email, String username, String password)
			throws IOException {
		File userhome = new File(USERS + "/" + username);
		userhome.mkdir();
		BufferedWriter writer = new BufferedWriter(new FileWriter(userhome + "/profile"));
		writer.write(email + "\t" + password);
		writer.close();
	}

       
}