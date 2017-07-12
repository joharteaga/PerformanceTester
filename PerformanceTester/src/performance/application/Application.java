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
import performance.sorting.MergeSort;
import performance.sorting.QuickSort;
import performance.sorting.SelectionSort;

/**
 *
 * @author joharteaga
 */
public class Application {
    
    public static void main(String[] args) {
        // TESTING
        
        IntArrayGenerator intArray = new IntArrayGenerator();
        StringArrayGenerator strArray = new StringArrayGenerator();
        
        
        int[] arr1 = intArray.getRandomBoundedIntArray(1000000, 0, 1000000);
        int[] arr2 = new int[1000000];
        
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        //String[] arr = strArray.getRandomStringArray(10, 5);
        System.out.println(Arrays.toString(arr1));
        
        AlgorithmInterface alg1 = new QuickSort();
        AlgorithmInterface alg2 = new MergeSort();
        
        //List<AlgorithmInterface> list = new ArrayList<>();
        
        long startTime1 = System.currentTimeMillis();
        alg1.sort(arr1);
        long endTime1 = System.currentTimeMillis();
        
        long startTime2 = System.currentTimeMillis();
        alg2.sort(arr2);
        long endTime2 = System.currentTimeMillis();
        
        System.out.println("Performance:");
        System.out.println("  Alg1: " + (endTime1 - startTime1));
        System.out.println("  Alg2: " + (endTime2 - startTime2));
    }
}
