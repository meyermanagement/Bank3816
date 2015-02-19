package bankatm;




/**
 *
 * @author mamfx7
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*; 

	
public class Account {

   
	private double balance; 	
	private int firstdate;
	private int seconddate;
        private int firstyear;
	private int secondyear;
	private Calendar date1 = new GregorianCalendar();
	private Calendar date2 = new GregorianCalendar();
        private Calendar year1 = new GregorianCalendar();
	private Calendar year2 = new GregorianCalendar();
	private boolean dateflag = false;
	private double rate;
        private String acctNum;
           
 
    public Account(double rate, double bal){
        this.rate = rate;
        balance = bal;
        
    }
    
        	
    public void menu() throws IOException {            
        int num = 0;
        while (num !=4){

        System.out.println("Please select an option");
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println("3. Balance");
        System.out.println("4. Return to Main Menu");
        Scanner scan = new Scanner(System.in);
      //  double balance = 0;
       // double actBalance = 0;
        num = scan.nextInt();
         		
			if (num == 1) {
                 		System.out.println("Your current balance is: " + getBalance(balance));
				if (dateflag == true){					
                                        getDate2();
					getInterest();
					deposit();
                                        //again();
                                        //if(isContinue=='n')
                                        	return;
				        
                                }
				else{
				 	getDate1();
					deposit();
                                        //again(); if(isContinue=='n')
                                        	return;
					
                                }
                        }
			
                        else if (num == 2) {
                		System.out.println("Your current balance is: " + getBalance(balance));
				if (dateflag == true){
                                        getDate2();
                                        getInterest();
                                        withdraw();
                                        //again();
                                        
                                        //if(isContinue=='n')
                                        	return;
                                }
                                else{
                                        getDate1();
                                        withdraw();
                                        //again();
                                        //if(isContinue=='n')
                                        	return;
                                }
			
                        }


                        else if(num == 3){
                                if (dateflag == true){
                                        getDate2();
                                        getInterest();
                                        System.out.println("Your current balance is: " + getBalance(balance));
                                        //again();
                                        //if(isContinue=='n')
                                        	return;
                                }
                                else{
                                        getDate1();
                                        System.out.println("Your current balance is: " + getBalance(balance));
                                        //again();
                                       // if(isContinue=='n')
                                        	return;
                                }
                                
                        }
                        
                        else if(num == 4){
                                //System.exit(0);
                        	return;
                            
                                }
                        
                          }
        }                
        
        
         		
                
                        
	
        

        
       
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the acctNum
     */
    public String getAcctNum() {
        return acctNum;
    }
    

    /**
     * @param acctNum the acctNum to set
     */
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }
    public double getRate() {
        return rate;
    }

    /**
     * @param balance the balance to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRate(double rate) {
    String currencyOut = String.format("%.2f", rate);
    return currencyOut;
    
        }
     

    public String getBalance(double balance) {
    String currencyOut = String.format("%.2f", balance);
    return currencyOut;
    
        }

	

	public void deposit() throws IOException {
		BufferedReader br;
		String entered_amount;

                System.out.println("How much would you like to deposit");
                System.out.println("  Please Enter Positive amount");
                
		br = new BufferedReader(new InputStreamReader(System.in));
		entered_amount = br.readLine();
                
                double amount = Double.parseDouble(entered_amount);
                if (amount >= 0){
                balance = balance + amount;
                System.out.println(" Your balance is: " + getBalance(balance));
                }else
                System.out.println("  Amount is not positive ");      
   
        }
	

	public void withdraw() throws IOException {
		BufferedReader br;
		String entered_amount;

		System.out.println("  How much would you like to withdraw ?");
                System.out.println("     Please Enter Positive amount");
		br = new BufferedReader(new InputStreamReader(System.in));
		entered_amount = br.readLine();
		double amount = Double.parseDouble(entered_amount);
                if (amount >= 0){
                    if (balance - amount >= 0){
                        
                        balance = balance - amount;
                        System.out.println(" Your New balance is: " + getBalance(balance));
                    }else
                    	System.out.println("Insufficient funds.");
                }else
                   System.out.println("  Amount is not positive ");
	
		}
        
 /*      public void again() throws IOException{ 
               
               BufferedReader yorn;
               String input;
               char choice;
               
               System.out.println("Would you like to make another transaction? (y or n)");
               int select = 0; 
               yorn = new BufferedReader(new InputStreamReader(System.in));
               input = yorn.readLine();
               choice = input.charAt(select);
                
                if(choice == 'y')
                        {
                            isContinue='y';
                        } 
                else if(choice == 'n')
                        {
                           isContinue='n';
                           // System.exit(0);
                        }

       }
*/	

	public void getDate1() throws IOException { 
		
		System.out.print("Enter todays date(mm/dd/yyyy): ");
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String inputText = br.readLine();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                ParsePosition ypos = new ParsePosition(0);
		ParsePosition pos = new ParsePosition(0);
                Date date;
                Date year;
		year = formatter.parse(inputText,ypos);
                date = formatter.parse(inputText, pos); 
		
                year1.setTime(year);
		date1.setTime(date);
		
                firstyear = year1.get(Calendar.YEAR);
		firstdate = date1.get(Calendar.DAY_OF_YEAR);
		dateflag = true; 
		
        }  

	

	 public void getDate2() throws IOException {

                System.out.print("Enter todays date(mm/dd/yyyy): ");
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(System.in));
                String inputText = br.readLine();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                ParsePosition ypos = new ParsePosition(0);
		ParsePosition pos = new ParsePosition(0);
                Date date;
                Date year;
		year = formatter.parse(inputText,ypos);
                date = formatter.parse(inputText, pos); 
		
                year2.setTime(year);
		date2.setTime(date);

                secondyear = year2.get(Calendar.YEAR);
                seconddate = date2.get(Calendar.DAY_OF_YEAR);               
                
		
               if(firstyear > secondyear){
                   System.out.println("You must enter a future date.");	
			getDate2();
               }
               else if ((firstyear == secondyear) && (firstdate > seconddate)){
                  
			System.out.println("You must enter a future date.");	
			getDate2();
                        
               }
               
               
               
                   
               
				
	}
         
	

	public void getInterest() {
            
                int yeardiff = secondyear - firstyear;
		int datediff = seconddate - firstdate;
                double yamount = yeardiff * 365;
		double intrate = rate/365;
                double totinterest = yamount + datediff;
		double ratetime = Math.pow(1+intrate,totinterest);
                balance = balance * ratetime;
		firstdate = seconddate;
                firstyear = secondyear;
		 
	}

	public String toString(){
		return String.format("%s|%s|%s",getAcctNum(),getBalance(balance),getRate(rate));
	}
	
   
    }

