package Data_Types;

import java.util.Scanner;

public class ATM{
	private static double balance = 1000.00;
	private static final String correctpin = "1234";
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n *** WELCOME TO ATM  ***");
		
		System.out.println("ENTER YOUR ATM PIN ");
		
		String PIN =sc.nextLine();
		
		if(authenticate(PIN)) {
		
			int choice=0;
			
				
			do {
				
				System.out.println("\n ATM MENU  ");
				System.out.println(" 1  : CHECK BALANCE ");
				System.out.println(" 2  : DEPOSIT  ");
				System.out.println(" 3  : WITHDRAW ");
				System.out.println(" 4  : EXIT");

				try {
				System.out.println("ENTER YOUR CHOICE :");
				
				choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				
				case 1 : checkbalance();
				break;
				
				case 2 :	System.out.println("ENTER THE AMOUNT TO DEPOSIT :");
				        	deposit(sc);
				break;
				
				case 3 : 	System.out.println("ENTER THE AMOUNT TO WITHDRAW : ");
				        	withdraw(sc);
				break;
				
				case 4 :
				System.out.println("\n THANK YOU FOR VISITING  \n EXITING...........");
				break;
				
				default : System.out.println("INVALID OPTION........");
				
				}
				}catch(Exception e) {
					System.out.println("INVALID OPTION ONLY ENTER NUMBER ONLY");
					sc.nextLine();
					System.out.println(e.getMessage());
				}
				
			}while(choice!=4);
		
		}
		else {
			System.out.println("INCORRECT PIN! ACCESS DENIED. ");
		}
		sc.close();

	}
	
	public static boolean authenticate(String PIN) {
		
		return PIN.equals(correctpin);
	}
	
	public static void checkbalance() {
		
		System.out.println( " YOUR CURRENT BALANCE  IS : "+balance);
		
	}
	public static void deposit(Scanner sc) {
		
		try {
		double amount = sc.nextDouble();
		if(amount >0) {
			balance+=amount;
			System.out.println(" DEPOSITED AMOUNT IS :"+amount);
			checkbalance();
		}
		else System.out.println("INVALID DEPOSIT AMOUNT!...");
		
	}catch(Exception e) {
		
		System.out.println("INVALID INPUT. PLEASE ENTER A VALID NUMBER.");
		System.out.println(e.getMessage());
		sc.nextLine();
	}
		
	}
	
	
	public static void withdraw(Scanner sc) {
		try {
		double amount = sc.nextDouble();
		if(amount>0 && amount<=balance) {
			balance-=amount;
			System.out.println(" WITHDRAWN AMOUNT IS :"+amount);
			 checkbalance();
		}else if(amount>balance) {
			
			System.out.println("INSUFFICIENT BALANCE!......");
		}
		else {
			System.out.println("INVALID WITHDRAWAL AMOUNT!....");
		}
	}catch(Exception e) {
		System.out.println("INVALID INPUT. PLEASE ENTER A VALID NUMBER.");
		System.out.println(e.getMessage());
		sc.nextLine();
	}
		
	}
	

}
