package j02;

public class VariableStudy {
	public static void main(String[] args) {
		int kor = 81, eng =75, mat=91;
		
		//���� : 81��
		//���� : 75��
		//���� : 91��
		//���� : ___��
		//��� : ___._��
		
		int total = kor + eng + mat;
		
		//double avg = (double)total / 3;
		//double avg = total / 3.0;
		double avg = total / (double)3;
		
		System.out.println("���� :"+ "\t" + kor +"��");
		System.out.println("���� :" + "\t" + eng +"��");
		System.out.println("���� :" + "\t"  + mat +"��");
		System.out.println("���� :" + "\t"  + total +"��");
		System.out.println("���� :" + "\t"  + avg +"��");
		
		System.out.printf("��� : " + "\t"+ "%.2f��" , avg);  // ��ȯ���� %d , %f, %c, %s
		// ���� �ڵ� �ߺ��ؼ� ���� �ʴ°��� ����
		// ���α׷��� �����ϱ� ����!!!
		// ���� ������!!!
	}
}
