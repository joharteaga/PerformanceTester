/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.application;

import java.util.Arrays;
import performance.sorting.AlgorithmInterface;
import performance.sorting.QuickSort;

/**
 *
 * @author joharteaga
 */
public class Application {
    
    public static void main(String[] args) {
        // TESTING
        
        //int[] arr = {8, 4, 2, 6, 5, 9, 0, 3, 1, 7};
        String[] arr = {"frank", "tom", "alice", "sam", "cletus", "zapata"};
        System.out.println(Arrays.toString(arr));
        
        AlgorithmInterface alg = new QuickSort();
        //List<AlgorithmInterface> list = new ArrayList<>();
        alg.sort(arr);
        
        System.out.println(Arrays.toString(arr));
    }
}
