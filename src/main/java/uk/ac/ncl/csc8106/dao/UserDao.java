package uk.ac.ncl.csc8106.dao;

/**   
 *    
 * Project Name：CSC8106   
 * Class Name：UserDao   
 * Author：Jie Lan  
 * Time：2013年12月2日 上午8:15:15   
 *    
 */
import uk.ac.ncl.csc8106.po.User;

public interface UserDao {
	
	public void addUser(User user);
	
	public User getUser(String username, String password);
}
