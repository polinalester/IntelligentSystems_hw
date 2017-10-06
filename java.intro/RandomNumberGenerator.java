/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Polina
 */

import java.util.stream.*;
import java.lang.Math;

public class RandomNumberGenerator {
    public static void main(String args[]){
        double seed = 1, c=11;
        long a = 25214903917L, m = (long) Math.pow(2,48);
        Stream.iterate(seed, (Double n) -> (a*n+c) % m)
          .limit(10)
          .forEach(System.out::println);
    }
}
