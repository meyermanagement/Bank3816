package bankatm;





import bankatm.Account;
import java.io.*;
import java.util.*;

/**
 *
 * @author mamfx7
 */
public class RunATM {
   static  ArrayList<Account> myAccounts= new ArrayList<Account>();
    public static void main(String args[]) throws IOException
    {
    	int choice=0;       
    	ReadFile();
        //showAccts();    
        do{
        	System.out.println("Select an Account Number ");
        	
        		System.out.println("1 :For Checking");
                        System.out.println("2 :For Savings");
                        System.out.println("3 :For Money Market");
                        System.out.println("0 :Exit");
        	
                        choice= Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        	
                        if(choice>0 && (choice-1)<myAccounts.size())
                        {
        		System.out.println("Your Balance is "+myAccounts.get(choice-1).getBalance(myAccounts.get(choice-1).getBalance()));
                        System.out.println("Your Interest Rate is "+myAccounts.get(choice-1).getRate(myAccounts.get(choice-1).getRate()));
        		myAccounts.get(choice-1).menu();
        		}
                        
                        
                        else if(choice==0)
                            break;
                        else
                            System.out.println("Enter Correct Option");
        		
        	
        }while(true);
        writeAcct();
    }

    public static void showAccts()
    {
        for(int i = 0; i < 3; i++)
        {
            
            System.out.println(myAccounts.get(i).getAcctNum() + " " + myAccounts.get(i).getBalance()+ " " + myAccounts.get(i).getRate());
        }

    }

    public static void ReadFile() throws NumberFormatException, IOException{
    	

        BufferedReader br= new BufferedReader(new FileReader("accountINFO.txt"));
        String line,temp[];
        int i=0;
        while((line=br.readLine())!=null){
     	   temp=line.split("\\|");
            myAccounts.add(new Account(Double.parseDouble(temp[2]),Double.parseDouble(temp[1])));
            myAccounts.get(myAccounts.size()-1).setAcctNum(temp[0]);
     	    i++;
            
        }
    }
    
    /*public static void populateAccts() throws IOException
    {
    	
    	
    	for(int i =0; i<3; i++)
        {
    		
    		  myAccounts.add(new Account(100.00));
    		  String s = Integer.toString(i);  
                  myAccounts.get(myAccounts.size()-1).setAcctNum(s);
            
            
            
        }
    }*/

  
    public  static void writeAcct()
    {
        try {
                                    File file = new File("accountINFO.txt");

                                    // if file doesnt exists, then create it
                                    if (!file.exists()) {
                                            file.createNewFile();
                                    }

                                    FileWriter fw = new FileWriter(file,false);
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    //System.out.println("Please choose an account number[0,1,2]: ");
                                    //Or comment out above line and create for loop to loop through
                                    //and write all accounts out.
                                   
                                    
                                    for(int i=0;i<myAccounts.size();i++)
                                    {
                                    bw.write(myAccounts.get(i).toString());
                                    bw.newLine();
                                    }
                                    bw.close();

                                    System.out.println("File Writing Done");

                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
    } 
}  

