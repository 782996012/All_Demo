package com.xiao.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;
/**
 * @author ЦЦ
 * @Date   2018��2��8������2:09:55
 *	
 */
public class SetDemo {
	
	//set�ӿڵ�ʵ���� HashSet����ʾ
	//set�Ǵ�ȡ����ļ���
	
	@Test
	public void test1(){
		Set<String> set = new HashSet<>();		
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		set.add("ddd");							
		set.add("ddd");							//������洢�ظ�  �Զ������ظ���Ԫ�أ����ݹ�ϣֵ���ж��Ƿ��ظ� ��������ʾ�ظ���
		for (String string : set) {				//ȡ��Ԫ�ص�˳������˳��һ��
			System.out.println(string);			
		}
		
	}
	//set�ӿڵ�ʵ���� LinkedHashSet
	//LinkedHashSet����������ԣ�����˳�򣬴桢ȡ��˳��һ��
	@Test
	public void test2(){
		LinkedHashSet<Integer> link = new LinkedHashSet<>();
		link.add(1);
		link.add(2);
		link.add(3);
		for (Integer integer : link) {
			System.out.println(integer);
		}
		
	}
}
