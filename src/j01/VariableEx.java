package j01;
	
/*
  변수	변하는값 / 메모리할당
  
  자료형	키워드	크기		기본값
  논리형	boolean	1bit	false
  정수형	byte	1byte	0 				/// 8 bit = 1 byte
  		short	2byte	0
  		int		4byte	0
  		long	8byte	0
  실수형	float	4byte	0.0
  		double	8byte	0.9
  문자형	char	2byte	\u0000
  문자열			두글자이상 null

  문자 'A'
  문자열 "ABC"
 
  */



public class VariableEx {
	public static void main(String[] args) {
		boolean a = false;
		System.out.println("booblean : " + a);
		
		
		
		float d = 3.5f; // float d = 3.5; 는 4byte 에 8byte 을 넣기에 에러! // 3.5f / 3.5F 를 넣으면 됨....
		System.out.println("float : " + d );

		//short >> int  / int 가 정수의 기본값
		// 실수의 기본은 double
		
		double e = 3.5; // 귀찮으니 double로 잡고 쓴다.
		System.out.println("double : " + e);
		
		char f = 'f';
		System.out.println("char : "+ f);
		
		
		// sysout + Ctrl + space
		String h = "ABC";
		System.out.println("String : " + h);
		
		String i = "수업 너무재밌고~";
		System.out.println("\"String\" : " + i);
		
		
		
	}
}
