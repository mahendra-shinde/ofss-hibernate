package com.mahendra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mahendra.entities.Product;

public class Demo1 {

	public static void main(String[] args) {
		SessionFactory factory = MySessionFactory.getFactory();
		
		Session session = factory.openSession();
		
		Product p1 = session.find(Product.class, 101);
		System.out.println("Product Found: "+p1.getName()+", Rs "+p1.getPrice());
		
		session.close();
		
	}

}
