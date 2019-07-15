package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestQuickSort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		    File file =new  File("/Users/ruihan/Desktop/hw2a.dat");
			 
			// BufferedReader reader = new BufferedReader(new FileReader(file));
		   
		      //  String str = null;
		       // while (true) {  
		            //str = reader.readLine();  
		          //  if(str!=null)  
		          //      System.out.println(str);  
		         //   else  
		         //       break;  
		     //   }  
		       
		   BufferedReader  reader =  new BufferedReader(new FileReader(file));
			   
	       String str = null;
	        str = reader.readLine();
	        while ((str = reader.readLine()) != null){
	        	str = reader.readLine();
	                int[] arr = storeToArray(str);
	                qucikSort(arr, 0, arr.length - 1);
	                for (int i = 0; i < arr.length; i++){
	                    System.out.print(arr[i] + " ");
	                }
	               
	                System.out.println();}
		

	}
	
	public static void read2() throws IOException{ 
		 File file =new  File("/Users/ruihan/Desktop/hw2a.dat");
		// FileInputStream FileInputStream=new FileInputStream(file);
		 
		 BufferedReader buf = new BufferedReader(new FileReader(file));
	        String tmp = null;
	        System.out.println("INPUT:");
	        while ((tmp = buf.readLine()) != null){
	            System.out.println(tmp.toString());

	        }
	       
	       
	        buf = new BufferedReader(new FileReader(file));
	        tmp = null;
	        tmp = buf.readLine();
	        while ((tmp = buf.readLine()) != null){
	                tmp = buf.readLine();
	                int[] arr = storeToArray(tmp);
	                qucikSort(arr, 0, arr.length - 1);
	                for (int i = 0; i < arr.length; i++){
	                    System.out.print(arr[i] + " ");
	                }
	               
	                System.out.println();
	        }
		
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

        int tmp = array[left];//pivot

        while (left < right){
            while (left < right && array[right] >= tmp){
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= tmp){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        qucikSort(array, low, left - 1);
        qucikSort(array, left + 1, high);
    }

}




