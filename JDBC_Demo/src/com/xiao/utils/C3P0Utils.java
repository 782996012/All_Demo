package com.xiao.utils;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//����Ĭ�������ļ�Ŀ¼��src/c3p0-config.xml
	public static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//��ȡ���ӳ�
	public static DataSource getDataSource(){
		return dataSource;
	}
	
}
