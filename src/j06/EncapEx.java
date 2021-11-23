package j06;

// 원칙은 클래스 하나당 파일은 하나
// 클래스 앞에는 public / default        * 파일 하나에 클래스를 여러개 구현하는 경우 main 만 public 가능 
// default 는 안쓰는것이 default 
// 멤버 앞에는 public / protected / default / private 
class Encap{										// default 부품 / main 메서드 없음
	private int a = 10;
	int b = 20;  // default 
	protected int c = 30;
	public int d = 40;
	
	public int getA() {         // 직접접근 막고 함수를 통해 호출
		return a;
	}
}

public class EncapEx {							//public 실행
	
	private int aa =1;
	int bb =2;
	protected int cc = 3;
	public int dd =4; 
		
	
	public static void main(String[] args) {
		
		EncapEx ee = new EncapEx();
		System.out.println(" private : " + ee.aa);
		System.out.println(" default  : " + ee.bb);
		System.out.println(" protected  : " + ee.cc);
		System.out.println(" public : " + ee.dd);

		
		
		
		Encap ec = new Encap();
		System.out.println(" private : " + ec.getA());	//private		같은 멤버만 접근 ,,, 상속과 상관없이 Encap 안에서만 사용가능
		System.out.println(" default : " + ec.b);	//default		같은 패키지에 있으면 접근가능
		System.out.println(" default : " + ec.c);	//protected	같은 패키지 이거나 상속 받았을 경우
		System.out.println(" default : " + ec.d); // public 		모든경우 가능
	}

}
