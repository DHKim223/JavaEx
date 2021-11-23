package j11;

// < ? super ��ü�ڷ���(class �̸�) >				��õ� ��ü�� ������ ���� ��ü���� ��ġ
//													��ü ������ ��� ���׸� Ÿ���� Object�� �ν�
// < ? extends ��ü�ڷ���>			��õ� ��ü�� ������ ���� ��ü���� ��ġ
//													��ü ������ ��� ���׸� Ÿ���� extends ������
//													��õ� ��ü�ڷ������� �ν�     

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
			// ? 			���������� Object�� Ȱ��
		int g = /* Object  class �� int �� ����ȯ�� �ؾ� ��*/ (Integer)gs.get();
		System.out.println("g : " + g);
		
		SuperA sua = new SuperA();
		SuperB sub = new SuperB();
		SuperC suc = new SuperC();
		
		// super �� ��� �ڱ����� ������ ���� �� �ִ�
		GenericSuper<? super SuperB> gs1 = new GenericSuper<SuperA>(sua);	
		GenericSuper<? super SuperB> gs2 = new GenericSuper<SuperB>(sub);	
		//GenericSuper<? super SuperB> gs3 = new GenericSuper<SuperC>(suc);	
		SuperB sb = (SuperB) gs2.get();    //retrun ���� Object ��ü 
		System.out.println("sb : " + sb.getB());
		
		// extends ����� Ŭ���� ���� ���� Ŭ����
		//GenericSuper <? extends SuperB> gs4 = new GenericSuper<SuperA>(sua);   ����Ŭ������ ������.
		GenericSuper <? extends SuperB> gs4 = new GenericSuper<SuperB>(sub);
		GenericSuper <? extends SuperB> gs5 = new GenericSuper<SuperC>(suc);
		//gs5.get(); // return ���� superB�� ���ϵȴ�.
		SuperC sc = (SuperC)gs5.get();
		System.out.println("sc : " + sc.getC());

		
	}
}
