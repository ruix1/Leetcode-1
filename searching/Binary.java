package searching;
/**
 * In computer science, binary search, also known as half-interval search,
 *logarithmic search,or binary chop, is a search algorithm that finds the position of a target value within a sorted array.
 *  Binary search compares the target value to the middle element of the array;
 *  if they are unequal,
 *  the half in which the target cannot lie is eliminated and the search continues on the remaining half until it is successful.
 *   If the search ends with the remaining half being empty, 
 * the target is not in the array.
 * @author ruihan
 *O(log2 n)
 */

public class Binary {
	 public static int binarySearch(int[] data, int key) {  
	        if (data == null || data.length <= 0) {  
	            return -1;  
	        }  
	        int low = 0;  
	        int high = data.length - 1;  
	        while (low < high) {  
	            int mid = (low + high) / 2;  
	            if (data[mid] == key) {  
	                return mid;  
	            } else if (data[mid] > key) {  
	                high = mid - 1;  
	            } else if (data[mid] < key) {  
	                low = mid + 1;  
	            }  
	        }  
	        return -1;  
	    }  
	  
	    /** 
	     * 二分查找的前提是有序,递归 
	     *  
	     * @param data 
	     * @param key 
	     * @return 
	     */  
	    public static int recursiveBinarySearch(int[] data, int low, int high, int key) {  
	        if (data == null || data.length <= 0) {  
	            return -1;  
	        }  
	        if (low < high) {  
	  
	            int mid = (low + high) / 2;  
	            if (data[mid] == key) {  
	                return mid;  
	            } else if (data[mid] > key) {  
	                recursiveBinarySearch(data, low, mid - 1, key);  
	            } else if (data[mid] < key) {  
	                recursiveBinarySearch(data, mid + 1, high, key);  
	            }  
	  
	        }  
	        return -1;  
	    }  
}
