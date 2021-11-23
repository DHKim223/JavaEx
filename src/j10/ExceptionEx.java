package j10;

// Java 는 경고도 에러___ 예외처리 가능

// 에러가 안나는 예외 // java.lang.RuntimeException 을 상속받은 애들.....
// 예외처리				try~catch 잡는다 / throws 던진다.
public class ExceptionEx {
	public static void main(String[] args) {
		int m[] = { 10 , 20 , 30};
		
		try {
			for ( int i=0; i<m.length + 1; i++) {
				System.out.println(i + "\t" + m[i]);
			}	
			System.out.println("프로그램 끝");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 범위를 넘었다.");
			e.printStackTrace();
		} finally {
			// 예외가 있건 없건 무조건 실행하는 블록
			System.out.println("프로그램끝 ");
		}
		
	
	}
}
