package j06;

public class ThisEx {

	private String tel;
	private String address;
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setAdd(String address) {
		this.address= address;
	}
	
	public String getTel() {
		return tel;									// this 는 생략 가능하다.
	}
	
	public String getAdd() {
		return address;
	}
	
	// 생성자를 직접 구현하면 디폴트 생성자가 사라진다.
	// 디폴트 생성자를 구현해줘야 한다.
	public ThisEx() {} 	
	public ThisEx( String tel, String address) { // 데이터를 넘겨받는 (매개변수)  / 지역변수
		this.tel = tel;												// 멤버변수 = 매개변수
		this.address = address;								// 멤버변수 = 매개변수
	}
	
	
	public static void main(String[] args) {
		ThisEx te = new ThisEx();
		te.setTel("1111-2222");
		te.setAdd("서울");
		System.out.println("Tel : " + te.getTel());
		System.out.println("Add : " + te.getAdd());
		
		ThisEx te1 = new ThisEx("2222-3333", "수원시");
		System.out.println("Tel : " + te1.getTel());
		System.out.println("Add : " + te1.getAdd());
		
	}

} 
