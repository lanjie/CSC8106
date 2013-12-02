package uk.ac.ncl.csc8106.service;

/**   
 *    
 * Project Name：CSC8106   
 * Class Name：UserServiceImplement   
 * Author：Jie Lan  
 * Time：2013年12月2日 上午11:34:42    
 *    
 */
import uk.ac.ncl.csc8106.dao.UserDao;
import uk.ac.ncl.csc8106.dao.UserDaoImplement;
import uk.ac.ncl.csc8106.po.User;

public class UserServiceImplement implements UserService {

	public void addUser(User user) {
		
		UserDao userDao = new UserDaoImplement();
		userDao.addUser(user);
	}

	public User getUser(String username, String password) {
		
		UserDao userDao = new UserDaoImplement();
		
		return userDao.getUser(username, password);
	}

}

