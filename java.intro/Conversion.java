/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Polina
 */

import java.util.*;

public class Conversion {
    public static void main(String args[]){
       Scanner reader = new Scanner(System.in);
       System.out.println("Enter hex number: ");
       String hex = reader.nextLine();
       while(!hex.matches("[-+]?[A-Fa-f0-9]+")){
           System.out.println("Enter HEX number: ");
           hex=reader.nextLine();
       }
       int dec = 0;
       boolean negative = false;
       if(hex.charAt(0)=='-')
       {
           negative=true;
           hex=hex.substring(1);
       }
       else if(hex.charAt(0)=='+')
           hex=hex.substring(1);
       
       int n = hex.length();
       char letter;
       for (int i=n-1;i>-1;i--)
       {
           letter = hex.charAt(i);
           if(letter <= '9')
           {
               dec+=Character.getNumericValue(letter)*Math.pow(16,n-i-1);
           }
           else if(letter>'F')
           {
               dec+=(letter-87)*Math.pow(16,n-i-1);
           }
           else{
               dec+=(letter-55)*Math.pow(16,n-i-1);
           }
           
       }
      if(negative)
          System.out.println(hex+" => "+(-dec));
      else System.out.println(hex+" => "+dec);
    }
}
