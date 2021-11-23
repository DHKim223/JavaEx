package j04;

/*
	가위바위보와 금액보기 메뉴를 출력한다
	가위바위보를 선택할 경우 배팅 금액을 입력받고
	컴퓨터와 경쟁해서 이기면 배팅 금액만큼 더하고
	지면 배팅 금액만큼 총액에서 뺀다.
	총액이 마이너스가 되면 게임이 종료된다.
 
 	<< 사용자가 진 경우의 예 >>
	1.주먹
	2.가위
	3.보자기
	4.현재 금액보기.
	0.프로그램 종료.
	메뉴선택 : 4
	현재금액 : 1000원
	더 할거냐?(y/n) : y
	
	1.주먹
	2.가위
	3.보자기
	4.현재 금액보기.
	0.프로그램 종료.
	메뉴선택 : 1
	베팅금액 : 10000
	         user : 주먹     computer : 보자기
	졌습니다. 현재 금액 : -9000원
	
	더 할거냐?(y/n) : 10000
	배팅금액이 없읍니다.
	프로그램을 종료 합니다.
	
	
	<< 사용자가 이긴 경우의 예 >>	
	1.주먹
	2.가위
	3.보자기
	4.현재 금액보기.
	0.프로그램 종료.
	메뉴선택 : 1
	베팅금액 : 10000
	         user : 주먹     computer : 주먹
	비겼습니다.1000원
	
	더 할거냐?(y/n) : y
	
	1.주먹
	2.가위
	3.보자기
	4.현재 금액보기.
	0.프로그램 종료.
	메뉴선택 : 2
	베팅금액 : 10000
	         user : 가위     computer : 보자기
	이겼습니다. 현재금액 : 11000원
	
	더 할거냐?(y/n) :
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

class WhileStudy2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int seed = 10000;		
		int result=0;  // 1 이겼다 2 졌다 3 비겼다 
		int batting=0;
		char rep;
		
		do {
		System.out.println("1: 가위");
		System.out.println("2: 바위");
		System.out.println("3: 보");
		System.out.println("4. 현재 금액보기");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택하세요 : ");
		
		int user = Integer.parseInt(br.readLine());
		int com =(int)(Math.random()*3)+1;
		
		if(user == 1 || user==2|| user==3) {
			do {
			System.out.print("배팅금액 :");
			batting = Integer.parseInt(br.readLine());
			if(seed < batting)System.out.println("시드보다 적은 금액을 배팅하세요");
			}while(batting > seed);
		}
		
		switch(user) {
		case 1: 		
		if(com==1) { //
		System.out.println("user : 가위\tcomputer : 가위" );
		result = 3;
		}else if(com==2) {
		System.out.println("user : 가위\tcomputer : 바위" );
		result = 2;
		}else {
		System.out.println("user : 가위\tcomputer : 보" );
		result = 1;
		} break;
		
		case 2: if(com==1) { //
		System.out.println("user : 바위\tcomputer : 가위" );
		result = 1;
		}else if(com==2) {
		System.out.println("user : 바위\tcomputer : 바위" );
		result = 3;
		}else {
		System.out.println("user : 바위\tcomputer : 보" );
		result = 2;
		} break;
		
		case 3: if(com==1) { //
		System.out.println("user : 보\tcomputer : 가위" );
		result = 2;
		}else if(com==2) {
		System.out.println("user : 보\tcomputer : 바위" );
		result = 1;
		}else {
		System.out.println("user : 보\tcomputer : 보" );
		result = 3;
		} break;
		
		case 4:{
			result = 4; 
		} break;
		
		case 0: {
			result = 5;
		} break;
		default: System.out.print("잘못된 입력으로 ");
		}
		
		if(result == 1) {
			seed += batting;
			System.out.println("이겼습니다!\t현재잔액 : "+ seed + "원");		// 현재금액 표시
		}
		else if (result == 2) {
			seed -= batting;
			System.out.println("졌습니다!\t현재잔액 : "+ seed + "원");
		}
		else if (result ==3) {
			System.out.println("비겼습니다!\t현재잔액 : "+ seed + "원");
		}
		else if (result ==4)	System.out.println("현재잔액 : " + seed + "원");
		else break;	

		if(seed <=0) {
			System.out.println("파산으로 게임 진행 불가"); break;
		}
		
		System.out.print("더 할래요? (Y/y): ");
		
		rep = (char)System.in.read();						
		System.in.read();
		System.in.read();						
		
		} while(rep=='y' || rep=='Y');
		
		System.out.println("게임 종료");
	}
}
