package java8;

import java.util.Collections;
import java.util.LinkedList;

public class SecondMaxSort {

	//归并排序——nlog(n)时间复杂度
	//The sorting algorithm is a modified mergesort 
	//(in which the merge is omitted if the highest element in the low sublist is less than the lowest element in the high sublist). 
	//This algorithm offers guaranteed n log(n) performance.
	
	//Time complexity:O(Nlog(N))
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(11);
		list.add(10);
		
		Collections.sort(list);
		list.removeLast();
		int a = list.getLast();
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);//divide by 1000000 to get nanoseconds.
		System.out.println(a);
		System.out.println(duration);//995950
	}
}
