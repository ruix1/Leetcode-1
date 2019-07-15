package searching;
/**
 * 
 * @author ruihan
 *
 */

public class Linear {
	
	public static int Linear_Search(int[] data, int target) {  
        if (data == null || data.length <= 0) {  
            return -1;  
        }  
        for (int i = 0; i < data.length; i++) {  
            if (data[i] == target) {  
                return i;  
            }  
        }  
        return -1;  
    }  
}
