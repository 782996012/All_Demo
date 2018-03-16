package com.xiao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;

import com.xiao.utils.JDBCUtils_01;
/**
 * @author ЦЦ
 * @Date   2018��3��15������9:24:53
 *	
 */
public class JDBC_01 {
	/*
	 * JDBC��������:
	 * 	1.ע������
	 * 	2.������ݿ�����
	 *  3.���ִ��SQL���Ķ���
	 *  4.��дSQL���
	 *  5.ִ��SQL���
	 *  6.������
	 *  7.�ͷ���Դ
	 * 
	 */
	//��������
	@Test
	public void insert() throws Exception{
		//1.ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2.�������ݿ�������Ϣ����ȡ���ݿ�����
		String url = "jdbc:mysql://localhost:3306/all_db";
		String username = "root";
		String password = "root";
		Connection cn = DriverManager.getConnection(url, username, password);
		//3.����ִ��SQL���Ķ���
		Statement st = cn.createStatement();
		//4.��дSQL���(������������������������ʱ������д0����)
		String sql = "insert into user_tb values(0,'ЦЦ','123456',23,'��','123@123.com')";
		//5.ִ��sql���
		int row = st.executeUpdate(sql);
		//6.������ ,�������ݲ���,������Ӱ�������
		System.out.println(row);
		//7.�ͷ���Դ(�ȵõ��ĺ��ͷ�)
		if(st!=null){
			st.close();
		}
		if(cn!=null){
			cn.close();
		}			
	}
	
	//��ѯ����
	@Test
	public void select() throws Exception{
		//1.ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2.�������ݿ�������Ϣ����ȡ���ݿ�����
		String url = "jdbc:mysql://localhost:3306/all_db";
		String username = "root";
		String password = "root";
		Connection cn = DriverManager.getConnection(url, username, password);
		//3.����ִ��SQL���Ķ���
		Statement st = cn.createStatement();
		//4.��дSQL���
		String sql = "select * from user_tb";
		//5.ִ��sql���,��ȡ�����
		ResultSet rs = st.executeQuery(sql);
		//6.��������rs,ʹ��next()���������������
		while(rs.next()){
			//��ʽһ:rs.getXXX(index)��ʾ��ȡindex�е�XXX��������,�е�������1��ʼ
			//rs.getInt(1);��ʾ��ȡ��һ�е����ݣ��ټ���ѭ���������Ϳ��Եõ���һ�����е�����
			//��ʽ��:rs.getXXX(����)��ʾͨ��һ���ַ�������������ȡXXX���͵�����
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//7.�ͷ���Դ(�ȵõ��ĺ��ͷ�)
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
	
	//�Զ���JDBC���������
	@Test
	public void testJDBCUtils() throws Exception{
		//1.ʹ�ù�����ע�Ტ��ȡ���ݿ�����
		Connection cn = JDBCUtils_01.getConnection();
		//2.����ִ��SQL������
		Statement st = cn.createStatement();
		//3.��дSQL���
		String sql = "select * from user_tb";
		//4.ִ��SQL���
		ResultSet rs = st.executeQuery(sql);
		//5.��������
		while(rs.next()){
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//6.�ͷ���Դ
		JDBCUtils_01.relase(cn, st, rs);
	}
	
	//ʹ��PrepareStatement�ӿ�Ԥ����SQL��䣬��ֹSQLע�빥��,���ִ�е�Ч��
	@Test
	public void testPrepareStatement() throws Exception{
		//1.ʹ�ù�����ע�Ტ��ȡ���ݿ�����
		Connection cn = JDBCUtils_01.getConnection();
		//2.��дSQL���
		String sql = "select * from user_tb where username = ?";
		//3.��ȡSQL���Ԥ�������PreparedStatement��Statement���ӽӿ�
		PreparedStatement ps = cn.prepareStatement(sql);
		//4.���ã�ռλ����ֵ,��һ������������ǵڼ�������ռλ����������1��ʼ
		ps.setString(1, "ЦЦ");	
		//5.ִ��SQL���
		ResultSet rs = ps.executeQuery();	
		//6.��������
		while(rs.next()){														
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//7.�ͷ���Դ
		JDBCUtils_01.relase(cn, ps, rs);										
	}
}
