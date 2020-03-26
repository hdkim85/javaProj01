package ver05;

import java.util.Scanner;

public class PhoneSchoolInfo extends PhoneInfo{
	String major;
	String grade;
	Scanner scan = new Scanner(System.in);
	
	public PhoneSchoolInfo(String name, String phoneNumber, 
			String major, String grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	public void showPhoneInfo() {
	
		super.showPhoneInfo();
		System.out.println("전공 :" + major);
		System.out.println("학년 :" + grade);
	}
}
