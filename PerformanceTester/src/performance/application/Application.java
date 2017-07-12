/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.application;

import java.util.Arrays;
import performance.data.IntArrayGenerator;
import performance.data.StringArrayGenerator;
import performance.sorting.AlgorithmInterface;
import performance.sorting.BubbleSortClassic;
import performance.sorting.BubbleSortOptimised;
import performance.sorting.InsertionSort;
import performance.sorting.QuickSort;

/**
 *
 * @author joharteaga
 */
public class Application {
    
    public static void main(String[] args) {
        // TESTING
        
        IntArrayGenerator intArray = new IntArrayGenerator();
        StringArrayGenerator strArray = new StringArrayGenerator();
        
        System.out.println(Arrays.toString(intArray.getRandomIntArray(10)));
        System.out.println(Arrays.toString(strArray.getRandomStringArray(5, 10)));
        
//        //int[] arr = {8, 4, 2, 6, 5, 9, 0, 3, 1, 7};
//        String[] arr = {"frank", "tom", "alice", "sam", "cletus", "zapata"};
//        System.out.println(Arrays.toString(arr));
//        
//        AlgorithmInterface alg = new BubbleSortOptimised();
//        //List<AlgorithmInterface> list = new ArrayList<>();
//        alg.sort(arr);
//        
//        System.out.println(Arrays.toString(arr));
    }
}
