package ver07;

import java.util.Scanner;

public class PhoneInfo {
	String name;
	String phoneNumber;

	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {

		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
	
	@Override
	public String toString() {
		return "이름: " + name +
				"\n전화번호: " + phoneNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		PhoneInfo cmpPhone = (PhoneInfo) obj;
		if(cmpPhone.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
}
