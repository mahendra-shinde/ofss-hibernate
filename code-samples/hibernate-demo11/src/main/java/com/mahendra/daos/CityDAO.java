package com.mahendra.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.*;

import com.mahendra.MySessionFactory;
import com.mahendra.entities.City;

public class CityDAO {
	
	private SessionFactory factory = MySessionFactory.getFactory();
	
	public List<City> fromCountry(String code){
		List<City> cities = null;
		Session session = factory.openSession();
		// HQL is CaseSensitive for Entity and property names
		// HQL is using POSITIONAL PARAMETER
		TypedQuery<City> q = session.createQuery("select c from City c where c.countryCode=?1",City.class);
		// Setting VALUE for Parameter
		q.setParameter(1, code);
		q.setMaxResults(10);
		cities = q.getResultList();
		
		session.close();
		return cities;
	}
}
