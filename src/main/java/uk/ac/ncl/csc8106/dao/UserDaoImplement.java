package uk.ac.ncl.csc8106.dao;

/**   
 *    
 * Project Name��CSC8106   
 * Class Name��UserDaoImplement   
 * Author��Jie Lan  
 * Time��2013��12��2�� ����11:32:05   
 *    
 */
import java.io.File;

import uk.ac.ncl.csc8106.po.User;
import uk.ac.ncl.csc8106.util.FileUtil;
import uk.ac.ncl.csc8106.util.LoadConfig;

public class UserDaoImplement implements UserDao {

	public void addUser(User user) {
		
		String filePath = LoadConfig.getInstance().getFilePath(); //���������ļ�
		
		File file = new File(filePath);
		
		String username = user.getUsername();
		
		String userInfo = null;
		
		if(file.exists()) {
			//��֤username���ظ���
			userInfo = FileUtil.getInstance().readInfoFromFile(filePath, username);
			
			if(userInfo != null) {
				throw new RuntimeException("�û�username�����ظ�,����������");
			}
		}
		
		//�����־û����ļ��е��û���Ϣ��ʽ���ַ���
		userInfo = username + "#" + user.getPassword() + "#" + user.getName() + "#" + user.getEmail();
		
		//�־û�����
		FileUtil.getInstance().writeInfoToFile("c:/userinfo.txt", userInfo);
	}

	public User getUser(String username, String password) {
		
		String filePath = LoadConfig.getInstance().getFilePath(); //���������ļ�
		
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