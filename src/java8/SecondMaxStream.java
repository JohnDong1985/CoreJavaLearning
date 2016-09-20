package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecondMaxStream {

//	public static void main(String[] args) {
//		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(2);
//		list.add(11);
//		list.add(10);
//		
//		int a = list.stream().sorted().collect(Collectors.toList()).get(list.size()-2);
//		
//		System.out.println(a);
//	}
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int[] array = {1,3,4,5,2,11,10};
//		int a = Arrays.stream(array).sorted().toArray()[array.length-2]; //duration: 54245926
		int a = Arrays.stream(array).parallel().sorted().toArray()[array.length-2]; //duration: 52320395
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);//divide by 1000000 to get nanoseconds
		System.out.println(a);
		System.out.println(duration);
	}
	
	//The result is worst how to solve ?
	
}
