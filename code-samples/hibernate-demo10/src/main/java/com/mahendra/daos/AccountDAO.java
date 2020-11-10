package com.mahendra.daos;

import java.io.Serializable;

import org.hibernate.*;

import com.mahendra.MySessionFactory;
import com.mahendra.entities.Account;

public class AccountDAO {

	private SessionFactory factory;
	
	public AccountDAO() {
		factory = MySessionFactory.getFactory();
	}
	
	//Pass Transient 'employee' object without persistent identity (PK)
	//Returns detached object
	public Account create(Account acc) {
		Session session = factory.openSession();
		Transaction tn = session.getTransaction();
		try {
			tn.begin();
			Serializable id = session.save(acc);
			System.out.println("Account created: "+id);
			tn.commit();
		}catch(Exception ex) {
			if(tn!=null)
				tn.rollback();
			ex.printStackTrace();
		}
		session.save(acc);
		session.close();
		return acc;
	}
	
	public Account findByAccNo(int accNo) {
		Session session = factory.openSession();
		Account acc = session.find(Account.class, accNo);
		session.close();
		return acc;
	}
	
	public Account update(Account acc) {
		Session session = factory.openSession();
		Transaction tn = session.getTransaction();
		try {
			tn.begin();
			session.merge(acc);
			System.out.println("Account updated: "+acc.getAccNo());
			tn.commit();
		}catch(Exception ex) {
			if(tn!=null)
				tn.rollback();
			ex.printStackTrace();
		}
		session.save(acc);
		session.close();
		return acc;
	}
	
	public Account delete(Account acc) {
		Session session = factory.openSession();
		Transaction tn = session.getTransaction();
		try {
			tn.begin();
			session.delete(acc);
			System.out.println("Acount deleted!");
			tn.commit();
		}catch(Exception ex) {
			if(tn!=null)
				tn.rollback();
			ex.printStackTrace();
		}
		session.save(acc);
		session.close();
		return acc;
	}
}
