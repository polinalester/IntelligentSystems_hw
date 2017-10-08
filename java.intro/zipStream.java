/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author Polina
 */
 
//import java.io.*;
import java.util.*;
//import java.util.stream.IntStream;
import java.util.stream.Stream;
//import java.util.stream.*;
import java.util.function.BiFunction;

public class zipStream {
    public static class Pair<T, U> {
        public T firstEl;
        public U secondEl;
        public Pair(T t, U u) {
            firstEl = t;
            secondEl = u;
        }
    }
    public static <T, U, R> Stream<R> zip(Stream<T> firstStream, Stream<U> secondStream, BiFunction<T, U, R> f) {
        Iterator<U> itr = secondStream.iterator();
        //BiFunction<T,U,R> f = (a, b) -> new Pair(a, b);
        return firstStream.filter(x -> itr.hasNext()).map(x -> f.apply(x, itr.next()));
    }
    public static <T, U> Stream<Pair<T, U>> zip(Stream<T> firstStream, Stream<U> secondStream) {
        return zip(firstStream, secondStream, (a, b) -> new Pair(a, b));
    }
    public static void main(String[] args) {
        String[] firstArray = {"a1", "a2", "a3"};
        String[] secondArray = {"b1", "b2", "b3", "b4", "b5", "b6"};
        Stream<String> firstStream = Arrays.stream(firstArray);
        //firstStream.forEach(System.out::print);
        Stream<String> secondStream = Arrays.stream(secondArray);
        //secondStream.forEach(System.out::print);
        Stream<Pair<String, String>> finalStream = zip(firstStream, secondStream);
        finalStream.map(s -> s.firstEl + " " + s.secondEl + " ").forEach(System.out::print);
    }
}
