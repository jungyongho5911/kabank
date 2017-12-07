package com.kabank.web.serviceImpl;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberSerivce;

public class MemberServiceImpl implements MemberSerivce {
	private MemberBean[]members;
	private int memberCount;
	
	public MemberServiceImpl(int membercount) {
		this.memberCount = 0;
		members = new MemberBean[membercount];
	}
	@Override
	public void addMember(MemberBean member) {
		members[memberCount] = member;
		memberCount++;
	}
	@Override
	public int memberCount() {
		return this.memberCount;
	}
	@Override
	public  MemberBean[]list(){
		return members;
	} 
	@Override
	public int createCustomNum() {
		int foo = 0;
		return foo;
	}
	public String findGender(String ssn) {
		String foo = "";
		char ch = ssn.charAt(7);
		if (ch == '0' || ch == '7' || ch == '8' || ch == '9') {
			foo = "다시입력";
		} else {
			switch (ch) {
			case '1':
				foo = "남자";
				break;
			case '3':
				foo = "남자";
				break;
			case '2':
				foo = "여자";
				break;
			case '4':
				foo = "여자";
				break;
			case '5':
				foo = "외국인";
				break;
			case '6':
				foo = "외국인";
				break;
			}

		}
		return foo;
	}
	@Override
	public int findAge(String ssn) {
		int year = 2017;
		int foo = 0;
		int foo1 = Integer.parseInt(ssn.charAt(0)+""+ssn.charAt(1));
		int foo2 = Integer.parseInt(ssn.charAt(7)+"");
		if(3 == foo2) {
			foo = year - 1999 - foo1;
		}else if(4 == foo2){
			foo = year - 1999 - foo1;
		}else {
			foo = year - 1899 - foo1;
		}
		return foo;
	}
	@Override
	public String fideGender(String ssn) {
		
		return null;
	}

}


