package java8;

public class SecondMax {
	
	//only loop once
	//Time complexity:O(N)
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		int[] array = {1,3,4,5,2,11,10};
		
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		// Loop over the array
		for (int i = 0; i < array.length; i++) {

		    // If we've found a new highest number...
		    if (array[i] > highest) {

		        // ...shift the current highest number to second highest
		        secondHighest = highest;

		        // ...and set the new highest.
		        highest = array[i];
		    } else if (array[i] > secondHighest)
		        // Just replace the second highest
		        secondHighest = array[i];
		    }
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);//divide by 1000000 to get nanoseconds.
		System.out.println(secondHighest);
		System.out.println(duration);//1580 best
		
	}
}
