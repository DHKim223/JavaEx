package j07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayEx1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m[] = new int[5];
		
		for( int i= 0; i<m.length; i++) {			//입력
			System.out.print("정수 : " );
			m[i] = Integer.parseInt( br.readLine());
		}
		
		///처리
		// 최댓값
		int max = m[0];
		for (int i=0; i<m.length; i++) {
			if ( max < m[i]) max=m[i];
		} System.out.print(" max : " + max + "\t");
		
		//최솟값
		int min = m[0];
		for (int i = 0; i<m.length; i++) {
			if ( min > m[i]) min=m[i];
		} System.out.println(" min : " + min);
		
		//석차
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
		
		// sort - 오름차순 ( ascending ) / 내림차순 (descending)
		// selection sort ( 선택정렬)
		int temp = 0;
		for ( int i  = 0 ; i<m.length-1 ; i++) {	// 기준 .. 전체방 보다 하나 적게
			for ( int j= i+1; j<m.length; j++) {		// 비교 		기준  다음방 부터
				if(m[i] > m[j]) {
					temp = m[i];
					m[i] = m[j];
					m[j] = temp;
				}
			}			
		}
		
		
		for (int i = 0; i<m.length; i++) {		//출력
			System.out.print(m[i] + "\t");
		}
	}
}
