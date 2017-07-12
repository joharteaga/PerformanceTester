
package performance.sorting;

/**
 *
 * @author joharteaga
 */
public interface AlgorithmInterface {
    
    public void sort(int[] data);
    
    public void sort(String[] data);
    
    default <T> boolean isNullOrEmpty(T[] data) {
        return (data == null || data.length == 0);
    }
    
    default boolean isNullOrEmpty(int[] data) {
        return (data == null || data.length == 0);
    }
    
    default <T> boolean containsOneElement(T[] data) {
        return (data.length == 1);
    }
    
    default boolean containsOneElement(int[] data) {
        return (data.length == 1);
    }
    
}
