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
		
		Product p1 = new Product();
		p1.setName("Product Z");
		p1.setPrice(120.5F);
		p1.setProductId(106);
		
		Transaction tn = session.getTransaction();
		try {
			tn.begin();

			session.save(p1);
			tn.commit();
		}catch(HibernateException ex) {
			System.out.println(ex.getMessage());
			if(tn!=null)
				tn.rollback();
		}
		//Avoid getting STALE data !
		session.refresh(p1);
		Product p2 = session.find(Product.class, 106);
		System.out.println("Name: "+p2.getName());
		session.close();

		factory.close();
	}

}
