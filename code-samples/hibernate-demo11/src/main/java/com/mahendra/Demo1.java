package com.mahendra;

import java.util.List;

import com.mahendra.daos.CityDAO;
import com.mahendra.entities.City;

public class Demo1 {

	public static void main(String[] args) {

		CityDAO dao = new CityDAO();
		List<City> cities = dao.fromCountry("IND");
		System.out.println("Cities from India:");
		for(City c : cities) {
			System.out.println(c.getName()+" "+c.getDistrict()+" "+c.getInfo());
		}
		
	}

}
