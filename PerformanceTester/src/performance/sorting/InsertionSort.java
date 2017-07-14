
package performance.sorting;

/**
 *
 * @author joharteaga
 */
public class InsertionSort implements AlgorithmInterface {

    @Override
    public void sort(int[] data) {
        
        for (int i = 1; i < data.length; i++) {
            
            int val = data[i];
            
            int j = i - 1;
            
            while (j >= 0 && data[j] > val) {
                data[j+1] = data[j];
                j--;
            }
            
            data[j + 1] = val;
        }
    }

    @Override
    public void sort(String[] data) {
        
        for (int i = 1; i < data.length; i++) {
            
            String val = data[i];
            
            int j = i - 1;
            
            while (j >= 0 && data[j].compareToIgnoreCase(val) > 0) {
                data[j+1] = data[j];
                j--;
            }
            
            data[j + 1] = val;
        }
    }

    @Override
    public String getName() {
        return "InsertionSort";
    }
    
}
