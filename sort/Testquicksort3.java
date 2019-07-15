package sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @author ruihan
 *
 */

public class Testquicksort3 {
	public static void main(String[] args) throws IOException { 
	
       InputStream file = new FileInputStream("/Users/ruihan/Desktop/hw2a.dat");  
       BufferedReader reader = new BufferedReader(new InputStreamReader(file));  
        String str = null; 
        str = reader.readLine(); 
        while ((str=reader.readLine())!= null){
        	 str = reader.readLine(); 
                int[] arr = storeToArray(str);
                qucikSort(arr, 0, arr.length - 1);
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
	
	public static void qucikSort(int[] array, int low, int high){

        if (array.length <= 0 || array == null){
            return ;
        }
        if (low >= high){
            return ;
        }

        int left = low;
        int right = high;

        int temp = array[left];//pivot

        while (left < right){
            while (left < right && array[right] >= temp){
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= temp){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        qucikSort(array, low, left - 1);
        qucikSort(array, left + 1, high);
    }
}