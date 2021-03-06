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
		return super.equals(obj);
	}
	
	
	
	
}
