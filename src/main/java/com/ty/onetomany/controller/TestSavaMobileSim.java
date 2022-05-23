package com.ty.onetomany.controller;
import com.ty.onetomany.dto.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavaMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile=new Mobile();
		mobile.setName("Mi");
		mobile.setCost(10000);
		
		List<Sim> sims=new ArrayList<Sim>();
		
		Sim sim1=new Sim();
		sim1.setProvider("BSNL");
		sim1.setType("3G");
		
		Sim sim2=new Sim();
		sim2.setProvider("VI");
		sim2.setType("4G");
		
		sims.add(sim1);
		sims.add(sim2);
		
		mobile.setSims(sims);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityTransaction.commit();
	}
}
