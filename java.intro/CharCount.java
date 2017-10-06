/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Polina
 */

/*6. Write an example that counts the number of times a particular character,
such as E, appears in a file. The character can be specified at the command line.*/

import java.io.*;
import java.util.*;

public class CharCount {
    public static void main(String[] args) {
        //считываем путь к файлу и искомый символ
        Scanner rd = new Scanner(System.in);
        System.out.println("Enter the path:");
        String path = rd.nextLine();
        System.out.println("Specify the character:");
        char ch = rd.next().charAt(0);

        File file = new File(path);

        int count = 0; //счетчик количества букв
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            try {
                String line = null;
                while ((line = in.readLine()) != null) {
                    for (int i = 0; i < line.length(); i++) {
                        if (ch == line.charAt(i)) {
                            count++;
                        }
                    }
                }
            }
            finally {
                try {
                    in.close();
                } catch (IOException e) {
                    System.exit(-1);
                }
            }
        } catch (IOException e) {
            System.exit(-1);
        }
        System.out.println("Total:");
        System.out.println(count);
    }
}
