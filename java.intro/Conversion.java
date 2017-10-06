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
        System.out.println("Enter hexadecimal:");
        String hex;
        hex = reader.nextLine();
        System.out.println(" => decimal:");
        long dec = Long.parseLong(hex, 16);
        System.out.println(dec);
    }
}
