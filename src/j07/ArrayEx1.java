package j07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayEx1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m[] = new int[5];
		
		for( int i= 0; i<m.length; i++) {			//�Է�
			System.out.print("���� : " );
			m[i] = Integer.parseInt( br.readLine());
		}
		
		///ó��
		// �ִ�
		int max = m[0];
		for (int i=0; i<m.length; i++) {
			if ( max < m[i]) max=m[i];
		} System.out.print(" max : " + max + "\t");
		
		//�ּڰ�
		int min = m[0];
		for (int i = 0; i<m.length; i++) {
			if ( min > m[i]) min=m[i];
		} System.out.println(" min : " + min);
		
		//����
		int rank[] = new int[5];
		
		for (int i=0; i<rank.length;i++) {
			int ran=1;
			for (int j=0; j<rank.length; j++) {
				if( m[i] > m[j]) {
					ran +=1;					
				}rank[i]= ran;
			}
		}
		
		for (int i=0; i<rank.length; i++) {
			System.out.print(rank[i] + "\t");
		} System.out.println();
		
		// sort - �������� ( ascending ) / �������� (descending)
		// selection sort ( ��������)
		int temp = 0;
		for ( int i  = 0 ; i<m.length-1 ; i++) {	// ���� .. ��ü�� ���� �ϳ� ����
			for ( int j= i+1; j<m.length; j++) {		// �� 		����  ������ ����
				if(m[i] > m[j]) {
					temp = m[i];
					m[i] = m[j];
					m[j] = temp;
				}
			}			
		}
		
		
		for (int i = 0; i<m.length; i++) {		//���
			System.out.print(m[i] + "\t");
		}
	}
}
