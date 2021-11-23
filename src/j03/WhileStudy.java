package j03;

// 0~9까지 랜덤수를 하나 발생
// 한자리 값을 입력 받아서 맞았으면 몇번만에 맞췄는지를 알려 준 후 break로 빠져나온다
// 틀렸을 경우 작다/크다를 알려준다.

public class WhileStudy {

	public static void main(String[] args) throws Exception{
		int rand = (int) (Math.random() * 10);  // 0~9 랜덤
		int cnt = 0;
		
		while(true) {
			cnt++;	
			System.out.print("0~9 입력 :  ");
			int a = System.in.read()-48;
			System.in.read();
			System.in.read();
		
			if (a>rand) {
				System.out.println("입력한 값이 더 큼");			
			} else if (a<rand){
				System.out.println("입력한 값이 더 작음");			
			} else {
				System.out.println(cnt + "번 만에 정답!"); 
				break;
			}
		}

	}
}