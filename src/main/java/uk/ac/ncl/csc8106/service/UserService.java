package uk.ac.ncl.csc8106.service;

/**   
 *    
 * Project Name：CSC8106   
 * Class Name：UserService   
 * Author：Jie Lan  
 * Time：2013年12月2日 上午11:33:58      
 *    
 */
import uk.ac.ncl.csc8106.po.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User getUser(String username, String password);
}
