package prime;
//O(n*sqrt(n))

public class Countprime {
    
	public static void main(String[] args) {
		 int n=100;
		 int count=0;
			  for(int j = 2; j<n; j++){//O(n)
                  if(isPrime(j)){ //O(sqrt(n))
                	  count++;
                	  System.out.print(j+" ");
                  } 
          }
			  System.out.println(" ");
			  System.out.println(count);
  }
		
		 public static boolean isPrime(int num) {   
		       for(int i = 2; i <= Math.sqrt(num); i++) {//程序默认2是素数，当j=2时，循环不执行
		           if(num % i == 0) {
		             return false;
		           }
		       }
		       return true;
	}

}
