package sort;

public class InsertSort {
	public static void main(String[] args){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,51};
		
		for(int i=1;i<a.length;i++){
			if(a[i]<a[i-1]){
			int temp=a[i];
			for (int j=i-1;j>=0;j--){
				if(a[j]>temp){
					a[j+1]=a[j];

				}
				else{
					a[j+1]=temp;
					//break;
				}
			}
			
		}
		}
		
		 for(int i=0;i<a.length;i++)
			 System.out.print(a[i]+" ");     
		
	} 

}
