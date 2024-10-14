package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class BankCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDetails accountDetails){
		//lambda function
		return runner -> {
//			createAccount(accountDetails);
//			readAccountByAccountNumber(accountDetails);
//			queryForAccounts(accountDetails);
//			queryForAccountHolder_ByLastName(accountDetails);
//			updateAccountDetails(accountDetails);
			deleteAccount(accountDetails);
		};
	}

	private void deleteAccount(AccountDetails accountDetails) {
		int theAccountNumber = 3;
		System.out.println("deleting Student with id:" + theAccountNumber);
		accountDetails.delete(theAccountNumber);
	}

	private void updateAccountDetails(AccountDetails accountDetails) {
		int AccountId = 2;
		System.out.println("getting Account with Account number: " + AccountId);
		Account myAccount = accountDetails.findById(AccountId);

		//changing the first name to sccoby,
		System.out.println("Updating the Account details....");
		myAccount.setFirstName("sccoby");

		accountDetails.update(myAccount);
		System.out.println("Updated student: " + myAccount);
	}

	private void queryForAccountHolder_ByLastName(AccountDetails accountDetails) {
		List<Account> theAccounts = accountDetails.findByLastName("gills");

		for(Account theAccount : theAccounts){
			System.out.println(theAccount);
		}
	}

	private void queryForAccounts(AccountDetails accountDetails) {
		//return/Display list of accounts
		List<Account> theAccounts = accountDetails.findAll();

		for(Account tempAccount : theAccounts){
			System.out.println(tempAccount);
		}
	}

	private void readAccountByAccountNumber(AccountDetails accountDetails) {
		System.out.println("Creating a new Account object");
		Account tempAccount = new Account("brizz", "gills", "bg@example.com", 200);

		//saving the object
		System.out.println("saving the account object");
		accountDetails.save(tempAccount);

		int theId = tempAccount.getId();
		System.out.println("saved Account, Account Number:" + theId);

		Account account = accountDetails.findById(theId);

		System.out.println("Account: " + account);
	}

	private void createAccount(AccountDetails accountDetails) {
		System.out.println("creating new Account");
		Account tempAccount = new Account("jack", "watson", "walson.jack@example.com", 10000);

		System.out.println("saving the account");
		accountDetails.save(tempAccount);

		System.out.println("saved account Id/AccountNumber :" + tempAccount.getId());
	}


}
