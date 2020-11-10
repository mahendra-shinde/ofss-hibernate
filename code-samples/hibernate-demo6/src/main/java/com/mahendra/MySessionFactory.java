package com.mahendra;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mahendra.entities.Customer;
import com.mahendra.entities.LoginCredential;


public class MySessionFactory {

	// Method is Auto-Invoked when is Loaded
	private static SessionFactory factory = build();

	private MySessionFactory() {
	}

	private static SessionFactory build() {
		Configuration config = new Configuration();
		// For properties file with non-default custom name 'db2.properties'
		// config.configure("db2.properties");
		config.addAnnotatedClass(Customer.class);
		config.addAnnotatedClass(LoginCredential.class);
		
		return config.buildSessionFactory(new StandardServiceRegistryBuilder().build());
	}

	/// MySessionFactory.getFactory();
	public static SessionFactory getFactory() {
		return factory;
	}

}
