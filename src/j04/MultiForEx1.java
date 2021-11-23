package j04;

//구구단
// 2단
// 2*1 = 2
// 2*2 = 4 .....

public class MultiForEx1 {

	public static void main(String[] args) {
				
//		for (int i= 2; i<10; i++) {
//			System.out.println(i +  "단");
//			for (int j =1; j<10; j++) {
//				System.out.println(i + "*" + j + "=" + (i*j));
//			} System.out.println();
//		}
		
// 2*1=2		3*1=3  	..... 9*1=9		
		
		for(int i=2; i<10;i++) System.out.print( i + "단\t\t");
		System.out.println();
		
		for (int i= 1; i<10; i++) {			
			for (int j =2; j<10; j++) {
				System.out.print(j + "*" + i + "=" + (i*j)+"\t");
		}  	System.out.println();
	}
			
		
	}

}
