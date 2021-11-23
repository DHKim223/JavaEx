package j04;

public class MultiForEx2 {

	public static void main(String[] args) {
		
		//1번
		
		for(int i=0; i<5; i++) {		 //0~4      5번 행
			for( int j =0; i>=j; j++) {  // 0~4		5번 열 
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 2번
		
		for(int i=0; i<5; i++) {		 
			for( int j =5; i<j; j--) {  
				System.out.print("* ");
		} System.out.println();
	}
	
	System.out.println();
		
	
		//3번
	
		for(int i=0; i<5; i++) {		 
			for( int j =4; j >=0; j--) {  
				if(i  <  j ) System.out.print("   ");
				else System.out.print("* ");
		} System.out.println();
	}
	
	System.out.println();
	
		//4번
	
		for(int i=0; i<5; i++) {		 //0~4      5번 행
			for( int j =0; j<5; j++) {  // 0~4		5번 열 
				if(j>=i)System.out.print("* ");
				else System.out.print("   ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 5번
		
		for(int i=0; i<5; i++) {		 
			for( int j =4; j >= 0; j--) {  
				if(i  < j ) System.out.print("   ");
				else System.out.print("* ");}
			for( int j =0; i>=j; j++) {  // 0~4		5번 열 
				System.out.print("* ");
			}
			System.out.println();	
		} 
		
		for(int i=0; i<5; i++) {		 //0~4      5번 행
			for( int j =0; j<5; j++) {  // 0~4		5번 열 
				if(j>=i)System.out.print("* ");
				else System.out.print("   ");
			}
			for( int j =5; i<j; j--) {  
				System.out.print("* ");
		} 
			System.out.println();
		}
	    
	}    
}
