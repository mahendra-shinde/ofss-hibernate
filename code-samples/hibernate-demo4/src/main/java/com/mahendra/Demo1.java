package com.mahendra;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mahendra.entities.Product;

public class Demo1 {

	public static void main(String[] args) {
		SessionFactory factory = MySessionFactory.getFactory();

		Session session = factory.openSession();
		
		// Transient Phase
		Product p1 = new Product();
		p1.setName("Product Z");
		p1.setPrice(120.5F);
		p1.setProductId(110);
		
		Transaction tn = session.getTransaction();
		try {
			tn.begin();
			// Persistent Phase
			session.save(p1);
			// Try UPDATE on PROPERTY
			p1.setName("Product XYZ");
			p1.setPrice(12000F);
			tn.commit();
		}catch(HibernateException ex) {
			System.out.println(ex.getMessage());
			if(tn!=null)
				tn.rollback();
		}
		//End all primary cache & close the session
		session.close();
		// Now Object is IN Detached Phase
		p1.setPrice(100000F);
		// Open new session		
		session = factory.openSession();
		Product p2 = session.find(Product.class, 110);
		System.out.println("Name: "+p2.getName()+" price: "+p2.getPrice());
		session.close();
		
		factory.close();
	}

}
