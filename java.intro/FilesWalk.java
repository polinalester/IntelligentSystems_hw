/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Polina
 */

/*5. Unzip the src.zip file from the JDK. Using Files.walk, find all Java files that
contain the keywords transient and volatile;*/

//import java.io.*;
import java.util.*;
//import java.util.stream.IntStream;
import java.util.stream.Stream;
//import java.util.stream.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.stream.Collectors; 


public class FilesWalk {
    //функция проверки на наличие ключевых слов
    public static boolean match (String dir, String [] keywords) {
        Boolean firstKey=false, secondKey=false;
        try{
            Scanner s = new Scanner(new File(dir));
            //считываем строки в файле
            while(s.hasNextLine()){
            String nextLine = s.nextLine();
            //проверяем первое ключевое слово
            if(nextLine.contains(keywords[0])){
                firstKey=true;
            }
            //проверяем второе ключевое слово
            if(nextLine.contains(keywords[1])){
                secondKey=true;
            }
            if (firstKey && secondKey){
                //System.out.println(dir);
                return true;
            }
        }}
        catch (FileNotFoundException e){
            return false;
        }
        return false;
    }
    public static void main(String[] args) throws IOException, FileNotFoundException{
        Path pathToRoot = Paths.get("zipsrc/java"); //путь к корню дерева поиска
        int maxDepth = 10;//максимальная глубина спуска в дереве
        String [] keywords = {"transient", "volatile"};//ключевые слова
        try (Stream<Path> stream = Files.walk(pathToRoot, maxDepth)){
            String dirList = stream //записываем пути к нужным файлам
                .map(String::valueOf)
                .filter(path -> match(path, keywords)) //проверка наличия ключевых слов
                .collect(Collectors.joining("\n")); //конкатенация путей
            System.out.println(dirList);
        }
    }
}
