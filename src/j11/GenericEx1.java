package j11;

// < ? super 객체자료형(class 이름) >				명시된 객체를 포함한 상위 객체들의 배치
//													객체 내부의 모든 제네릭 타입은 Object로 인식
// < ? extends 객체자료형>			명시된 객체를 포함한 하위 객체들의 배치
//													객체 내부의 모든 제네릭 타입은 extends 다음에
//													명시된 객체자료형으로 인식     

class SuperA{
	private String a = "SuperA";
	public String getA() {
		return a;
	}
}

class SuperB extends SuperA{
	private String b = "SuperB";
	public String getB() {
		return b;
	}
}

class SuperC extends SuperB{
	private String c = "SuperC";
	public String getC() {
		return c;
	}
}

class GenericSuper <T>{
	private T t;
	public GenericSuper(T t) {
		this.t=t;
	}
	public void set(T a) {
		this.t = t;
	}
	public T get() {
		return t;
	}
}
public class GenericEx1 {
	public static void main(String[] args) {
		//GenericSuper <Integer> gs = new GenericSuper <Integer> (10);
		GenericSuper <?> gs = new GenericSuper <Integer> (10);
			// ? 			참조변수가 Object로 활용
		int g = /* Object  class 라 int 로 형변환을 해야 들어감*/ (Integer)gs.get();
		System.out.println("g : " + g);
		
		SuperA sua = new SuperA();
		SuperB sub = new SuperB();
		SuperC suc = new SuperC();
		
		// super 인 경우 자기포함 상위만 넣을 수 있다
		GenericSuper<? super SuperB> gs1 = new GenericSuper<SuperA>(sua);	
		GenericSuper<? super SuperB> gs2 = new GenericSuper<SuperB>(sub);	
		//GenericSuper<? super SuperB> gs3 = new GenericSuper<SuperC>(suc);	
		SuperB sb = (SuperB) gs2.get();    //retrun 값은 Object 객체 
		System.out.println("sb : " + sb.getB());
		
		// extends 명시한 클래스 포함 하위 클래스
		//GenericSuper <? extends SuperB> gs4 = new GenericSuper<SuperA>(sua);   상위클래스라 에러남.
		GenericSuper <? extends SuperB> gs4 = new GenericSuper<SuperB>(sub);
		GenericSuper <? extends SuperB> gs5 = new GenericSuper<SuperC>(suc);
		//gs5.get(); // return 값은 superB로 리턴된다.
		SuperC sc = (SuperC)gs5.get();
		System.out.println("sc : " + sc.getC());

		
	}
}
