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

//import java.io.*;
import java.util.*;
//import java.util.stream.IntStream;
import java.util.stream.Stream;
//import java.util.stream.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class Stream Scanner {
    public static IntStream intScanner(Scanner sc){
        Iterator<Integer> it = new Iterator<Integer>(){
            int next;
            @Override
            public boolean hasNext(){
                next = sc.nextInt();
                return (sc.hasNext());
            }
            @Override
            public Integer next(){
                if (hasNext()){
                    return next;
                }else{
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.intStream(Spliterators.spliteratorUnknownSize((PrimitiveIterator.OfInt) it, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
    public static DoubleStream doubleScanner(Scanner sc){
        Iterator<Double> it = new Iterator<Double>(){
            double next;
            @Override
            public boolean hasNext(){
                next = sc.nextInt();
                return (sc.hasNext());
            }
            @Override
            public Double next(){
                if (hasNext()){
                    return next;
                }else{
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.doubleStream(Spliterators.spliteratorUnknownSize((PrimitiveIterator.OfDouble) it, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
    public static Stream<String> stringScanner(Scanner sc){
        Iterator<String> it = new Iterator<String>(){
            String next = null;
            @Override
            public boolean hasNext(){
                if (next != null){
                    return true;
                }else{
                    next = sc.nextLine();
                    return (next != null);
                }
            }
            @Override
            public String next(){
                if (next != null || hasNext()){
                    String line = next;
                    next = null;
                    return line;
                }else{
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
    public static Stream<String> wordScanner(Scanner sc){
        Iterator<String> it = new Iterator<String>(){
            String next = null;
            @Override
            public boolean hasNext(){
                if (next != null){
                    return true;
                }else{
                    next = sc.next();
                    return (next != null);
                }
            }
            @Override
            public String next() {
                if (next != null || hasNext()) {
                    String line = next;
                    next = null;
                    return line;
                }else{
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
}
