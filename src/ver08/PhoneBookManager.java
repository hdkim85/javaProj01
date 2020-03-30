package ver08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager{

	
	
	int numFriend;
	HashSet<PhoneInfo> phoneInfoArr;
	
	Scanner scan = new Scanner(System.in);
	
	public PhoneBookManager() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/ver08/phonebook.obj"));
			phoneInfoArr = (HashSet<PhoneInfo>) in.readObject();
			in.close();
		} catch (Exception e) {
			phoneInfoArr = new HashSet<PhoneInfo>();
		}
		
	}
	
	public void printMenu() {
		
		
		while(true) {
			
			try {
				
				
				System.out.println("선택하세요...");
				System.out.println("1. 데이터 입력");
				System.out.println("2. 데이터 검색");
				System.out.println("3. 데이터 삭제");
				System.out.println("4. 데이터 출력");
				System.out.println("5. 프로그램 종료");
				
				int key = scan.nextInt() ;
				scan.nextLine();
				System.out.println("선택 :" + key);
				
				if(key>=1 && key<=5) {
					
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
						try {
							ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/ver08/phonebook.obj"));
//							Iterator<PhoneInfo> itr = phoneInfoArr.iterator();
//							while(itr.hasNext()) {
//								System.out.println(itr.toString());
//								out.writeObject(itr.next());
//							}
							out.writeObject(phoneInfoArr);
							out.close();
							System.exit(0);
							
						} catch (IOException e) {
							e.printStackTrace();
							System.out.println("저장되지않았습니다. 종료하시겠습니까?예 :(1) 아니오 :(0)");
							int num = scan.nextInt();
							scan.nextLine();
							if(num==1)
								System.exit(0);
						} 
					}
				}
				else {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
			} catch (MenuSelectException e) {
				System.out.println("숫자의 범위가 잘못되었습니다.");
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				scan.nextLine();
			} catch (NullPointerException e) {
				System.out.println("검색결과가 없습니다.");
			} catch (Exception e) {
				System.out.println("예상치못한 예외가 발생하였습니다.");
				e.printStackTrace();
			}
		}
	}
	
	private void phbookadd(PhoneInfo info) {
//		if(info instanceof PhoneSchoolInfo) {
//			info = (PhoneSchoolInfo) info;
//		}
//		else if(info instanceof PhoneCompanyInfo) {
//			info = (PhoneCompanyInfo) info;
//		}
		
		if(!phoneInfoArr.add(info)) {
			System.out.println("중복된 값이 있습니다.");
			System.out.println("덮어쓰기(1) : 다시입력(0)");
			int num = scan.nextInt();
			scan.nextLine();
			if(num==1) {
				phoneInfoArr.remove(info);
				phoneInfoArr.add(info);	
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
			PhoneInfo info1 = new PhoneInfo(n, p);
			phbookadd(info1);
			break;
		case inputtype.SCHOOL:
			System.out.print("전공: ");
			m = scan.nextLine();
			System.out.print("학년: ");
			g = scan.nextLine();
			PhoneSchoolInfo Info2 = new PhoneSchoolInfo(n, p, m, g);
			phbookadd(Info2);
			break;
		case inputtype.COMPANY:
			System.out.print("회사: ");
			c = scan.nextLine();
			PhoneCompanyInfo Info3 = new PhoneCompanyInfo(n, p, c);
			phbookadd(Info3);
			break;
		}
	}
	
	public void dataSearch() {
		
		System.out.print("검색할 이름을 입력하세요 이름: ");
		String n = scan.nextLine();
		boolean find = false;
		Iterator<PhoneInfo> itr = phoneInfoArr.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(pi.equals(n)) {
				System.out.println("데이터를 찾았습니다. 이름:" + pi.name);
				pi.showPhoneInfo();
				find = true;
			}
		}
		
		if(find==false) {
			NullPointerException ex = new NullPointerException();
			throw ex;
		}
		
	}//end of dataSearch
	
	public void dataDelete() {
		
		System.out.println("삭제할 이름을 입력하시오");
		System.out.println("이름 :");
		String delN = scan.nextLine();
		
		boolean find = false;
		Iterator<PhoneInfo> itr = phoneInfoArr.iterator();
		
		if(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(pi.name.equals(delN)) {
				phoneInfoArr.remove(pi);
				System.out.println(delN + "이(가) 삭제되었습니다.");
				find = true;
			}
			
		}
		
		if(find==false) {
			NullPointerException ex = new NullPointerException();
			throw ex;
			
		}
		
	}//end of dataDelete
	
	public void dataAllShow() {
		
		for (PhoneInfo pi : phoneInfoArr) {
			System.out.println(pi.toString());
		}
	}
}
