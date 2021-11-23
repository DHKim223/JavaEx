package j03;

// 정수 하나 입력
// 2~9 사이면 구구단 출력
// 2~9 사이가 아니면 다시 입력(반복문)

//System.in.read()  -- 글자 하나만 입력받음 -- 숫자로 리턴(ASCII 코드값)
// 
 

public class DoWhileEx1 {

	public static void main(String[] args) throws Exception{
		
		int dan =0;
		do {
			System.out.println("정수(2~9) : ");
			dan = System.in.read()-48;
			System.in.read(); // 엔터를 잡아가고 , 실제로 입력된 것을 쓰진 않는다
			System.in.read(); // 버퍼에 남아있는 Enter를 없애라.... 
		}while (dan<2 || dan >9);     // 2~9단이 아니면 do 로 돌아가서 다시실행!
			
			for(int i =1; i<10; i++) {                 // 올바른 dan 값을 받았을때 실행된다.
				System.out.println(dan+"*"+i +"="+dan*i);
			}
	}
//키보드 버퍼 (임시 기억장소)
// read 는 버퍼에 있는 값을 읽는다. 
// 2라는 값이 나오면
// 버퍼에 있는 데이터(엔터)를 지워야할때가 있다.

}
