package j06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// return ���� �ϳ�

// ���� 3���� �Է¹޾Ƽ� ���� ū �� �ϳ��� ���
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
		
		System.out.print("���� 1 : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("���� 2 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("���� 3 : ");
		int c = Integer.parseInt(br.readLine());
		
		MethodEx5 me = new MethodEx5();
		System.out.println("ū ��: " + me.big(a,b,c));
	}

}

