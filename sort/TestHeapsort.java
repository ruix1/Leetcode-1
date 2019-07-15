package sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestHeapsort {
	/**
	 * @author ruihan 
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException{
		InputStream file = new FileInputStream("/Users/ruihan/Desktop/hw2b.dat");  
	       BufferedReader reader = new BufferedReader(new InputStreamReader(file));  
	        String str = null; 
	        str = reader.readLine(); 
	        while ((str=reader.readLine())!= null){
	        	    str = reader.readLine(); 
	                int[] arr = storeToArray(str);
	              sort(arr);

	                for (int i = 0; i < arr.length; i++){
	                    System.out.print(arr[i] + " ");
	                }
	                
	              System.out.println();
	       }
	         
	        file.close();  
	       
		 }
		
		
		public static int[] storeToArray(String str){
	        StringTokenizer tokens = new StringTokenizer(str, " ");
	        int[] a = new int[tokens.countTokens()];
	        int index = 0;
	        while(tokens.hasMoreTokens()){
	            a [index] = Integer.parseInt(tokens.nextToken());
	            index++;
	        }
	        return a;
	    }

	
	public static void buildMaxHeap(int [] array) {
	    int i,
	      iParent = (int) (Math.floor(array.length / 2) - 1);
	    for (i = iParent; i >= 0; i--) {
	      maxHeapify(array, i, array.length);
	    }
	  }
	public static int[] sort(int [] array) {
	    buildMaxHeap(array);
	    for (int  i = array.length - 1; i > 0; i--) {
	      swap(array, 0, i);
	      maxHeapify(array, 0, i);
	    }
	    return array;
	  }
	  

	public static void maxHeapify(int[] arr, int index, int heapSize) {
		  int  iMax, iLeft, iRight;
		  while (true) {
		    iMax = index;
		    iLeft = 2 * index + 1;
		    iRight = 2 * (index + 1);
		    if (iLeft < heapSize && arr[index] < arr[iLeft]) {
		      iMax = iLeft;
		    }
		    if (iRight < heapSize && arr[iMax] < arr[iRight]) {
		      iMax = iRight;
		    }
		    if (iMax != index) {
		      swap(arr, iMax, index);
		      index = iMax;
		    } else {
		      break;
		    }
		  }
		}
	public static void swap(int [] array, int i, int j) {
		int temp = array[i];
		  array[i] = array[j];
		  array[j] = temp;
		}

}
