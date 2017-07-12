
package performance.sorting;

/**
 *
 * @author joharteaga
 */
public class BubbleSortOptimised implements AlgorithmInterface {

    @Override
    public void sort(int[] data) {
        
        boolean isSorted;
            
        for (int i = 0; i < data.length; i++) {
            isSorted = true;
            
            for (int j = 1; j < data.length - i; j++) {
                
                if (data[j-1] > data[j]) {
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                    
                    isSorted = false;

                }
            }
            
            if (isSorted) {
                break;
            }
        }
    }

    @Override
    public void sort(String[] data) {
        
        boolean isSorted;
            
        for (int i = 0; i < data.length; i++) {
            isSorted = true;
            
            for (int j = 1; j < data.length - i; j++) {
                
                if (data[j-1].compareToIgnoreCase(data[j]) > 0) {
                    String temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                    
                    isSorted = false;

                }
            }
            
            if (isSorted) {
                break;
            }
        }
    }
    
}
