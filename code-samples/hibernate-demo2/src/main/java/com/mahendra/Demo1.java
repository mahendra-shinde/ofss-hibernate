package com.mahendra;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mahendra.entities.Product;

public class Demo1 {

	public static void main(String[] args) {
		SessionFactory factory = MySessionFactory.getFactory();

		Session session = factory.openSession();

		List<Product> products = null;

		// Using Managed Query ( SQL-Like query from Hibernate - HQL)
		Query<Product> query = session.createQuery("select p from Product p");
		products = query.getResultList();

		System.out.println("Records found: " + products.size());
		for (Product p : products) {
			System.out.println("Product " + p.getName() + ", price: " + p.getPrice());
		}
		session.close();

	}

}
