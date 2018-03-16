package com.xiao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
/**
 * @author ЦЦ
 * @Date   2018��3��15������2:38:39
 *	
 */
//ͨ������properties�ļ����������ݿ�ķ�ʽ��
public class JDBCUtils_03 {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/**
	 * ��̬�������������ļ���Ϣ
	 */
	static {
		try {
			// 1.ͨ����ǰ���ȡ�������
			ClassLoader classLoader = JDBCUtils_03.class.getClassLoader();
			// 2.ͨ����������ķ������һ��������
			InputStream in = classLoader.getResourceAsStream("jdbc.properties");
			// 3.����һ��properties����(����)
			Properties props = new Properties();
			// 4.����������
			props.load(in);
			// 5.��ȡ��ز�����ֵ
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//ע�Ტ��ȡ���ݿ�����
	public static Connection getConnection() throws Exception{
		//1.ע������
		Class.forName(driver);
		//2.��ȡ���ݿ�����
		Connection cn =  DriverManager.getConnection(url, username, password);
		return cn;
	}
	//�ͷ���Դ
	public static void relase(Connection cn,Statement st,ResultSet rs) throws Exception{
		if(rs!=null){									    
			rs.close();
		}
		if(st!=null){
			st.close();
		}
		if(cn!=null){
			cn.close();
		}			
	}

}
