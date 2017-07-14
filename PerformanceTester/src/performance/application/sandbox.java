/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.application;

import java.util.HashSet;
import performance.data.TestResults;
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
public class sandbox {
    public static void main(String[] args) {
        TestResults test = new TestResults();
        
        HashSet<AlgorithmInterface> set = new HashSet<>();
        
        set.add(new BubbleSortClassic());
        set.add(new BubbleSortOptimised());
        set.add(new InsertionSort());
        set.add(new MergeSort());
        set.add(new QuickSort());
        set.add(new SelectionSort());
        
        test.addTest(set);
        
        System.out.println(test.runTests("int[]", 10000));
        
        
    }
        
}
