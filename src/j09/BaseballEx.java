package j09;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// ���� �߱� ����

// ��ǻ�Ͱ� ������ ���ڸ� �߻� (3�ڸ�)
// ���ڸ� �����
// ���ڵ��°� �ڸ����� �´°� ��Ʈ����ũ.
// ���ڴ� ������ �ڸ��� �ٸ��� ��.
// �� ������ ����.

// �޼����  �Է�/����/��� ����...


class Baseball {
	// ���ڹ߻�
	public int[] randnumb() {
		int number[] = {0,0,0};
		for (int i=0; i<3; i++) {			
			number[i] = (int) (Math.random( )*9) +1;
			for (int j=0; j<i; j++)
			{
				if ( number[i] == number[j])	i--;			
			}
		}	System.out.println("��ǻ�Ͱ� ���ڸ� �߻��Ͽ����ϴ�!");
		return number;
	}
	
	// ����� �Է�
	public int input() throws Exception{
		int guess;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�Է� : ");
		guess = Integer.parseInt( br.readLine());		
		return guess;
	}
	
	// ����
	public boolean compare(int guess, int number[]) {
		int convert[] = {0,0,0};
		
		int scnt=0;
		int bcnt=0;
		
		convert[0] = guess  / 100;
		convert[1] = (guess - convert[0]*100)/10;
		convert[2] = guess % 10;
		
		for( int i=0; i<3; i++) {
			for( int j=0; j<3; j++) {
				if (i==j) {
					if (number[i] == convert[j]) scnt ++;
				} else {
					if ( number[i] == convert[j]) bcnt ++;
				}
			}				 
		}
		System.out.print("Strike : " + scnt + "\t");
		System.out.println("Ball : " + bcnt);
		
		if(scnt ==3) { return true;}
		else {return false;}
	}						

}

public class BaseballEx {

	public static void main(String[] args) throws Exception {
		Baseball bb = new Baseball();		
		System.out.println("���߾� ������!");
		int m[] = bb.randnumb();		
		
		while(true) {				
		int guess = bb.input();		
		if( bb.compare(guess,m) == true) {
			System.out.println("�����Դϴ�!");
			break;
			}
		}
		
	}
}
