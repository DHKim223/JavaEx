package j08;

// 상속 Inheritance
// 부모 멤버는 내 꺼!!!
// 단 생성자는 제외

// 자바는 다중상속이 불가능
// 대신에 인터페이스를 활용하면 다중상속을 사용할 순 있다.

// CellPhone 				전화기능
//									String tel;

//	CaPhone					전화기능 + 카메라기능
//									int pixel;

//	Mp3Phone				전화기능 + 카메라기능 + mp3기능
//									int chord;

// 원래 클래스의 접근 제한은 public
//	단 하나의 파일에 클래스를 여러개 구현하는 경우 main 클래스만 public.. 나머지는 default


class CellPhone {
	// 생성자
	private String tel;				// private 에서 protected 로 바꿔주면 아래서 사용가능 하지만....protected는 사용안함.
	
	// CellPhone Default 생성자
	public CellPhone() {
		System.out.println("부모 디폴트 생성자");     // default가 호출되면 아무것도 안함.
	}
	
	public CellPhone(String tel) {
		System.out.println("부모생성자1");					// 부모쪽으로 data 를 던져줘야 하는 " tel " 이 들어간...
		this.tel = tel;
	}
	
	// Getter
	public String getTel() {
		return tel;
	}	
}	

// 상속받을때  아들class  extends 엄마class

class CaPhone extends CellPhone{					// 카메라 기능 + 전화기능 ..... 전화기능 구현 X ...... 상속받아 쓰자
	// 생성자
	private int pixel;
	public CaPhone(String tel , int pixel) {
		//this.tel = tel;												// tel 이 private  // 하지만 여기서 tel 을 초기화 하는건 불가능
		super(tel); 				//super가 제일 먼저.. // 부모쪽으로 데이터 던지기만    // super() 는 부모 생성자를 호출. 
		this.pixel = pixel;
		System.out.println("부모생성자2");
	}
	
	// Getter
	public int getPixel() {
		return pixel;
	}
}

class Mp3p extends CaPhone{		// MP3 기능 + 전화기능 + 카메라 기능
	// 생성자
	private int chord;
	public Mp3p(String tel, int pixel, int chord) {
		
		super(tel, pixel);
		this.chord = chord;
	}
	// Getter
	public int getChord() {
		return chord;
	}
}

public class InherEx {
	public static void main(String[] args) {				
//		CellPhone cp = new CellPhone("1111-2222");
//		System.out.println("전화번호 : " + cp.getTel());
		
		//CaPhone ca = new CaPhone(4000);					// tel 과 pixel 두 멤버 다 가지고 있다.
		
//		CaPhone ca = new CaPhone("1111-2222",4000);				// 이걸 받아줄 생성자가 없어서 에러	
//		System.out.println("전화번호 : " + ca.getTel());
//		System.out.println("화소 : " + ca.getPixel());
		
		Mp3p mp = new Mp3p("1111-2222", 4000, 64 );
		System.out.println("전화번호 : " + mp.getTel());
		System.out.println("픽셀 : " + mp.getPixel());
		System.out.println("화음 : " + mp.getChord());

		
		
	}
}

//생성자의 역할은 객체 초기화..... 자식클래스에서 객체는 자식이 ,,, 부모클래스에서 객체는 부보가...
