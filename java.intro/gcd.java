/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Polina
 */

//import java.lang.Math;
import java.util.*;

public class gcd {
    static Scanner reader = new Scanner(System.in);
    public static void main(String args[]){
        int a, b;
        System.out.print("a = ");
        a=Math.abs(reader.nextInt());
        System.out.print("b = ");
        b=Math.abs(reader.nextInt());
        while(b!=0){
            a=a%b;
            int temp;
            temp=a;
            a=b;
            b=temp;        
        }
        System.out.print("gcd = ");
        System.out.println(a);
    }
}
