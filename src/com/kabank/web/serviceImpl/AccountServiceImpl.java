package com.kabank.web.serviceImpl;

import java.util.Random;
import java.util.Scanner;

public class AccountServiceImpl {
	private String name;
	private int accountNum;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAccountNum() {
		Random r = new Random();
		boolean flag = true;
		while(flag){
			int temp = r.nextInt(1000000);
			if(100000 < temp) {
				accountNum = temp;
				flag = false;
			}else {
				flag = true;
			}	
	} 
}
	public int getAccountNum() {
		return this.accountNum;
	}
}