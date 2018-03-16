package com.xiao.DButilsTest;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import com.xiao.utils.C3P0Utils;
/**
 * @author ЦЦ
 * @Date   2018��3��16������2:41:56
 *	
 */
public class DButils_C3P0Pool {
	//�������,ʹ��QueryRunner���update����
	@Test
	public void addUser() throws Exception{
		//����QueryRunner��Ķ���,ʹ��C3P0Utils��ȡ���ӳ�
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//��дSQL���
		String sql = "insert into user_tb values(?,?,?,?,?,?)";
		//����ռλ����ʵ�ʲ���д��������
		Object[] params = {0,"ЦЦ","123456",23,"��","123@123.com"};
		//����updateִ��SQL���
		int row = qr.update(sql, params);
		if(row > 0){
			System.out.println("����û��ɹ���");
		}else{
			System.out.println("����û�ʧ�ܣ�");
		}
		
	}

}
