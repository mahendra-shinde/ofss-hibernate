package com.mahendra;

import com.mahendra.daos.AccountDAO;
import com.mahendra.entities.Account;

public class Demo1 {

	public static void main(String[] args) {

		AccountDAO dao = new AccountDAO();
		Account acc = new Account();
		acc.setBalance(12000D);
		acc.setName("Mr XYZ");
		
		acc = dao.create(acc);
		System.out.println("Account created ");
		
		Account acc2 = dao.findByAccNo(1);
		System.out.println("Found: "+acc2.getName());
	}

}
