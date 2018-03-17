package com.xiao.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Test;
/**
 * @author ЦЦ
 * @Date   2018��2��9������8:37:47
 *	
 */
public class MapDemo {
	
	// V put(K key, V value) ����  ��Ӽ�ֵ�ԣ�����ֵһ�������Ϊnull,�洢�ظ���ʱ�����ظ���֮ǰ��ֵ
	@Test
	public void test1(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "ЦЦ");
		map.put("username", "����");						//��Ψһ����ͬ���Ḳ��
		map.put("username1", "ЦЦ");
		String value = map.put("username", "ЦЦ");		//����ֵһ�������Ϊnull,�洢�ظ���ʱ�����ظ���֮ǰ��ֵ
		System.out.println(value);
		System.out.println(map);
	}
	// V get(Object key) ����  ͨ�������� ��ȡֵ����
	@Test
	public void test2(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "ЦЦ"); 
		String string = map.get("username");	// ͨ�������� ��ȡֵ����  ���û�������������null
		System.out.println(string);
	}
	// V remove(Object key) ����  �Ƴ������еļ�ֵ�ԣ������Ƴ�֮ǰ��ֵ
	@Test
	public void test3(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "ЦЦ"); 
		String remove = map.remove("username");	//�Ƴ������еļ�ֵ�ԣ������Ƴ�֮ǰ��ֵ  ���û�� ����null
		System.out.println(remove);
	}
	
	
	
	//Map���ϵı���	 Set<K> keySet()  �����е�Key�ŵ���һ��Set������  ������ȡֵ�ķ�ʽ��
	@Test
	public void test4(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "ЦЦ"); 
		map.put("username1", "����"); 
		map.put("username3", "����"); 
		Set<String> set = map.keySet();    //����keySet()���� �Ѽ��洢��Set�����У���HashMap�е�һ���ڲ���ʵ�ֵģ�
		
		for (String key : set) {		   //����set���ϣ���ȡ���е�key
			String value = map.get(key);   //����map��get�������key��Ӧ��ֵ	
			System.out.println(value);
		}
	
	}
	// Set<Map.Entry<K,V>> entrySet()   ͨ����ֵ�Ե�ӳ���ϵ������
	@Test
	public void test5(){
		
		Map<String,String> map = new HashMap<>();
		map.put("username", "ЦЦ"); 
		map.put("username1", "����"); 
		map.put("username3", "����"); 
		
		Set<Entry<String,String>> set = map.entrySet();		//��ӳ���ϵ����洢��se����
		
		for (Entry<String, String> entry : set) {			//����set����
			//System.out.println(entry);					//��ü�ֵ��  ����entry
			/*String key = entry.getKey();					//ͨ��getKet��ü�
			System.out.println(key);*/
			String value = entry.getValue();				//ͨ��getValue���ֵ
			System.out.println(value);
		}
	}
	
	//HashMap �ı��� �����淽ʽһ��
	@Test
	public void test6(){
		HashMap<String,String> map = new HashMap<>();
		map.put("username", "ЦЦ"); 
		map.put("username1", "����"); 
		map.put("username3", "����");
		
		Set<String> set = map.keySet();
		for (String key : set) {
			String value = map.get(key);
			System.out.println(value);
		}
		
	}
	//LinkedHashMap,�̳���HashMap,��֤�˵�����˳��
	@Test
	public void test7(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("a", "ЦЦ");
		map.put("b", "ЦЦ1");
		map.put("c", "ЦЦ2");
		System.out.println(map);
	}
}
