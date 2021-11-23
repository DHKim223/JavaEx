package j10;

//내부클래스			Inner Class
//Member 			멤버 변수나 멤버 메서드들과 같이 클래스가 정의
//외부 클래스의 멤버를 참조할 수 있다.
//static 변수를 가질 수 없다. 
//객체를 생성하기 위해서는 외부 클래스의 객체를 먼저 생성해야 한다. 

//Local				특정한 메서드 내에 클래스가 정의된 경우
//간단한 기능을 갖는 임시 클래스로 사용
//메소드 내부에서 선언되고 메소드 안에서만 객체화 할 수 있다.
//메소드 외부에서는 사용할 수 없습니다.
//접근수정자를 사용할 수 없다. 

//Static				클래스가 static으로 선언된 경우
//static변수를 가지고 있다면 클래스는 static으로 선언해야 한다. 
//외부 클래스의 static 멤버만 참조할 수 있다.

//Anonymous			참조할 수 있는 이름이 없는 경우
//한 번만 사용하고 버려야 할 객체의 경우

/*
 	class Outer			-		init a
 								-		disp()				-			class InnerLocal			- 		int c
 																												-		disp()
 								-		class InnerMember											-		int b	
 																												-		disp()
 								-		static	class InnerStatci									-		intd
 								
 	abstract	class InnerAnony	-	int e						추상클래스 / 호출할 때 내부클래스로 호출
 												-	disp()
 */

class Outer {									// 외부클래스
	private  int a = 10;						// 멤버변수
	public void disp() {						// 멤버메서드
		System.out.println("Outer a : " + a);
		// System.out.println("InnerMember b : " + b); 	내부클래스 멤버는 외부에서 사용불가... 지역변수 개념
		
		///////////// Local Inner Class	///////////
		// Outer class 안의 disp() 메서드 안에 Innerlocal 클래스
		class InnerLocal{
			private int c = 30;
			public void disp() {
				System.out.println("InnerLocal : " + a);
				System.out.println("InnerLocal : " + c);
			}
		}	//class InnerLocal
		InnerLocal il = new InnerLocal();
		il.disp();
		
	}	// disp()
	
	/////// Member Inner Class ////////
	class InnerMember {					//	멤버 내부클래스
		private int b= 20;						
		public void disp() {
			System.out.println("InnerMember a : " + a);  // 외부클래스 멤버를 참조할 수 있다
			System.out.println("InnerMember b : " + b); 
		}
	}// class InnerMember
	
	//////// Static Inenr Class ////////////
	static class InnerStatic{						// 스태틱 내부클래스
		private static int d = 40;					// 내부클래스는 static 변수를 가질 수 없다. 단, 가져야할 경우 클래스를 스태틱으로
		public void disp() {
			//System.out.println("InnerStatic a : " + a); // 클래스가 static으로 바뀌면// static 은 static멤버만 접근 가능.
			System.out.println("InnerStatic d : " + d);
		}
	}// claas InnerStatic
	
} // class Outer


abstract class InnerAnony{			//추상클래스
	int e = 50;
	public abstract void disp();		//추상메서드
	
}

public class InnerEx {
	public static void main(String[] args) {
		// Local Inner Class
		Outer out = new Outer(); // 클래스 호출... 객체생성\
		out.disp(); // 메서드호출...
		
		// Member Inner Class
		Outer.InnerMember im = out.new InnerMember();
		// 외부클래스 객체가 없다면  Outer.InnerMember im = new Outer().new InnerMember();
		im.disp();
		
		//Static Inner class
		Outer.InnerStatic is = new Outer.InnerStatic();
		is.disp();
		
		// Anonymous Inner Class
		// InnerAnony ia = new InnerAnony();			//추상클래스는 객체생성 불가!!!!! (미완성이기 때문에)
		InnerAnony ia = new InnerAnony() {// 미완성 부분 구현 하면 사용가능// 참조변수 만들기는 가능.
			// 익명 내부클래스
			public void disp() {
				System.out.println("InnerAnony e : " + e);
			}
		};
		ia.disp();
		
		// 참주변수 = 객체생성은 다시 쓸려고 참조변수를 만드는거라 한번쓰고 버릴꺼면 필요없다.
		
		// 익명내부클래스의 주된 사용방법....
		new InnerAnony() {
			public void disp() {
				System.out.println("InnerAnony e : " + e);
			}
		}.disp();
		
	}
		
		
}

