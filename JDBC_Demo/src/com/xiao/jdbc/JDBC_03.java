package com.xiao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;
import com.xiao.utils.JDBCUtils_02;
import com.xiao.utils.JDBCUtils_03;
/**
 * @author ЦЦ
 * @Date   2018��3��15������2:42:15
 *	
 */
//ͨ������properties�ļ����������ݿ�����ַ�ʽ����
public class JDBC_03 {
	//ͨ������properties�ļ����������ݿ�ķ�ʽһ  ����
	@Test
	public void test_01() throws Exception{
		//1.ʹ�ù�����JDBCUtils_02ע�Ტ��ȡ����
		Connection cn = JDBCUtils_02.getConnection();
		//2.��дSQL���
		String sql = "select * from user_tb";
		//3.��ȡSQL���Ԥ�������
		PreparedStatement ps = cn.prepareStatement(sql);
		//4.ִ��SQL���
		ResultSet rs = ps.executeQuery();
		//5.��������
		while(rs.next()){
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//6.�ͷ���Դ
		JDBCUtils_02.relase(cn, ps, rs);
	}
	//ͨ������properties�ļ����������ݿ�ķ�ʽ��  ����
	@Test
	public void test_02() throws Exception{
		//1.ʹ�ù�����JDBCUtils_03ע�Ტ��ȡ����
		Connection cn = JDBCUtils_03.getConnection();
		//2.��дSQL���
		String sql = "select * from user_tb";
		//3.��ȡSQL���Ԥ�������
		PreparedStatement ps = cn.prepareStatement(sql);
		//4.ִ��SQL���
		ResultSet rs = ps.executeQuery();
		//5.��������
		while(rs.next()){
			System.out.println(rs.getInt("uid")+"  "+rs.getString("username"));
		}
		//6.�ͷ���Դ
		JDBCUtils_02.relase(cn, ps, rs);
	}
}
