package com.xiao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.xiao.pojo.User;
import com.xiao.utils.JDBCUtils_01;
/**
 * @author ЦЦ
 * @Date   2018��3��15������1:15:20
 *	
 */
public class JDBC_02 {
	
	//�ѽ������װ������
	@Test
	public void test() throws Exception{
		//ע�Ტ��ȡ����
		Connection cn = JDBCUtils_01.getConnection();
		//��дSQL���
		String sql = "select * from user_tb";
		//��ȡSQL���Ԥ�������
		PreparedStatement ps = cn.prepareStatement(sql);
		//ִ��SQL���
		ResultSet rs = ps.executeQuery();
		//�������󼯺�
		List<User> list = new ArrayList<>();
		//��������
		while(rs.next()){
			/*��ʽһ:��ȡ����ÿ�����ݣ�ʹ��setXXX()�����ֶ���װ��User������
			User u = new User();
			u.setUid(rs.getInt("uid"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setAge(rs.getInt("age"));
			u.setGender(rs.getString("gender"));
			u.setEmail(rs.getString("email"));*/
			//��ʽ�������вι�������װ
			User u = new User(
							  rs.getInt("uid"),rs.getString("username"),
					          rs.getString("password"),rs.getInt("age"),
					          rs.getString("gender"),rs.getString("email")
							);
			//����װ�Ķ�����뵽������
			list.add(u);
		}
		//��ǿfor�������󼯺�
		for (User user : list) {
			System.out.println(user);
		}
		//�ͷ���Դ
		JDBCUtils_01.relase(cn, ps, rs);
	}
	
}
