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


public class Demo1 {

	public static void main(String[] args) {
		SessionFactory factory = MySessionFactory.getFactory();

		
		Session session = factory.openSession();
		Customer customer = new Customer();
		customer.setName("Vijay Mallya");
		customer.setPhone("6587876866");
	
		LoginCredential credential= new LoginCredential();
		credential.setEnabled("N");
		credential.setUserName("siddharth");
		credential.setPassword("deepika1234");
		
		customer.setCredentials(credential);
		
		Transaction tn = session.getTransaction();
		try {
			tn.begin();
			Object id = session.save(customer);
			credential.setCustId((Integer) id);
			session.save(credential);
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
		
		factory.close();
	}

	
}
