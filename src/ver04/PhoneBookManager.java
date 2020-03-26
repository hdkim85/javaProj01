package ver04;

import java.util.Scanner;

/*
 객체배열을 이용해서, 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경하시오.
그리고 다음과 같은 기능을 추가로 삽입한다.
-저장 : 이름, 전화번호, 생년월일 정보를 대상으로 저장의 과정을 진행한다.
-검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 출력한다.
-삭제 : 이름을 기준으로 데이터를 찾아서 삭제의 과정을 진행한다. 단 배열의 중간에 저장된 데이터를 삭제할경우 해당 요소의 뒤에 저장된 요소들을 한칸씩 앞으로 이동시키는 형태로 삭제를 진행한다.
[1,2,3,4,5] 좌측배열에서 인덱스 3을 지웠다면 [1,2,4,5] 처럼 되어야 한다.
 
끝으로 저장, 검색, 삭제의 기능을 담당하는 PhoneBookManager클래스를 정의해서 프로그램을 완성하자.

멤버메소드명 
메뉴출력 : printMenu()
입력 : dataInput()
검색 : dataSearch()
삭제 : dataDelete()
주소록전체출력 : dataAllShow()

 */
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
			case 1:
				System.out.println("1.일반, 2.동창, 3.회사");
				int choice = scan.nextInt();
				scan.nextLine();
				dataInput(choice);			
				break;
			case 2:
				dataSearch();
				break;
			case 3:
				dataDelete();
				break;
			case 4:
				dataAllShow();
				break;
			case 5:
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
		
		if(choice ==1) {
			PhoneInfo phoneinfo = new PhoneInfo(n, p);
			phoneInfoArr[numFriend++] = phoneinfo;			
		}
		else if(choice ==2) {
			System.out.print("전공: ");
			m = scan.nextLine();
			System.out.print("학년: ");
			g = scan.nextLine();
			PhoneSchoolInfo phoneSchoolInfo = new PhoneSchoolInfo(n, p, m, g);
			phoneInfoArr[numFriend++] = phoneSchoolInfo;
		}
		else if(choice ==3) {
			System.out.println("회사: ");
			c = scan.nextLine();
			PhoneCompanyInfo phoneCompanyInfo = new PhoneCompanyInfo(n, p, c);
			phoneInfoArr[numFriend++] = phoneCompanyInfo;	
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
