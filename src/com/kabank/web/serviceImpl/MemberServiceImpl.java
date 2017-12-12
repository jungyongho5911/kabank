package com.kabank.web.serviceImpl;

import java.lang.reflect.Member;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.xml.bind.util.ValidationEventCollector;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberSerivce;

public class MemberServiceImpl implements MemberSerivce {
	private Vector<MemberBean> members;
	private int customeNum;
	public MemberServiceImpl() {
		members = new Vector<MemberBean>(10,10);
		customeNum = 1000;
		
	}
	@Override
	public void addMember(MemberBean member) {
		members.add(member);
	}
	@Override
	public  Vector<MemberBean>list(){
		
		return members;
	} 
	@Override
	public int createCustomNum() {
		customeNum++;
		return this.customeNum;
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
	@Override
	public int count() {
		
		return members.size();
	}
	@Override
	public void deleAll() {
		members.clear();
	}
	@Override
	public void delete(String id) {
		String res = "";
		for(int i=0;i<members.size();i++) {
			if(id.equals(members.get(i).getId())) {
				members.removeElementAt(i);
			}
				
			}
				
		}
	@Override
	public String login(MemberBean member) {
		String res = "아디가 존재하지 않습니다.";
		for(int i=0; i<members.size();i++) {
			if(member.getId().equals(members.get(i).getId())) {
				res = (member.getPass().equals(members.get(i).getPass()))?"로그인성공":"비밀번호틀림";
				return res;
			}
		}
		return res;
	}
	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for(int i=0;i<members.size();i++) {
			if(id.equals(members.get(i).getId())) {
				member = members.get(i);
			}
		}
		return member;
	}
	@Override
	public Vector<MemberBean> findByName(String name) {
		Vector<MemberBean> foo = new Vector<>();
		for(int i=0; i<members.size();i++) {
			if(name.equals(members.get(i).getName())) {
				foo.add(members.get(i));
			}
		}
		return foo;
	}
	@Override
	public void deleteId(String id) {
		for(int i=0; i<members.size();i++) {
			if(id.equals(members.get(i).getId())) {
				members.removeElementAt(i);
			}
		}
		
	}
	@Override
	public void updatePass(MemberBean member) {
		findById(member.getId()).setPass(member.getPass());
	}
	
}




