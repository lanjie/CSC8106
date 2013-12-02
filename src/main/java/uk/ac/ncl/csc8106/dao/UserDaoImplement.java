package uk.ac.ncl.csc8106.dao;

/**   
 *    
 * Project Name：CSC8106   
 * Class Name：UserDaoImplement   
 * Author：Jie Lan  
 * Time：2013年12月2日 上午11:32:05   
 *    
 */
import java.io.File;

import uk.ac.ncl.csc8106.po.User;
import uk.ac.ncl.csc8106.util.FileUtil;
import uk.ac.ncl.csc8106.util.LoadConfig;

public class UserDaoImplement implements UserDao {

	public void addUser(User user) {
		
		String filePath = LoadConfig.getInstance().getFilePath(); //加载配置文件
		
		File file = new File(filePath);
		
		String username = user.getUsername();
		
		String userInfo = null;
		
		if(file.exists()) {
			//验证username的重复性
			userInfo = FileUtil.getInstance().readInfoFromFile(filePath, username);
			
			if(userInfo != null) {
				throw new RuntimeException("用户username不能重复,请重新输入");
			}
		}
		
		//构建持久化到文件中的用户信息格式的字符串
		userInfo = username + "#" + user.getPassword() + "#" + user.getName() + "#" + user.getEmail();
		
		//持久化数据
		FileUtil.getInstance().writeInfoToFile("c:/userinfo.txt", userInfo);
	}

	public User getUser(String username, String password) {
		
		String filePath = LoadConfig.getInstance().getFilePath(); //加载配置文件
		
		User user = null;
		
		File file = new File(filePath);
		if(file.exists()) {
			String userInfo = FileUtil.getInstance().readInfoFromFile(filePath, username, password);
			
			if(userInfo != null) {
				String[] userInfos = userInfo.split("#");
				user = new User();
				user.setUsername(userInfos[0]);
				user.setPassword(userInfos[1]);
				user.setName(userInfos[2]);
				user.setEmail(userInfos[3]);
			}
		}
		return user;
	}
	
}