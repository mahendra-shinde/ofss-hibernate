package com.mahendra;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mahendra.entities.Account;
import com.mahendra.entities.Customer;
import com.mahendra.entities.LoginCredential;


public class Demo1 {
	static SessionFactory factory = MySessionFactory.getFactory();
	
	static void prepareData() {
		Session session = factory.openSession();
		Customer customer = new Customer();
		customer.setName("Vijay Mallya");
		customer.setPhone("6587876866");
	
		LoginCredential credential= new LoginCredential();
		credential.setEnabled("N");
		credential.setUserName("siddharth");
		credential.setPassword("deepika1234");
	
		Account acc1 = new Account();
		acc1.setAccNo(10001);
		acc1.setBalance(12000D);
		acc1.setCustomer(customer);
		acc1.setType("Savings");
		
		Account acc2 = new Account();
		acc2.setAccNo(10020);
		acc2.setBalance(120D);
		acc2.setCustomer(customer);
		acc2.setType("Current");
		
		List<Account> accounts = Arrays.asList(acc1,acc2);
		
		customer.setAccounts(accounts);
		customer.setCredentials(credential);
		
		Transaction tn = session.getTransaction();
		try {
			tn.begin();
			Object id = session.save(customer);
			credential.setCustId((Integer) id);
			session.save(credential);
			session.save(acc1);
			session.save(acc2);
			tn.commit();
			System.out.println("Records created successfuly!");
		}catch(Exception ex) {
			ex.printStackTrace();
			if(tn!=null) {
				System.out.println("Exception occured, rolling back!");
				tn.rollback();
			}
		}
		session.close();
		
	}
	
	static void printAllAccounts() {
		Session session = factory.openSession();
		Customer customer = session.find(Customer.class, 1);
		System.out.println("Found customer: "+customer.getName());
		session.close();
	}
	
	public static void main(String[] args) {
		prepareData();
		printAllAccounts();
		factory.close();
	}

	
}
