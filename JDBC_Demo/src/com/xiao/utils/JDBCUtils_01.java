package com.xiao.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * @author ЦЦ
 * @Date   2018��3��15������10:55:16
 *	
 */
public class JDBCUtils_01 {
	//ע�Ტ��ȡ���ݿ�����
	public static Connection getConnection() throws Exception{
		//1.ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2.�������ݿ�������Ϣ����ȡ���ݿ�����
		String url = "jdbc:mysql://localhost:3306/all_db";
		String username = "root";
		String password = "root";
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
