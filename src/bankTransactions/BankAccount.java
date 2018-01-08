package bankTransactions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Mark Fitzgerald 15456198

public class BankAccount implements Serializable{
		//create a static accNum variable
		private static long accNum = 1000;
		//create a specific accNum for each person
		private long myAccNum;
		//create a balance variable
		private double balance;
		//create a name variable
		private String name;
		//create an overdraft variable
		private double overdraft;
		//create an ArrayList to store transactions
		private ArrayList<Transactions> trans = new ArrayList<Transactions>();
		

		//constructor takes in date, balance, and name
		public BankAccount(String date, double amount, String fName, String lName) {
			//create the name from first and last names
			this.name = fName + " " +lName;
			//give the person an account number
			this.myAccNum = this.accNum;
			//increase the accNum variable
			accNum++;
			//store the balance amount
			balance = amount;
			//give them an overdraft of €100
			overdraft = 100;
			//create a new open account transaction object
			Transactions t = new Transactions(date, " Open Account", + amount);
			//add it to the array
			trans.add(t);
		}
		
		//deposit method takes in date and amount of deposit
		public void deposit(String date, double amount) {
			//increase the bank account holders balance
			balance += amount;
			//create a new deposit transaction 
			Transactions t = new Transactions(date, " Deposit of", + amount);
			//add it to the array
			trans.add(t);
		}
		
		//withdraw method takes in date and amount of deposit
		public void withdraw(String date, double amount) {
			//check if the balance is less than the amount they want to withdraw
			if(balance < amount) {
				//if it is print this to screen telling them 
				System.out.println("Insufficient funds to withdraw €" + amount + ".\n" 
						+ name + "'s balance is €" + balance);
			} else {
				//otherwise decrease the balance by the amount withdrawn
				balance -= amount;
				//create a new withdraw transaction
				Transactions t = new Transactions(date, " Withdraw of", + amount);
				//add it to the array
				trans.add(t);
			}
		}
		
		//getTransactionDetails from the transactions class
		public String getTransactionDetail() {
			//create a string to return
			String details = "";
			//cycle through the array with transaction objects
			for(int i =0; i<trans.size(); i++ ) {
				//store the transaction details in the variable
				details += trans.get(i).toString();
			}
			//return this variable
			return details;
		}
		
		//toString for bank account details
		public String toString() {
			//return the acc no., name of person, balance, overdraft and then get all of their transactions
			return "\n" + "Account Number: " + myAccNum + " Name: " + name 
					+ " Balance: " + balance + " Overdraft: " + overdraft + "\n" + getTransactionDetail();
		}
	
}
