package bankTransactions;

import java.io.Serializable;
import java.util.ArrayList;

//Mark Fitzgerald 15456198

public class Transactions implements Serializable{
	//create a static transaction number variable
	private static long tranNumber = 1;
	//create a transaction number for the current transaction
	private long currentTranNo;
	//create a variable for the date
	private String date;
	//create a variable for the type of transaction
	private String type;
	//create a variable for the amount in the transaction
	private double amount;
	
	//constructor takes in date, type and amount 
	public Transactions(String date, String type, double amount) {
		//store the values of date, type and amount
		this.date = date;
		this.type = type;
		this.amount = amount;
		//give the transaction a number
		currentTranNo = tranNumber;
		//update the transaction number for next time
		tranNumber++;
	}
	
	//toString for transaction details
	public String toString() {
		//print the transaction number, the date it occurred and the amount
		return "\n" + currentTranNo + ". " + date + "  " + type + " " + amount;
	}
}
