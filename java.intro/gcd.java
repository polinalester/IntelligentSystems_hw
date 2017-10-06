/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Polina
 */

import java.lang.Math;
import java.util.*;

public class gcd {
    public static int GetGcdMod(int a, int b){
        while(b!=0){
            a=a%b;
            int temp;
            temp=a;
            a=b;
            b=temp;        
        }
        if (a<0 || b<0) return (-a);
        else return a;
    }
    public static int GetGcdFloorMod(int a, int b){
        while(b!=0){
            a = Math.floorMod(a,b);
            int temp;
            temp=a;
            a=b;
            b=temp;        
        }
        if (a<0) return (-a);
        else return a;
    }
    public static int GetGcdRem(int a, int b){
        while(b!=0){
            a = (int) Math.IEEEremainder(a,b);
            int temp;
            temp=a;
            a=b;
            b=temp;        
        }
        if (a<0 || b<0) return (-a);
        else return a;
    }
    static Scanner reader = new Scanner(System.in);
    public static void main(String args[]){
        int a, b;
        System.out.print("a = ");
        a = reader.nextInt();
        System.out.print("b = ");
        b = reader.nextInt();
        
        int result = GetGcdMod(a,b);
        System.out.print("gcd (%) = ");
        System.out.println(result);
        
        result = GetGcdFloorMod(a,b);
        System.out.print("gcd (FloorMod) = ");
        System.out.println(result);
        
        result = GetGcdRem(a,b);
        System.out.print("gcd (rem) = ");
        System.out.println(result);
    }
}
