package j06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// return 값은 하나

// 정수 3개를 입력받아서 가장 큰 수 하나만 출력
public class MethodEx5 {
	
	public int big ( int a , int b , int c) {
		int biggest;
		if (a > b && a > c) {
			biggest = a;
		} else if ( b> c ) {
			biggest = b;
		} else biggest = c;
		return biggest;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader ( System.in)); // IO
		
		System.out.print("정수 1 : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("정수 2 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("정수 3 : ");
		int c = Integer.parseInt(br.readLine());
		
		MethodEx5 me = new MethodEx5();
		System.out.println("큰 수: " + me.big(a,b,c));
	}

}

