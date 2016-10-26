package test;

public class Test2 {
	public static void test(String str) {
		if(str==null||str.length()==0){
			System.out.println("String is empty");
		}else{
			System.out.println("String is not");
		}
	}

	public static void main(String[] args) {
		test(null);
	}
}

//String is empty

//str.equals(null) 
//Exception in thread "main" java.lang.NullPointerException
//at test.Test2.test(Test2.java:5)
//at test.Test2.main(Test2.java:13)
