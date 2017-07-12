/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.sorting;

/**
 *
 * @author joharteaga
 */
public class BubbleSortClassic implements AlgorithmInterface {

    @Override
    public void sort(int[] data) {
        
        for (int i = 0; i < data.length; i++) {
            
            for (int j = 1; j < data.length - i; j++) {
                
                if (data[j-1] > data[j]) {
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;

                }
            }
        }
    }

    @Override
    public void sort(String[] data) {
        
        for (int i = 0; i < data.length; i++) {
            
            for (int j = 1; j < data.length - i; j++) {
                
                if (data[j-1].compareToIgnoreCase(data[j]) > 0) {
                    String temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;

                }
            }
        }
    }
    
}
