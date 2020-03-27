package ver09;

import java.sql.SQLException;
import java.util.Scanner;

public class PhoneBookManager extends DBConnectImpl {
	
//	int numFriend;
//	PhoneInfo[] phoneInfoArr;
	Scanner scan = new Scanner(System.in);
	
	public PhoneBookManager(int num) {
		super("kosmo", "1234");
//		phoneInfoArr = new PhoneInfo[num]; 
//		numFriend=0;
		
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
				dataInput();			
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
				close();
				System.exit(0);
			}
		}
	}
	
	
	public void dataInput() {
//		-저장 : 이름, 전화번호, 생년월일 정보를 대상으로 저장의 과정을 진행한다.
		
		try {
			String query = "INSERT INTO phonebook_tb VALUES(seq_phonebook.nextval, ?, ?, ?)";
			
			String n, p, b;
			System.out.print("이름 : ");
			n =scan.nextLine();
			System.out.print("전화번호 : ");
			p =scan.nextLine();
			System.out.print("생일 : ");
			b =scan.nextLine();
			
			if(b.isEmpty()) {
				b = null;
			}
			
//			PhoneInfo phoneinfo = new PhoneInfo(n, p, b);
//			phoneInfoArr[numFriend++] = phoneinfo;
			ps = conn.prepareStatement(query);
			
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, b);
			
			int affected = ps.executeUpdate();
			
			System.out.println(affected + "행이 입력되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
	
	public void dataSearch() {
		
		
		try {
			
			st = conn.createStatement();
			System.out.print("검색할 이름을 입력하세요 이름: ");
			String n = scan.next();
			
			
			String query = "SELECT id, name, phoneNum, birth FROM phonebook_tb WHERE name like '%" + n + "%'";			
			result = st.executeQuery(query);
			System.out.printf("%-10s | %-20s | %-20s | %-20s\n",
					"id", "name", "phonenumber", "birth");
			System.out.println("=================================================================================");
			while(result.next()) {
				
				String id = result.getString("id");
				String name = result.getString("name");
				String phoneNum = result.getString("phoneNum");
				String birth = result.getString("birth");
//				System.out.println(id + name + phoneNum + birth);
				
				
				System.out.printf("%-10s | %-20s | %-20s | %-20s\n", 
						id, name, phoneNum, birth);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}//end of dataSearch
	
	public void dataDelete() {
		
		try {
			
			System.out.println("삭제할 이름을 입력하시오");
			System.out.println("이름 :");
			String n = scan.nextLine();
			String query = "{call STORED_DEL(?)}";
			cs = conn.prepareCall(query);
			cs.setString(1, n);
			cs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
//		for(int i= 0; i<numFriend; i++) {
//			if(phoneInfoArr[i].name.equals(n)) {
//				for(int j = i; j<numFriend-1;j++) {
//					phoneInfoArr[j] = phoneInfoArr[j+1];
//				}
//			}
//		}
	}//end of dataDelete
	
	public void dataAllShow() {
		
		try {
			st = conn.createStatement();
			
			String query = "SELECT * FROM phonebook_tb";
			result = st.executeQuery(query);
			System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "id", "name", "phoneNum", "birth");
			while(result.next()) {
				
				String id = result.getString("id");
				String name = result.getString("name");
				String phoneNum = result.getString("phoneNum");
				String birth = result.getString("birth");
				System.out.printf("%-10s | %-10s | %-10s | %-10s\n", 
						id, name, phoneNum, birth);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
	}
	
	
	
	
}
