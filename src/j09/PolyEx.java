package j09;

// 다형성 - 들어가는 데는 하난데 나오는 데는 여러 개

abstract class Design{
	int a=5, b=10;					//밑변(반지름) / 높이
	double area;	
	public abstract void calc();
	public abstract void disp();	
}

class Rect extends Design {
	public void calc() {
		area = a*b;
	}
	
	public void disp() {
		System.out.println("Rect area : " + area);
	}
}

class Tri extends Design {
	public void calc() {
		area = a*b / 2.0;
	}
	
	public void disp() {
		System.out.println("Tri area : " + area);
	}
}

class Circle extends Design{
	public void calc() {
		area = a*a*Math.PI;
	}
	
	public void disp() {
		System.out.println("Circle area : " + area);
	}
}

class Radder extends Design{
	private int c = 10; // 윗변
	public void calc() {
		area = (a+c)*b /2.0;
	}
	public void disp() {
		System.out.println("Radder area : " + area);
	}
}


public class PolyEx {
		
	public static void main(String[] args) {
		// 다형성.... 부모를 호출에 원하는 자식 클래스/메소드 실행.... 개선된반복문 돌리면 모든 자식클래스메소드 호출가능
		// 다형성을 고려해 짜야 코드가 안길어진다.
		Design de[] = { new Rect() , new Tri() , new Circle() , new Radder()};	//부모클래스형으로 자동 형변환
		for ( Design d : de) {								
			d.calc();				// Design calc () 호출
			d.disp();				// Design disp() 호출
		}
		
		
		
		/*
		Rect r = new Rect();
		r.calc();							// 사각형의 넓이 연산
		r.disp();							// 사각형의 넓이 출력
		
		Tri t = new Tri();
		t.calc();							// 삼각형 넓이 연산
		t.disp();							// 삼각형의 넓이 출력
		
		Circle c = new Circle();
		c.calc();							// 원의 넓이 연산
		c.disp();							// 원의 넓이 출력
		*/
	}	
}
