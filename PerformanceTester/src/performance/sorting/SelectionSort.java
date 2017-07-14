
package performance.sorting;

/**
 *
 * @author joharteaga
 */
public class SelectionSort implements AlgorithmInterface {

    @Override
    public void sort(int[] data) {
        //check if array null or empty;
        //move to controller?
        if (isNullOrEmpty(data)) {
            return;
        } else if (containsOneElement(data)) { 
            return;
        }
        
        int length = data.length;
        
        for (int i = 0; i < length - 1; i++) {
            int min = i;  
            
            for (int j = i + 1; j < length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }

            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
            
        }

    }

    @Override
    public void sort(String[] data) {
        if (isNullOrEmpty(data)) {
            return;
        } else if (containsOneElement(data)) { 
            return;
        }
        
        int length = data.length;
        
        for (int i = 0; i < length; i++) {
            int min = i;  
            
            for (int j = i + 1; j < length; j++) {
                int compare = data[j].compareToIgnoreCase(data[min]);
                if (compare < 0) {
                    min = j;
                }
            }

            String temp = data[i];
            data[i] = data[min];
            data[min] = temp;
            
        }
    }  

    @Override
    public String getName() {
        return "SelectionSort";
    }
}
