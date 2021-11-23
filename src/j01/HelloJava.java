package j01;

public class HelloJava {
	public static void main( String[] args ) {
		
		String str = "Hello Java!!!";
		int a = str.length();
		System.out.println(a);
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		
		
	}
}

