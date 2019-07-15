package prime;

public class ImprovedPrime {

	public static int countprime(int n){
		if(n<=1)  //小于等于1的都不是质数  
            return 0;  
        boolean[] a = new boolean[n];  
        for(int i=2; i<n; i++)  
            a[i] = true;  
        for(int i=2; i*i<n; i++){  
            if(a[i] == true){  
              for(int j=i*i; j<n; j+=i){  
                  a[j] = false;  
              }    
            }//if  
        }//for  
        int result =0;  
        for(int i=2; i<n; i++){  
            if(a[i])  
                result++;  
        }//for  
        return result;  
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countprime(100));
	}    

}

