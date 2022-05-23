package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Page;
import com.ty.onetomany.dto.UserAccount;

public class TestGetAccountPage {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		UserAccount userAccount = entityManager.find(UserAccount.class, 2);
		if (userAccount != null) {
			List<Page> pages = userAccount.getPages();

			System.out.println("User name :" + userAccount.getName());
			System.out.println("User email  : " + userAccount.getEmail());
			System.out.println("User Mobile : " + userAccount.getMobile());
			System.out.println("----------------------------------");

			for (Page page : pages) {
				System.out.println("Page name : " + page.getName());
				System.out.println("Page title : " + page.getTitle());
				System.out.println("Page description : " + page.getDescription());
				System.out.println("**************************");
			}
		} else {
			System.out.println("No Account found with given user id");
		}
	}
}
