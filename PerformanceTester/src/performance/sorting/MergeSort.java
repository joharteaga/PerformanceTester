
package performance.sorting;

/**
 *
 * @author joharteaga
 */
public class MergeSort implements AlgorithmInterface {

    @Override
    public void sort(int[] data) {
        if (isNullOrEmpty(data)) {
            return;
        } else if (containsOneElement(data)) { 
            return;
        }
        
        int min = 0;
        int max = data.length - 1;
        
        runSort(data, min, max);
        
    }

    @Override
    public void sort(String[] data) {
        if (isNullOrEmpty(data)) {
            return;
        } else if (containsOneElement(data)) { 
            return;
        }
        
        int min = 0;
        int max = data.length - 1;
        
        runSort(data, min, max);
    }

    private void runSort(int[] data, int min, int max) {
        
        if (max > min) {
            int mid = (min + max) / 2;
            
            runSort(data, min, mid);
            runSort(data, mid+1, max);
            merge(data, min, mid, max);
        }
        
        
        
    }

    private void merge(int[] data, int min, int mid, int max) {
        int[] left = new int[mid - min +1];
        int[] right = new int[max - mid];
        
        for (int i = min, j = 0; i < mid+1; i++, j++) {
            left[j] = data[i];
        }
        for (int i = mid+1, j = 0; i < max+1; i++, j++) {
            right[j] = data[i];
        }
        
        int leftIndex = 0;
        int rightIndex = 0;
        int dataIndex = min;
        
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                data[dataIndex] = left[leftIndex];
                leftIndex++;
                dataIndex++;
            } else {
                data[dataIndex] = right[rightIndex];
                rightIndex++;
                dataIndex++;
            }
        }
        
        while (leftIndex < left.length) {
            data[dataIndex] = left[leftIndex];
            leftIndex++;
            dataIndex++;
        }
        
        while (rightIndex < right.length) {
            data[dataIndex] = right[rightIndex];
            rightIndex++;
            dataIndex++;
        }
        
    }

    private void runSort(String[] data, int min, int max) {
        
        if (max > min) {
            int mid = (min + max) / 2;
            
            runSort(data, min, mid);
            runSort(data, mid+1, max);
            merge(data, min, mid, max);
        }
    }

    private void merge(String[] data, int min, int mid, int max) {
        String[] left = new String[mid - min +1];
        String[] right = new String[max - mid];
        
        for (int i = min, j = 0; i < mid+1; i++, j++) {
            left[j] = data[i];
        }
        for (int i = mid+1, j = 0; i < max+1; i++, j++) {
            right[j] = data[i];
        }
        
        int leftIndex = 0;
        int rightIndex = 0;
        int dataIndex = min;
        
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareToIgnoreCase(right[rightIndex]) < 0) {
                data[dataIndex] = left[leftIndex];
                leftIndex++;
                dataIndex++;
            } else {
                data[dataIndex] = right[rightIndex];
                rightIndex++;
                dataIndex++;
            }
        }
        
        while (leftIndex < left.length) {
            data[dataIndex] = left[leftIndex];
            leftIndex++;
            dataIndex++;
        }
        
        while (rightIndex < right.length) {
            data[dataIndex] = right[rightIndex];
            rightIndex++;
            dataIndex++;
        }
    }
    
}
