package ver08;

import java.io.Serializable;
import java.util.Scanner;

public class PhoneSchoolInfo extends PhoneInfo 
							implements Serializable{
	String major;
	String grade;
	
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
	
	
	@Override
	public String toString() {
		return super.toString()+"\n전공: " + major + "\n학년: " + grade;
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
