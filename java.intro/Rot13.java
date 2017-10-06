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

public class Rot13 {
    public static char [] convert(char [] str)
    {
        int temp;
        for (int i = 0; i<str.length; i++)
        {
            if ((str[i] >= 'A')&&(str[i] <= 'Z'))
                temp =(((str[i] - 'A') + 13) % 26) + 'A';
            else if ((str[i] >= 'a')&&(str[i] <= 'z'))
                temp =(((str[i] - 'a') + 13) % 26) + 'a';
            else temp=str[i];
            str[i]=(char)temp;
        }
        return str;
    }
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        String s;
        System.out.println("Enter a string:");
        s=reader.nextLine();
        char [] str = s.toCharArray ();
        char [] result = convert(str);
        System.out.println("=> (rot13)");
        System.out.println(result);
        result = convert(result);
        System.out.println("=> (rot13)");
        System.out.println(result);
    }
}
