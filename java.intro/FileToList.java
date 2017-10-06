/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Polina
 */

/*7. Write a program that reads a text file, specified by the first command line
argument, into a List. The program should then print random lines from the file, the
number of lines printed to be specified by the second command line argument. Write
the program so that a correctly-sized collection is allocated all at once, instead of
being gradually expanded as the file is read in. Hint: To determine the number of lines
in the file, use java.io.File.length to obtain the size of the file, then divide by an
assumed size of an average line.*/

import java.io.*;
import java.util.*;

public class FileToList {
    public static void main(String[] args) {
        //считываем путь к файлу и число выдаваемых строк
        Scanner rd = new Scanner(System.in);
        System.out.println("Enter the path:");
        String path = rd.nextLine();
        System.out.println("Enter number of lines:");
        int numberOfLines = rd.nextInt();
        int lineLength = 100;

        File file = new File(path);
        int size = (int) ((file.length() / lineLength)+1);
        
        List<String> fileList;
        fileList = new ArrayList<String>(size);
        int count = 0; //счетчик количества считанных строк
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            try {
                String line;
                while ((line = in.readLine()) != null){
                    fileList.add(line);
                    count++;
                }
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    System.exit(-1);
                }
            }
        } catch (IOException e) {
            System.exit(-1);
        }
        System.out.println("Random lines:");
        Random random = new Random();
        for (int i = 0; i < numberOfLines; i++) {
            System.out.println(fileList.get(random.nextInt(count - 1)));
        }
    }
}
