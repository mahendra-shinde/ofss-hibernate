package com.mahendra;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mahendra.entities.Account;

public class Demo1 {

	public static void main(String[] args) {
		SessionFactory factory = MySessionFactory.getFactory();

		Account ac1 = new Account("Bhishma", convert("21-07-1987"), 12000);
		Account ac2 = new Account("Arjun", convert("20-05-1999"), 1200);
		Account ac3 = new Account("Suyodhan", convert("11-03-1998"), 154000);
		
		Session session = factory.openSession();
		
		
		try {
			session.beginTransaction();
		Serializable id1 = session.save(ac1);
		System.out.println("Saved as "+id1);
		
		Serializable id2 = session.save(ac2);
		System.out.println("Saved as "+id2);
		
		Serializable id3 = session.save(ac3);
		session.getTransaction().commit();
		
		System.out.println("Saved as "+id3);
		}catch(Exception ex) {
			if(session.getTransaction()!=null)
				session.getTransaction().rollback();
		}
		
		List<Account> accounts = session.createQuery("select a from Account a").getResultList();
		System.out.println("All the accounts: ");
		for(Account a : accounts) {
			System.out.println(a.getName()+" "+a.getAccNo());
		}
		session.close();
		
		factory.close();
	}

	
	static Date convert(String str) {
		SimpleDateFormat fm = new SimpleDateFormat("dd-mm-yyyy");
		try {
			return fm.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
