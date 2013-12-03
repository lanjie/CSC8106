package uk.ac.ncl.csc8106.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	
	private static FileUtil instance;
	
	private FileUtil() {}
	
	public static FileUtil getInstance() {
		if(instance == null) {
			instance = new FileUtil();
		}
		return instance;
	}
	
	/**
	 * 将用户信息持久化到文件中
	 * @param filePath 文件路径
	 * @param info 要写入文件的内如
	 */
	public void writeInfoToFile(String filePath,String info) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(new File(filePath),true);
			bw = new BufferedWriter(fw);
			bw.write(info);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 根据username和password获得文件中的用户信息 用户信息格式 username#password#name#email
	 * @param filePath 文件路径
	 * @param username
	 * @param password
	 * @return 用户信息的字符串
	 */
	public String readInfoFromFile(String filePath, String username, String password) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		String userInfo = null;
		
		try {
			fr = new FileReader(new File(filePath));
			br = new BufferedReader(fr);
			
			while((userInfo = br.readLine()) != null) {
				if(userInfo.contains("#")) {
					String[] userInfos = userInfo.split("#");
					String fileUserName = userInfos[0];
					String filePassWord = userInfos[1];
					
					if(username.equals(fileUserName) && password.equals(filePassWord)) {
						break;
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return userInfo;
	}
	
	/**
	 * 根据username获得文件中的用户信息 用户信息格式 username#password#name#email
	 * @param filePath 文件路径
	 * @param username
	 * @return 用户信息的字符串
	 */
	public String readInfoFromFile(String filePath, String username) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		String userInfo = null;
		
		try {
			fr = new FileReader(new File(filePath));
			br = new BufferedReader(fr);
			
			while((userInfo = br.readLine()) != null) {
				String[] userInfos = userInfo.split("#");
				String fileUserName = userInfos[0];
				
				if(username.equals(fileUserName)) {
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return userInfo;
	}
	
	
	
	public static void main(String[] args) {
//FileUtil.getInstance().writeInfoToFile("c:/userinfo.txt", "zhangsan#123456#张三#464526972@qq.com");
	//	FileUtil.getInstance().writeInfoToFile("c:/userinfo.txt", "lisi#123456#张三#464526972@qq.com");
		FileUtil.getInstance().writeInfoToFile("c:/userinfo.txt", "wangwu#123456#张三#464526972@qq.com");
		
		String userinfo = FileUtil.getInstance().readInfoFromFile("c:/userinfo.txt","wangwu", "123456");
		System.out.println(userinfo);
	}
}
