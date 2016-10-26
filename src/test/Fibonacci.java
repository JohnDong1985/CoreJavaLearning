package test;

public class Fibonacci{
	public static long fib1(int n){
		if (n==0) {
			return 0;
		}
		else if (n==1||n==2) {
			return 1;
		}else{
			return fib(n-1)+fib(n-2);
		}
	}
	
	public static long fib(int n){
		long a = 0, b=1;
        
        // In N steps compute Fibonacci sequence iteratively.
        for (int i = 0; i < n; i++)
        {
             long temp = a;
             a = b;
             b = temp + b;
        }
        return a;
	}
	
	public static void main(String[] args){
//		int N = Integer.parseInt(args[0]);
		for (int i = 0; i < 10; i++) {
			System.out.println(i + ": " + fib(i));
		}
	}
	
//	Example Of Test Driven Design
//	In this example I am going to create a Fibonacci Sequence.  To start off I created a project and a test project.
//	These are the steps I used in my TDD:
//	In the Test project I created a class called FibonacciSequenceTests.  In the class I created the following test:
	public void Test_Find_Fibonacci_Sequence_At_Position_Correct()
	{
	     //Arrange
		Fibonacci fibonacciSequence = new Fibonacci();

	     //Act
	     long sequenceAtPosition = fibonacciSequence.fib(8);

	     //Assert
	     assert (sequenceAtPosition==21);
	}
	
}