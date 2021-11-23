package j05;

// color				색상					멤버변수
// memory			용량

// setColor()		색상을 입력		멤버함수
// getColor()		색상을 출력
// setMemory()	메모리 입력
// getMemory()	메모리 출력

public class Mp3 {		//Mp3 플레이어 설계도
	
	private String color;
	private int memory;
	public void setColor( String c ) {
		if(c.equals("빨간색")||c.equals("파란색")||c.equals("노란색")){				
		color = c;
		}else {
			System.out.println("지원하지 않는 색상입니다");
		}
	}
	public String getColor() {
		return color;
	}
	public void setMemory (int m) {
		if( m == 8 || m==32 || m==64) {
			memory = m;
		}	else {
			System.out.println("지원하지 않는 용량입니다");			
		}
		
	}
	public int getMemory() {
		return memory;
	}	
	
	public static void main(String[] args) {
		Mp3 m3;							// 참조변수(포인터변수)  아직 객체상태가 아님.     
												// heap 영역에 할당받은 인스턴스의 주소를 저장할 변수
		m3 = new Mp3();				// 인스턴스 === 객체		
												// heap 영역에 할당 받은 데이터 저장 공간
		
		m3.setColor("빨간색");
		m3.setMemory(8);
		System.out.println("색상 : " + m3.getColor());
		System.out.println("용량 : " + m3.getMemory());
		
		// 캡슐화 - 데이터의 안정성
		Mp3 m4 = new Mp3();
		m4.setColor("하얀색");
		m4.setMemory(128);
		System.out.println("색상 :"+ m4.getColor());
		System.out.println("용량 : "+ m4.getMemory());
		
		
	}
}
