/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.data;

import java.util.Random;

/** Generates and returns a filled int array based on parameters
 *
 * @author joharteaga
 */
public class IntArrayGenerator {
    private Random random;

    public IntArrayGenerator() {
        this.random = new Random();
    }
    
    
    //generates random unbounded int array in min-max int range
    public int[] getRandomIntArray(int size) {
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        
        return array;
    }
    
    //generates bounded (inclusive) array
    public int[] getRandomBoundedIntArray(int size, int lower, int upper) {
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((upper - lower) + 1 + lower);
        }
        
        return array;
    }
    
}
