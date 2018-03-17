package com.xiao.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.Test;
/*Collection �ǳ����࣬���Բ��ܴ�������
   ֻ��ͨ����������ѧϰ������ķ���
  ������ķ��������м���ʵ�����б��еķ���
 ArrayList ʵ����List�ӿ�
 List�ӿ� �̳���Collection
  ����ArrayList��д��Collection�������еķ���
*/
/**
 * @author ЦЦ
 * @Date   2018��2��8������11:03:39
 *	
 */
public class CollectionDemo {
	
	//void clear() ����
	@Test
	public void test1(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					//���Ԫ�ط���
		coll.add("cde");
		System.out.println(coll);
		coll.clear();						//�������������Ԫ��
		System.out.println(coll);
	}
	
	//boolean contains(Object o) ����
	@Test
	public void test2(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		boolean b = coll.contains("abc");   //�ж϶����Ƿ�����ڼ�����
		System.out.println(b);
	}
	//int size() ����
	@Test
	public void test3(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		int i = coll.size();				//����Ԫ�ظ���
		System.out.println(i);
	}
	// Object[] toArray() ����
	@Test
	public void test4(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		Object[] array = coll.toArray();    //�Ѽ����е�Ԫ��ת��һ������
		for (Object object : array) {
			System.out.println(object);
		}
	}
	//boolean remove(Object o) ����  
	@Test
	public void test5(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		boolean b = coll.remove("abc"); 	//�Ƴ������е�ָ����Ԫ�أ�������ڷ���true
		System.out.println(b);
	}
	
	//������  Iterator<E>�ӿ�    ����ͨ�õĵ�����ʽ    
	//boolean hasNext()  //�жϼ������Ƿ��п��Ա�ȡ����Ԫ�أ��з���true
	//E next() 			 //ȡ�������е���һ��Ԫ��
    @Test
    public void test6(){
    	Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		Iterator<String> iterator = coll.iterator();
		while(iterator.hasNext()){			//�����Ԫ�أ�ȡ���������û�н���ѭ��
			String next = iterator.next();
			System.err.println(next);
		}
    }
    //��ǿforѭ�� �������� ������                 
    //�׶ˣ�û�����������ܲ������������Ԫ��
    @Test
    public void test7(){
    	Collection<String> coll = new ArrayList<String>();
		coll.add("abc");					
		coll.add("cde");
		for (String string : coll) {
			System.out.println(string.length());	//������ʱ����Ե��ö���ķ���
		}
    }

}
