package sort;

public class SelectionSort {
	public static void main(String[] args) {
		
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
	    int temp=0;
	    for(int i=0;i<a.length-1;i++){  
	    	int minIndex=i;
	    	int minValue=a[minIndex];
	        for(int j=i+1;j<a.length;j++){  
	         if(a[j]>minValue){
	        	minIndex=j;
	        	minValue=a[minIndex]; 
	         }  
	        } 
	            temp=a[i];  
	            a[i]=minValue;  
	            a[minIndex]=temp;  
	        
	    }  
	    for(int i=0;i<a.length;i++)  
	        System.out.print(a[i]+" ");     
	}  


}
