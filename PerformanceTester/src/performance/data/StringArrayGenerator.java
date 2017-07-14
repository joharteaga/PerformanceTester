
package performance.data;

import java.util.Random;

/**Generates and fills a random string array with
 * alphanumeric strings
 *
 * @author joharteaga
 */
public class StringArrayGenerator {
    private static final String available = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private Random random;

    public StringArrayGenerator() {
        this.random = new Random();
    }
    
    
    //generates psuedorandom string array to size with elements ranging
    //from length 1 - stringLength (inclusive)
    public String[] getRandomStringArray(int size, int stringLength) {
        char[] charList = available.toCharArray();
        String[] array = new String[size];
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < size; i++) {
            int currentStringLength = random.nextInt(stringLength) + 1;
            
            for (int j = 0; j < currentStringLength; j++) {
                sb.append(charList[random.nextInt(charList.length)]);
            }
            
            array[i] = sb.toString();
            sb.setLength(0);
        }
        
        return array;
    }
    
    //if no bound given, generate strings with element size up to 10
    public String[] getRandomStringArray(int size) {
        return getRandomStringArray(size, 10);
    }
    
    
}
