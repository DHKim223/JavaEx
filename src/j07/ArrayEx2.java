package j07;

// 2차원 배열
public class ArrayEx2 {
	public static void main(String[] args) {
		int size = 5;
		int m[][] = new int [size][size];	//5열 5행
		int cnt =0;
		
		
		for (int i=0; i<m.length; i++) {									// 입력
			for ( int j=0; j<m[i].length; j++) {
				//m[i][j] = ++cnt;												// i 행 j 열
				//m[j][i] = ++cnt;												// j 형 i 열
				//if (i+j == 4 || i==j) m[i][j] = ++cnt;	
				//if (i != 4 && j!=4 && i != 0 && j !=0) m[i][j] = ++cnt;	
				if ( (i+j)>=size/2 && (j-i)<=size/2 && (j-i)>= -(size/2) && (i+j)<= (size + (size/3)) )
					m[i][j] = ++ cnt;
				
			
			}
		} 
		
		
		for (int i=0; i<m.length; i++) {				// 행 m.length					// 출력
			for ( int j=0; j<m[i].length; j++) {		// 열
				System.out.print(m[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
