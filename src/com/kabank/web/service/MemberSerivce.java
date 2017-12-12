package com.kabank.web.service;

import java.util.Vector;

import com.kabank.web.bean.MemberBean;

public interface MemberSerivce {
	public int createCustomNum();
	public String fideGender(String ssn);
	public int findAge(String ssn);
	public void addMember(MemberBean member);
	public int count();
	public Vector<MemberBean> list();
	public void deleAll();
	public void delete(String id);
	public String login(MemberBean member);
	public MemberBean findById(String id);
	public Vector<MemberBean> findByName(String name);
	public void deleteId(String id);
	public void updatePass(MemberBean member);
}
