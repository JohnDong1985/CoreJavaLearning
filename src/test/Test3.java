package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test3 {
	public static void m1(String s) {
		s= s.replace('C','E');
		System.out.println("s");//(1)
	}

	public static void m2(String s) {
		s="FGHI";
	}
	
	public static void m3(StringBuilder sb) {
		sb.reverse();
	}
	
	public static void m4(List list, String s) {
		list.add(s);
	}
	
	public static void m5(char[] c) {
		c[0] = '1';
	}
	
	public static void main(String[] args) {
		String s = "ABCD";
		char[] c = {'a','b','c'};
		
		m1(s);
		System.out.println(s);//(2)
		m2(s);
		System.out.println(s);//(3)
		
		StringBuilder sb = new StringBuilder(s);
		m3(sb);
		System.out.println(sb.toString());//(4)
		
		List<Integer> intList = new ArrayList<Integer>();
		List<Integer> intList2 = new LinkedList<Integer>();
		m4(intList,"0028");
		System.out.println(intList.get(0));//(5)
		
		m5(c);
		System.out.println(c[0]);//(6)
	}
}

//1.s
//2.ABCD
//3.ABCD
//4.DCBA
//5.0028
//6.1
