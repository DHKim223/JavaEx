package j06;

public class ClassStudy {

	private int kor, eng, mat;
		
	public ClassStudy() {}
	public ClassStudy(int kor, int eng, int mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;		
	}
	
	public int total() {		 
		return (kor+eng+mat);
	}
	
	public double average() {		
		return total() /3.0 ;
	}
	
	public String pass() {
		if (average() >= 70) return "�հ�";
		else return "���հ�";
		
		//return average() >= 70 ? "�հ�" : "���հ�";
	}
	
	public static void main(String[] args) {
		ClassStudy cs = new ClassStudy( 47, 55, 91);
		System.out.println("���� : " + cs.total());
		System.out.println("��� : " + cs.average());
		System.out.println("��� : " + cs.pass());
				
	}
}
