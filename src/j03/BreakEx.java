package j03;

public class BreakEx {

	public static void main(String[] args) {
		int i =0;
		
		//반복문이 언제까지 반복되는지 모를때 무한루프 돌려 break로 끊는다
				
		while(true) {							// 참 -> 실행  |  거짓 -> 실행 X
			i++;
			
			if (i>10) break;
			
			if(i%2==1)continue; 			// 홀수일땐 아무것도 하지 않고 continue
														// continue는 실행순서를 복잡하게 해서 사용을 지양할것
			System.out.println("i : " + i);
						
		}
		
	}
}
