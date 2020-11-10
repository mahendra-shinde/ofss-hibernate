package com.mahendra.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

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
		q.setMaxResults(100);
		cities = q.getResultList();
		session.close();
		return cities;
	}
	
	public void updateDistrictName(String oldName, String newName) {
		Session session = factory.openSession();
		Transaction tn = session.getTransaction();
		
		try {
			tn.begin();
		Query q = session.createQuery("UPDATE City c SET c.district=:newName  WHERE c.district=:oldName ");
//		q.setParameter("oldName", oldName);
//		q.setParameter("newName", newName);
		q.setString("oldName", oldName);
		q.setString("newName",newName);
		int rows=		q.executeUpdate();
		System.out.println("Records affected! "+rows);
		tn.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			if(tn!=null)
				tn.rollback();
		}
		session.close();
	}
}
