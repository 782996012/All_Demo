package com.xiao.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
/**
 * @author ЦЦ
 * @Date   2018��2��8������11:03:45
 *	
 */
public class ListDemo {
	
	// void add(int index, E element) ������������Ԫ��
	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("abc");							
		list.add("abc");							
		list.add("abc");							
		System.out.println(list);
		list.add(1, "cde");					//������������Ԫ�أ�������ԭ�е���������˳��
		System.out.println(list);
	}
	// E get(int index) ���ؼ�����ָ��λ�õ�Ԫ��
	@Test
	public void test2(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("abc");							
		list.add("abc");							
		list.add("abc");
		String a = list.get(2);			    //��������ȡԪ��
		System.out.println(a);
	}
	// E remove(int index)   �Ƴ�ָ��λ���ϵ�Ԫ�أ������Ƴ���Ԫ��
	@Test
	public void test3(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("cde");							
		list.add("fff");							
		list.add("ggg");
		String remove = list.remove(1);		//�Ƴ�ָ��λ�õ�Ԫ��  �����Ƴ���Ԫ��
		System.out.println(remove);
		System.out.println(list);
	}
	// E set(int index, E element)    �޸�ָ��λ�õ�Ԫ��  �����޸�֮ǰ��Ԫ��
	@Test
	public void test4(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("cde");							
		list.add("fff");							
		list.add("ggg");
		String set = list.set(1, "123");	//�޸�ָ��λ�õ�Ԫ��  �����޸�֮ǰ��Ԫ��
		System.out.println(set);
		System.out.println(list);
	}
	//�������Ĳ����޸��쳣
	@Test
	public void test5(){
		List<String> list = new ArrayList<String>();
		list.add("abc");							
		list.add("cde");							
		list.add("fff");							
		list.add("ggg");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String string = iterator.next();
			if(string.equals("fff")){
				list.add("ccc");				//���ȡ������Ԫ�ص���fff  �����һ��ccc  ��������ֲ����޸��쳣
			}
			System.out.println(list);
		}
		
	}
	
	
	//LinkedList������
	//void addFirst(E e)  ���б�Ŀ�ͷ���Ԫ��
	//void addLast(E e)   ���б�Ľ�β���Ԫ��
	// E getFirst() 	     ��ȡ����ĵ�һ��Ԫ��
	// E getLast() 	  	     ��ȡ����ĵ�һ��Ԫ��
	// E removeFirst 	    �Ƴ������ش��б�ĵ�һ��Ԫ��
	// E removeLast 	    �Ƴ������ش��б�����һ��Ԫ��
	 
	@Test
	public void test6(){
		LinkedList<String> list = new LinkedList<>();
		list.add("abc");
		list.addFirst("ced");					//���б�Ŀ�ͷ���Ԫ��
		list.addLast("ccc"); 					//���б�Ľ�β���Ԫ��
		System.out.println(list);
		
		if(list.isEmpty()){						//�������Ϊ��  ����ȡԪ��   
			String first = list.getFirst();		//��ȡ����ĵ�һ��Ԫ��
			String last = list.getLast();		//��ȡ����ĵ�һ��Ԫ��
			System.out.println(first);
			System.out.println(last);
		}
	}
	
	
}
