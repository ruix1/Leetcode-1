package prime;
//O(sqrt(n))		Ω(1)


public class Prime2 {
	
	    public static boolean isPrime(int num) {   
	       for(int i = 2; i <= Math.sqrt(num); i++) {//程序默认2是素数，当j=2时，循环不执行
	           if(num % i == 0) {
	             return false;
	           }
	       }
	       return true;
	    }
	    public static void main(String[] args) {
	        for(int j = 2; j <= 100; j++) {
	            if(Prime2.isPrime(j)) {
	                System.out.println(j + " is a prime");
	            }
	        }      
	    }
	

	
}
