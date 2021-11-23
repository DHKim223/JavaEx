package j07;

// Array 는 같은 자료형의 모임
// index (0) 부터 시작
// 나열된 메모리
// 자바에서는 배열도 객체다

public class ArrayEx {

	public static void main(String[] args) {
		int m[];										// 참조변수... 배열 생성이 아니다.
 		m = new int[] {10, 20, 30};      // 배열 잡을때 무조건 new 로 잡아야함...... // heap 영역에 할당받은 인스턴스
		
 		int w[] = new int [3];
 		
 		int n[] = {10 , 20 , 30 };		//초기값을 줄 경우에는 new 를 생략해도 된다.... 두번째줄과 같음.
 		

 		System.out.println("m[0] : " + m[0]);
 		System.out.println("m[0] : " + m[1]);
 		System.out.println("m[0] : " + m[2]);
 		
 		System.out.println();
 		for ( int i = 0; i < m.length ; i ++ ) {							// m.length 는 배열의 갯수값
 			System.out.println("m["+i+"] : " + m[i]);
 		} 
 		System.out.println();
 		
 		// 개선된 반복문 _ 1.5 버전부터
 		for( int a : m ) {								//변수는 배열과 같은 자료형. 배열이나 컬렉션만 올 수 있다.
 			System.out.println( a );
 		}
	}

}
