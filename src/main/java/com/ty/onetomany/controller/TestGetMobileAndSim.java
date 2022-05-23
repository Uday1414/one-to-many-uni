package com.ty.onetomany.controller;
import com.ty.onetomany.dto.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobileAndSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Mobile mobile = entityManager.find(Mobile.class, 5);
		if (mobile != null) {
			List<Sim> sims = mobile.getSims();

			System.out.println("-------------------------------------");
			System.out.println("Mobile name is : " + mobile.getName());
			System.out.println("Mobile cost is : " + mobile.getCost());
			System.out.println("----------------------------------");

			for (Sim sim : sims) {
				System.out.println("Sim id : " + sim.getId());
				System.out.println("Sim provider : " + sim.getProvider());
				System.out.println("Sim type : " + sim.getType());
				System.out.println("********************************");
			}
		} else {
			System.out.println("No sim with given Id");
		}
	}
}
