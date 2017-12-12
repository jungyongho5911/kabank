package com.kabank.web.controller;

import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.xml.bind.util.ValidationEventCollector;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberSerivce;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;
public class Portal {
	private static Scanner scanner;

	public static void main(String[] args) {
		MemberServiceImpl memberService = new MemberServiceImpl();
		MemberBean member = null;
		while (true) {
			switch (JOptionPane.showInputDialog(("[MENU] 0.종료 1.회원가입 .2계좌개설 3."
					+ "총회원수 4.회원목록\n"
					+ "5.로그인 6.id검색 7.이름검색"
					+ "8.비번수정 9.회원탈퇴 10.회원삭제"))) {
			case "0" :
				JOptionPane.showInternalMessageDialog(null, "종료");
				return;
			case "1" :
				String spec = JOptionPane.showInputDialog("이름/주민번호/id/pass");
				String[] dummy = {
						"홍길동/800101-123456/hong/1",
						"김유신/900203-134567/kim/1",
						"김유신/900203-134567/Sin/1",
						"이이/920304-189456/lee/1",
						"유관순/850910-223456/you/1",
						"신사임당/950101-273456/shin/1"
				};
				for(int i=0;i<dummy.length;i++) {
					member = new MemberBean(); //딥카피 새로운 주소를 할당함
					String [] arr = dummy[i].split("/");
					member.setName(arr[0]);
					member.setSsn(arr[1]);
					member.setId(arr[2]);
					member.setPass(arr[3]);
					member.setCustomNum(memberService.createCustomNum());
					member.setGender(memberService.findGender(member.getSsn()));
					member.setAge(memberService.findAge(member.getSsn()));
					memberService.addMember(member);
				}
				break;
			case "2" :
				AccountServiceImpl accountService = new AccountServiceImpl();
				System.out.println("이름");
				accountService.setAccountNum();
				System.out.println(accountService.getName() + "[계좌번호]" + accountService.getAccountNum());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null,"총회원수는"+ memberService.count());
				break;
			case "4" :
				JOptionPane.showMessageDialog(null, 
						memberService.list());
				break;
			case "5" :
				String[] arr = JOptionPane.showInputDialog("ENTER ID / PASS")
								.split("/");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPass(arr[1]);
				JOptionPane.showMessageDialog(null, memberService.login(member));
				break;
			case "6" :
				JOptionPane.showMessageDialog(null, 
						memberService.findById(
								JOptionPane.showInputDialog("ENTER SEARCH ID").toString()));
				break;
			case "7" :
				JOptionPane.showMessageDialog(null, 
						memberService.findByName(
								JOptionPane.showInputDialog("ENTER SERCH NAME").toString()));
				break;
			case "8" :
				member = new MemberBean();
				String[] foo = JOptionPane.showInputDialog("ENTER ID / UPDATE PASS").split("/");
				member.setId(foo[0]);
				member.setPass(foo[1]);
				memberService.updatePass(member);
				break;
			case "9" :
				member = new MemberBean();
				memberService.deleteId(JOptionPane.showInputDialog("ENTER DELETE ID"));
				break;
			case "10" :
				memberService.deleAll();
				System.out.println("전체삭제");
				break;
			}
		}
	}
}
