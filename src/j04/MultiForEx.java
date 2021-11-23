package j04;

//다중반복문
public class MultiForEx {
	public static void main(String[] args) {
		for(int i=0; i<3; i+=2) {
			for (int j=0; j<3; j++) {
				System.out.println("i: " + i + "\t" + "j : " +j);
			}
		}
		
	}
}

// 다중 반복문 사용시 가독성 좋은 for 문을 주로 활용한다.