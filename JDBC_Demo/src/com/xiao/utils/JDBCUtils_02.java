package com.xiao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
/**
 * @author ЦЦ
 * @Date   2018��3��15������2:38:39
 *	
 */
//ͨ������properties�ļ����������ݿ�ķ�ʽһ
public class JDBCUtils_02 {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/**
	 * ��̬�������������ļ���Ϣ
	 */
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
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
