package j09;
//������ Ȱ��

import java.util.Date;
import java.util.Random;

public class ToStringEx {		//extends Object�� �����Ǿ� �ִ�!!!!
	
	public String toString() {
		return "toString ������";
	}
	
	public static void main(String[] args) {
		ToStringEx ts = new ToStringEx();		
		System.out.println("ts : " + ts);		// Object�� toString()ȣ��							/	/32��Ʈ �ּ�
		System.out.println("ts : " + ts.toString());
		
		Date date = new Date();
		System.out.println("date : " + date);					// Data�� toString() ȣ��
		System.out.println("date : " + date.toString());
		
		String str = new String("���ѹα�");				
		System.out.println("str : " + str);								//String�� toString()ȣ��
		System.out.println("str : " + str.toString());
		
		Random random = new Random();				
		System.out.println("random : " + random );					//�ּ�
		System.out.println("random : " + random.toString() );
		
		//  toString�� ������ �س��� �ֵ��� �ڱ�鲨 ����ǰ�
		//  �����Ǹ� ���Ѿֵ��� object�� toString�� ����ȴ�.

	}
}
