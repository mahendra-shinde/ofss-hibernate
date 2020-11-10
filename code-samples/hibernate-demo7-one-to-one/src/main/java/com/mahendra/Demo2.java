package com.mahendra;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mahendra.entities.Customer;
import com.mahendra.entities.LoginCredential;


public class Demo2 {

	public static void main(String[] args) {
		SessionFactory factory = MySessionFactory.getFactory();

		Session session = factory.openSession();
		
		Customer cust = session.get(Customer.class, 1);
//		LoginCredential cred = cust.getCredentials();
//		
//		Customer cust2 = cred.getCustomer();
//		
//		System.out.println(cust==cust2);
//		
		session.close();
		
		factory.close();
	}

	
}
