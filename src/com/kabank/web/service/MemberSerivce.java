package com.kabank.web.service;

import com.kabank.web.bean.MemberBean;

public interface MemberSerivce {
	public int createCustomNum();
	public String fideGender(String ssn);
	public int findAge(String ssn);
	public void addMember(MemberBean member);
	public int memberCount();
	public MemberBean[] list();
	
}
