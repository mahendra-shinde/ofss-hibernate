package com.mahendra;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mahendra.entities.Product;

public class MySessionFactory {
	
	private static SessionFactory factory = build();

	private static SessionFactory build() {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Product.class);
		return config.buildSessionFactory( new StandardServiceRegistryBuilder().build() );
	}

	
	/// MySessionFactory.getFactory();
	public static SessionFactory getFactory() {
		return factory;
	}

}
