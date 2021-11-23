package j08;
// 오버로드					다중정의.... 하나의 클래스에 같은 이름의 메소드가 여러개
// 오버라이드					재정의. 상속받은 자식클래스가 부모클래스 메서드를 다시 만드는 경우

// Override					부모에 있는 메소드가 자식에도 있는 경우 ( 상속 관계가 있어야만 한다.)

class OverrideSuper {
	 String name = "부모클래스"; 
	public String getName() {								// 같은 메서드
		return name;
	}
}

public class OverrideEx extends OverrideSuper {
	
	String name = "자식클래스";
	public String getName() {						// 오버라이드 메서드 / 부모 메서드 실행하지 말고 내꺼 실행해라!!!
		return name;
	}
		
	public static void main(String[] args){
		// 부모클래스 참조변수 = 부모클래스 인스턴스
		OverrideSuper os = new OverrideSuper();
		System.out.println("이름 : "  + os.name);
		System.out.println("이름 : " + os.getName());
		
		// 자식클래스 참조변수 = 자식클래스 인스턴스
		OverrideEx oe = new OverrideEx();
		System.out.println("이름 : "  + oe.name);
		System.out.println("이름 : " + oe.getName());
		
		//	부모클래스 참조변수 = 자식클래스 인스턴스
		OverrideSuper os1 = new OverrideEx();		// 부모클래스에 자식 클래스를 대입하여라.... 가능 // 자동형변환 / 프로모션
		System.out.println("이름 : "  + os1.name);					//부모클래스 __ 참조변수쪽에 우선권이 있어서 부모클래스.
		System.out.println("이름 : " + os1.getName());			//자식클래스__ 메서드 오버라이드는 자식쪽 하나만 살아남는다.
		
		//	자식클래스 참조변수 = 부모클래스 인스턴스	// 자식클래스에 부모클래스를 대입하여라... 불가능
//		OverrideEx oe1 = (OverrideEx) new OverrideSuper();	// 강제형변환 / 디모션
//		System.out.println("이름 : "  + oe1.name);
//		System.out.println("이름 : " + oe1.getName());
	
		// 변수의 이름이 같더라도 데이터를 저장해야 하기때문에 부모쪽 자식쪽 따로 잡는다.
		// 메서드는 부모쪽은 메모리에 존재하지 않고 자식쪽만 살아 남는다. ... 같은 메서드는 같은 일을 하기 대문에
		// 자식클래스(int) <<< 부모클래스(double)___자식클래스를 부모클래스에 넣을 수 있지만, 반대는 안됨
		// 하지만 강제형변환 이 있듯이.... 강제로 변환해서 부모클래스를 자식클래스에 대입할 수 있다.
	
		// API 매개변수의 상속관계
		String str = "Hello Java!!!";
		String s = "!!";
		StringBuffer sb = new StringBuffer ("!!");
		StringBuilder su = new StringBuilder ("!!");
		
		System.out.println("String : " + str.contains(s));					// CharSequence <= String
		System.out.println("StringBuffer : " + str.contains(sb) ); 	// CharSequence <= StringBuffer
		System.out.println("StringBuilder : " + str.contains(su) );	// CharSequence <= StringBuilder
		
		
		
	
		
	}

}
