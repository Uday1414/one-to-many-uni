package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Page;
import com.ty.onetomany.dto.UserAccount;

public class TestDeleteAccountPage {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		UserAccount userAccount = entityManager.find(UserAccount.class, 1);
		if (userAccount != null) {
			List<Page> pages = userAccount.getPages();

			entityTransaction.begin();
			for (Page page : pages) {
				entityManager.remove(page);
			}
			entityManager.remove(userAccount);
			entityTransaction.commit();
		} else {
			System.out.println("No Account found with given user id");
		}

	}
}
