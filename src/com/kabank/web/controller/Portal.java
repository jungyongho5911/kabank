package com.kabank.web.controller;

import java.util.Scanner;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberSerivce;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;
public class Portal {
	private static Scanner scanner;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원수 입력");
		MemberServiceImpl memberService = new MemberServiceImpl(scanner.nextInt());
		MemberBean member = null;
		while (true) {
			System.out.println("[MENU] 0.종료 1.회원가입 .2계좌개설 3.총회원수 4.회원목록");
			switch (scanner.nextInt()) {
			case 0 :
				System.out.println("종료");
				return;
			case 1 :
				member = new MemberBean();
				System.out.println("이름");
				member.setName(scanner.next());
				System.out.println("주민번호");
				member.setSsn(scanner.next());
				member.setCustomNum(memberService.createCustomNum());
				member.setGender(memberService.findGender(member.getSsn()));
				member.setAge(memberService.findAge(member.getSsn()));
				memberService.addMember(member);
				System.out.println("" + "[고객번호]" + member.getCustomNum() + "[주민번호]" + member.getSsn() + "[이름]"
						+ member.getName() + "[성별]" + member.getgender() + "[나이]" + member.getAge());
				break;
			case 2 :
				AccountServiceImpl accountService = new AccountServiceImpl();
				System.out.println("이름");
				accountService.setName(scanner.next());
				accountService.setAccountNum();
				System.out.println(accountService.getName() + "[계좌번호]" + accountService.getAccountNum());
				break;
			case 3 :
				System.out.println("총회원수는" + memberService.memberCount());
				break;
			case 4 :
				MemberBean[]members = memberService.list();
				for(int i=0;i<members.length;i++) {
					System.out.println(members[i].getName());
				}
				break;
			}
		}
	}
}
