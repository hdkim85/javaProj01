package ver07;

import java.util.Scanner;

public class PhoneCompanyInfo extends PhoneInfo{
	
	String company;

	public PhoneCompanyInfo(String name, 
			String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사명 :" + company);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n회사: " + company;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo cmpPhone = (PhoneInfo) obj;
		Scanner scan = new Scanner(System.in);
		
		if(cmpPhone.name.equals(this.name)) {
			System.out.println("중복된 이름이 있습니다.");
			System.out.println("덮어씌우려면 (1), 다시 입력하시려면 (0) 을 입력하세요.");
			int num = scan.nextInt();
			scan.nextLine();
			if(num==1) {
				
				cmpPhone.name = this.name;
				cmpPhone.phoneNumber = this.phoneNumber;
				
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
}
