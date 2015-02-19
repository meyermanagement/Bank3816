/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankatm;

/**
 *
 * @author mamfx7
 */


class InterestAccount extends Account(){

      

    public double MoneyMarket()
    {
        double mmint = .10;
        return mmint;
    }
    
    public double Savings()
    {
        double saveint = .05;
        return saveint;
    }
    
    public double Checking()
    {
        double checkint = .01;
        return checkint;
    }

    
    
    
    
    
}
