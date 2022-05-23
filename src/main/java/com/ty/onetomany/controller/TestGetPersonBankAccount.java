package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.BankAccount;
import com.ty.onetomany.dto.Person;

public class TestGetPersonBankAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Person person = entityManager.find(Person.class, 1);
		System.out.println("----------------------");
		System.out.println("Person name : " + person.getName());
		System.out.println("Person email : " + person.getEmail());
		System.out.println("Person phone : " + person.getPhone());

		List<BankAccount> bankAccounts = person.getBankAccount();

		for (BankAccount bankAccount : bankAccounts) {
			System.out.println("---------------------");
			System.out.println("Bank name : "+bankAccount.getBankName());
			System.out.println("Account Number : "+bankAccount.getAccountNumber());
			System.out.println("Bank ifsc code : "+bankAccount.getIfscCode());
			System.out.println("*******************************");
			
		}
	}
}
