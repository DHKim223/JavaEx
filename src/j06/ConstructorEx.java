package j06;

// 생성자 Constructor				소멸자 ( 메모리 정리 함수 ) Destructor 는 없음
// 생성자는 Method
// 클래스명과 동일하다.
//결과형 반환형이 없다.				// void 는 리턴은 하지만 리턴값이 없다.
// 구현하지 않으면 default 가 실행된다.		// 구현하면 default  가 사라진다
// 갱체 생성시 자동 호출된다.
// 객체 초기화에 사용된다


public class ConstructorEx {
	
	private String name;
	private int age;
		
	public void setName ( String n) {
		name = n;
	}

	public void setAge(int a ) {
		age = a;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public ConstructorEx() {								// 클래스 명과 동일. 반환이 없다.
		System.out.println("default 생성자");		// 객체 초기화 메서드
	}

	public ConstructorEx ( String n,  int a ) {
		System.out.println("생성자");
		name = n;
		age = a;
	}
	
	public static void main(String[] args) {
		
		ConstructorEx ce = new ConstructorEx(); // ***생성자 호출...*** ( default) -- 객체 초기화     // 객체를 만든뒤에는 쓰레기값이 들어있어서
		
		//ce.setName("홍길동");															// setter 를 통해 initialize 
		
		//ce.setAge( 30);				// 하지만 매번 setter를 통해 initialize 하면 귀찮지 ... 그래서 생성자를 통해 _자동호출_객체초기화 를 한다.
		System.out.println("이름 : " + ce.getName());
		System.out.println("나이 : " + ce.getAge());
				
		
		ConstructorEx ce1 = new ConstructorEx("이순신",20);  // default 생성자 호출이 아니고 필요없다 but 생성자 오버로드 필요
		System.out.println(ce1.getName());
		System.out.println(ce1.getAge());
	}

}


// 생성자는 호출할때 객체초기화!!