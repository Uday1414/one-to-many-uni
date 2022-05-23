package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.BankAccount;
import com.ty.onetomany.dto.Person;

public class TestSavePersonBankAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person=new Person();
		person.setName("balaji");
		person.setEmail("balaji@mail.com");
		person.setPhone(9922954786l);
		
		BankAccount bankAccount1=new BankAccount();
		bankAccount1.setBankName("SBI");
		bankAccount1.setAccountNumber(456955666l);
		bankAccount1.setIfscCode("SBI1234");
		
		BankAccount bankAccount2=new BankAccount();
		bankAccount2.setBankName("HBSC");
		bankAccount2.setAccountNumber(2365877996l);
		bankAccount2.setIfscCode("HBSC1234");
		
		BankAccount bankAccount3=new BankAccount();
		bankAccount3.setBankName("ICICI");
		bankAccount3.setAccountNumber(9878445666l);
		bankAccount3.setIfscCode("ICICI1234");
		
		List<BankAccount> bankAccounts=new ArrayList<BankAccount>();
		bankAccounts.add(bankAccount1);
		bankAccounts.add(bankAccount2);
		bankAccounts.add(bankAccount3);
		person.setBankAccount(bankAccounts);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bankAccount1);
		entityManager.persist(bankAccount2);
		entityManager.persist(bankAccount3);
		entityTransaction.commit();
	}
}
