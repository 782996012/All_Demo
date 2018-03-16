package com.xiao.DButilsTest;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import com.xiao.pojo.User;
import com.xiao.utils.JDBCUtils_03;
/**
 * @author ЦЦ
 * @Date   2018��3��16������11:54:46
 *	
 */
public class QueryRunnerDemo {
	
	//�������,ʹ��QueryRunner���update����
	@Test
	public void addUser() throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "insert into user_tb values(?,?,?,?,?,?)";
		//����ռλ����ʵ�ʲ���д��������
		Object[] params = {0,"ЦЦ","123456",23,"��","123@123.com"};
		//����updateִ��SQL���
		int row = qr.update(cn, sql, params);
		if(row > 0){
			System.out.println("����û��ɹ���");
		}else{
			System.out.println("����û�ʧ�ܣ�");
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//�޸�����
	@Test
	public void updateUser() throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "update user_tb set username = ? where uid = ?";
		//�����������
		Object[] params = {"�Ұ�ЦЦ",1};
		//ִ��SQL���
		int row = qr.update(cn, sql, params);
		if(row > 0){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸�ʧ�ܣ�");
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//ɾ������
	@Test
	public void removeUser() throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "delete from user_tb where uid = ?";
		//ֻ��һ������������ֱ�ӵ���update����ִ��
		int row = qr.update(cn, sql, 1);
		if(row > 0){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//��ѯ���ݣ�ʹ��QueryRunner���query����
	//ArrayHandler,��������ĵ�һ�����ݴ洢��һ������������,�����е�ÿ��ֵ��Ӧ�������ݵ�ÿ���ֶ�ֵ
	@Test
	public void arrayHandler() throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "select * from user_tb";
		//����query����ִ�в�ѯ
		Object[] result = qr.query(cn, sql, new ArrayHandler());
		//��ǿfor��������
		for (Object object : result) {
			System.out.print(object+"\t");
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//ArrayListHandler,���������ÿһ�����ݴ洢�����������У�����������洢��List������
	@Test
	public void arrayListHandler() throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "select * from user_tb";
		//����query����ִ�в�ѯ
		List<Object[]> result = qr.query(cn, sql, new ArrayListHandler());
		//��ǿfor��������,���ѭ���������ϣ��ڲ�ѭ����������
		for (Object[] objects : result) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//BeanHandler,��������ĵ�һ�����ݷ�װ��JavaBean���󣬱���װ�Ķ������Ҫ�пղι���
	@Test
	public void beanHandler()throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "select * from user_tb where uid = ?";
		//ִ��SQL���,������ĵ�һ�����ݷ�װ��User����
		User user = qr.query(cn, sql, new BeanHandler<>(User.class),12);
		System.out.println(user);
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//BeanListHandler,���������ÿһ�����ݷ�װ��JavaBean���� ����JavaBean�������List������
	@Test
	public void beanListHandler()throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "select * from user_tb";
		//ִ��SQL���,�������ÿһ�����ݷ�װ��User����
		List<User> list = qr.query(cn, sql, new BeanListHandler<>(User.class));
		//��ǿfor��������
		for (User user : list) {
			System.out.println(user);
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//ColumnListHandler,���������ָ�����е��ֶ�ֵ����װ��List������
	@Test
	public void columnListHandler() throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "select * from user_tb";
		//ִ��SQL���,������������
		List<Object> list = qr.query(cn, sql, new ColumnListHandler<>("username"));
		//��������
		for (Object object : list) {
			System.out.println(object);
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//ScalarHandler,����ֻ��һ�����ݽ���ģ���ۺϺ�����count
	@Test
	public void scalarHandler()throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "select count(*) from user_tb";
		//ִ��SQL���
		long count = qr.query(cn, sql, new ScalarHandler<Long>());
		System.out.println(count);
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//MapHandler,��������ĵ�һ�����ݷ�װ��Map����
	@Test
	public void mapHandler()throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "select * from user_tb";
		//ִ��SQL���
		Map<String, Object> map = qr.query(cn, sql, new MapHandler());
		//����Map����
		for(String key:map.keySet()){
			System.out.println(key+"  "+map.get(key));
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
	
	//MapListHandler,���������ÿһ�����ݷ�װ��Map�����У��ٽ�Map���Ϸ���List������
	@Test
	public void mapListHandler()throws Exception{
		//JDBCUtils_03�������ȡ���ݿ�����
		Connection cn = JDBCUtils_03.getConnection();
		//����QueryRunner��Ķ���
		QueryRunner qr = new QueryRunner();
		//��дSQL���
		String sql = "select * from user_tb";
		//ִ��SQL���
		List<Map<String,Object>> list = qr.query(cn, sql, new MapListHandler());
		//���������ѭ������List���ϣ��ڲ�ѭ������Map����
		for(Map<String,Object>map:list){
			for(String key:map.keySet()){
				System.out.println(key+"  "+map.get(key));
			}
			System.out.println();
		}
		//�ͷ���Դ
		JDBCUtils_03.relase(cn, null, null);
	}
}
