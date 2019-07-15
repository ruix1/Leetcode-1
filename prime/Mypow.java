package prime;

public class Mypow {

	public static void main(String[] args) {
		double div = myPow(2, 10);
		System.out.println("：" + div);
	}
		// TODO Auto-generated method stub
		public static double myPow(double x, int n) {
		    if(n<0) return 1/x * myPow(1/x, -(n+1));
		    if(n==0) 
		    	return 1;
		    if(n==2)
		    	return x*x;
		    if(n%2==0) 
		    	return myPow( myPow(x, n/2), 2);
		    else
		    	return x*myPow( myPow(x, n/2), 2);
		}
		
	}


