package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.UserAccount;
import com.ty.onetomany.dto.Page;

public class TestSaveAccountPage {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		UserAccount account=new UserAccount();
		account.setName("uday");
		account.setEmail("ud@mail.com");
		account.setPassword("ud@1414");
		account.setMobile(995564878l);
		
		List<Page> pages=new ArrayList<Page>();
		Page page1 = new Page();
		page1.setName("Mood");
		page1.setTitle("Travel");
		page1.setDescription("Positive Vibes");
		
		Page page2 = new Page();
		page2.setName("Status");
		page2.setTitle("Food");
		page2.setDescription("Be healthy");
		
		pages.add(page1);
		pages.add(page2);
		
		account.setPages(pages);
		
		entityTransaction.begin();
		entityManager.persist(account);
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityTransaction.commit();
	}
}
