package bankTransactions;

//Mark Fitzgerald 15456198

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	 public static void main(String args[]) throws IOException, ClassNotFoundException {//create three transaction objects
		 Transactions t1 = new Transactions("16/08/2017", "Open Account", 100);
		 Transactions t2 = new Transactions("22/08/2017", "Withdraw", 50);
		 Transactions t3 = new Transactions("23/09/2017", "Deposit", 100);
		 
		 ArrayList<String> transactions = new ArrayList<String>();
		 //create an array list to store them
		 transactions.add(t1.toString());
		 transactions.add(t2.toString());
		 transactions.add(t3.toString());
		 //add them to the array
		  
		 //Serialize the ArrayList
		 //create a file input stream object
		 FileOutputStream fos = new FileOutputStream("transactions.txt");
		 //create an object output stream object
		 ObjectOutputStream oos = new ObjectOutputStream(fos);
		 //write the arrayList details to it
		 oos.writeObject(transactions);
		 //flush in case the computer fails
		 oos.flush();
		 //close the object output stream
		 oos.close();

		 //Deserialize the ArrayList
		 //create a file input stream object
		 FileInputStream fis = new FileInputStream("transactions.txt");
		 //create a object input stream object
		 ObjectInputStream ois = new ObjectInputStream(fis);
		 //create a new arrayList to deserialize the array
		 ArrayList<String> transactions2 = (ArrayList<String>) ois.readObject();
		 //close the object input stream
		 ois.close();

		 //Print the part 1 output
		 System.out.println("**********PART ONE**********\n\n");
		 //Print out the contents of deserialized ArrayList
		 System.out.println("It is " + (transactions2 instanceof Serializable) 
				 + " that the ArrayList implements Serializable");
		 //this check confirms the ArrayList is serializible 
		 System.out.print("Deserialized array: ");
		 //cycle through each element in the arrayList
		 for (int i=0; i<transactions2.size(); i++) {
			 System.out.print(transactions2.get(i));
			 //print each element
		 }
	    
		 //now onto part 2
		 System.out.println("\n\n**********PART TWO**********\n\n");
		 BankAccount bankAcc = new BankAccount("16/08/2017", 100, "Mark", "Fitzgerald");
		 //create a bankAccount object
		 bankAcc.withdraw("22/08/2017", 200);
		 bankAcc.deposit("23/08/2017", 100);
		 bankAcc.withdraw("01/09/2017", 50);
		 //withdraw and deposit money
	    
		 //serialize the bank account
		 //create a file output stream object
		 FileOutputStream fos2 = new FileOutputStream("accountdetails.txt");
		 //create an object output stream object
		 ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
		 //write the bank account details to it
		 oos2.writeObject(bankAcc);
		 //flush in case the computer fails
		 oos2.flush();
		 //close the object output stream
		 oos2.close();

		 //Deserialize the bank account to print it
		 //create a file input stream object
		 FileInputStream fis2 = new FileInputStream("accountdetails.txt");
		 //create a object input stream object
		 ObjectInputStream ois2 = new ObjectInputStream(fis2);
		 //create a new bank account object to deserialize it for printing
		 BankAccount bankAcc2 = (BankAccount) ois2.readObject();
		 //print out the bank account details
		 System.out.println(bankAcc2);
		 //close the object input stream object
		 ois2.close();
		 
		 //now onto part 3
		 System.out.println("\n\n**********PART THREE**********\n\n");
		 //create the overdraftExceeded.txt file and print the two lines in it
		 //create file writer object
		 FileWriter fw = new FileWriter("overdraftIncrease.txt");
		 //create a print writer object
		 PrintWriter pw = new PrintWriter(fw);
		 //print the text in the file
		 pw.println("Would you like to increase your overdraft? "
		 		+ "\nPlease type Yes/No at the end of the line. ");
		 //close the print writer
		 pw.close();
		 
		 //print out what's currently in the file
		 //create a file reader object
		 FileReader fr = new FileReader("overdraftIncrease.txt");
		 //create a buffered reader object
    	 BufferedReader br = new BufferedReader(fr);
    	 //create a string to print
    	 String line;
    	 //only print lines with text
    	 while((line = br.readLine()) !=null) {
    		//print the string
    	 	System.out.println(line);
    	 }
    	 //close the buffered reader
    	 br.close();
	    
    	 //scan in what the user types 
	     Scanner scanner = new Scanner(System.in);
	     String answer = scanner.nextLine();
	    
	     //check if they typed Yes or No
	     if(answer.equals("Yes") || answer.equals("No")) {
	     	
	    	//create a new random access file object
	     	RandomAccessFile raf = new RandomAccessFile("overdraftIncrease.txt", "rw");
	     	//skip to the end
	    	raf.skipBytes((int) (raf.length()-1));
	    	//write in what the user inputed (Yes/No)
	    	raf.writeBytes(answer);
	    	//close the random access file
	    	raf.close();
	    	
	    	//create a file reader object
	    	FileReader fr2 = new FileReader("overdraftIncrease.txt");
	    	//create a buffered reader object using the file reader
	    	BufferedReader br2 = new BufferedReader(fr2);
	    	//create a string to print
	    	String line2;
	    	//only print the lines with text
	    	while((line2 = br2.readLine()) !=null) {
	    		//print the string
	    		System.out.println(line2);
	    	}
	    	//close the buffered reader
	    	br2.close();
	    }
	 }
}
