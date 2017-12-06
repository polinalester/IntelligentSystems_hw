/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author Polina
 */
 
 /*10. ( Optional ) Online palindrome detection. Read in characters one at a time. 
 Report at each instant if the current string is a palindrome. 
 Use the Rabin-Karp hashing algorithm.*/

//import java.io.*;
import java.util.*;


public class PalindromeDetector {
    public static void main(String[] args) {
       Scanner reader = new Scanner(System.in);
       int R = 256, q=103;//коэффиценты для вычисления хэша
       int n = 1;//текущая размерность строки

       String str=reader.nextLine(), temp;
       System.out.println(str.charAt(0)+" - yes");
       temp=reader.nextLine();
       n++;
       str=str.concat(temp);
  
       int firstr  = str.charAt(0)%q;//хэш первой развернутой половины строки
       int second = str.charAt(1)%q;//хэш второй половины строки
       
       //System.out.println("firstr = "+firstr);
       //System.out.println("second = "+second);
       
       int h = 1, i=1, j;
      
       while(/*reader.hasNextLine() && */(i<n))
       {
            if (firstr == second)//если хэши совпадают, проверяем на палиндром
            {
                for (j = 0; j < i/2; j++)
                {
                    if (str.charAt(j) != str.charAt(i - j))
                        break;
                }
                if (j==i/2)
                    System.out.println(str+" - yes");
                else System.out.println(str+" - no");
            }
            else System.out.println(str+" - no");
            
            //получение нового символа
            temp=reader.nextLine();
            n++;
            str=str.concat(temp);
            
            if (i != n - 1)//вычисление нового хэша для всех символов, кроме последнего
            {
                if (i % 2 == 0)//вычисление хэша при четном i
                {
                    h = (h * R) % q;
                    firstr  = (firstr + h *str.charAt(i/2)) % q;
                    second = (second * R + str.charAt(i+1)) % q;
                }
                else//вычисление хэша при нечетном i
                {
                    second = (R*(second+q-str.charAt((i + 1)/2)*h)%q+str.charAt(i+1))%q;
                }
            }
            //System.out.println("firstr = "+firstr);
            //System.out.println("second = "+second);
            i++;
        }
    }
}
