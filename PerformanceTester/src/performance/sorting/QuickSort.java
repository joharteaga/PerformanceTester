
package performance.sorting;

/**
 *
 * @author joharteaga
 */
public class QuickSort implements AlgorithmInterface {
    
    @Override
    public void sort(int[] data) {
        //check if array null or empty;
        //move to controller?
        if (isNullOrEmpty(data)) {
            return;
        } else if (containsOneElement(data)) { 
            return;
        }
        
        qsort(data, 0, data.length - 1);
        

    }

    @Override
    public void sort(String[] data) {
        if (isNullOrEmpty(data)) {
            return;
        } else if (containsOneElement(data)) { 
            return;
        }
        
        qsort(data, 0, data.length - 1);
    }

    private void qsort(int[] data, int min, int max) {
        
        if (max > min) {
            
            int pivot = partition(data, min, max);
            
            qsort(data, min, pivot - 1);
            qsort(data, pivot + 1, max);
        }
    }
    
    private void qsort(String[] data, int min, int max) {
        
        if (max > min) {
            
            int pivot = partition(data, min, max);
            
            qsort(data, min, pivot - 1);
            qsort(data, pivot + 1, max);
        }
    }

    private int partition(int[] data, int min, int max) {
        
        int pivot = data[max];
        
        int idx = min - 1;
        
        for (int j = min; j <= max - 1; j++) {
            
            if (data[j] <= pivot) {
                idx++;
                int temp = data[j];
                data[j] = data[idx];
                data[idx] = temp;
                
            }
        }
        
        int swap = data[idx + 1];
        data[idx + 1] = data[max];
        data[max] = swap;
        
        return idx + 1;
    }
    
    

    private int partition(String[] data, int min, int max) {
        
        String pivot = data[max];
        
        int idx = min - 1;
        
        for (int j = min; j <= max - 1; j++) {
            
            if (data[j].compareToIgnoreCase(pivot) < 0) {
                idx++;
                String temp = data[j];
                data[j] = data[idx];
                data[idx] = temp;
                
            }
        }
        
        String swap = data[idx + 1];
        data[idx + 1] = data[max];
        data[max] = swap;
        
        return idx + 1;
    }
}
