package ver05;

import java.util.Scanner;

public class PhoneBookManager {
	
	int numFriend;
	PhoneInfo[] phoneInfoArr;
	Scanner scan = new Scanner(System.in);
	
	public PhoneBookManager() {
		phoneInfoArr = new PhoneInfo[100]; 
		numFriend=0;
	}
	
	public void printMenu() {
		
		while(true) {
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 데이터 출력");
			System.out.println("5. 프로그램 종료");
			
			int key = scan.nextInt() ;
			scan.nextLine();
			System.out.println("선택 :" + key);
			
			switch (key) {
			case menu.INPUT:
				System.out.println("1.일반, 2.동창, 3.회사");
				int choice = scan.nextInt();
				scan.nextLine();
				dataInput(choice);			
				break;
			case menu.SEARCH:
				dataSearch();
				break;
			case menu.DELETE:
				dataDelete();
				break;
			case menu.SHOW:
				dataAllShow();
				break;
			case menu.EXIT:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}
	
	public void dataInput(int choice) {
//		-저장 : 이름, 전화번호, 생년월일 정보를 대상으로 저장의 과정을 진행한다.
		String n, p, m, g, c;
		
		System.out.print("이름 : ");
		n =scan.nextLine();
		System.out.print("전화번호 : ");
		p =scan.nextLine();
		
		switch (choice) {
		case inputtype.GENERAL:
			PhoneInfo phoneinfo = new PhoneInfo(n, p);
			phoneInfoArr[numFriend++] = phoneinfo;			
			
			break;
		case inputtype.SCHOOL:
			System.out.print("전공: ");
			m = scan.nextLine();
			System.out.print("학년: ");
			g = scan.nextLine();
			PhoneSchoolInfo phoneSchoolInfo = new PhoneSchoolInfo(n, p, m, g);
			phoneInfoArr[numFriend++] = phoneSchoolInfo;
			break;
		case inputtype.COMPANY:
			System.out.println("회사: ");
			c = scan.nextLine();
			PhoneCompanyInfo phoneCompanyInfo = new PhoneCompanyInfo(n, p, c);
			phoneInfoArr[numFriend++] = phoneCompanyInfo;
			break;
		}
	}
	
	public void dataSearch() {
		
		System.out.print("검색할 이름을 입력하세요 이름: ");
		String n = scan.nextLine();
		
		for(int i = 0; i<numFriend;i++) {
//			System.out.println(phoneInfoArr[i].name);
			if(phoneInfoArr[i].name.equals(n)) {
				System.out.println("데이터를 찾았습니다. 이름 :" + phoneInfoArr[i].name);
				phoneInfoArr[i].showPhoneInfo();
			}
		}
		
	}//end of dataSearch
	
	public void dataDelete() {
		
		System.out.println("삭제할 이름을 입력하시오");
		System.out.println("이름 :");
		String n = scan.nextLine();
		
		for(int i= 0; i<numFriend; i++) {
			if(phoneInfoArr[i].name.equals(n)) {
				for(int j = i; j<numFriend-1;j++) {
					phoneInfoArr[j] = phoneInfoArr[j+1];
				}
				numFriend--;
			}
		}
		
	}//end of dataDelete
	
	public void dataAllShow() {
		
		for (int i = 0; i<numFriend ; i++) {
			phoneInfoArr[i].showPhoneInfo();
			
		}
		
	}
	
	
	
	
}
