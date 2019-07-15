package prime;

import java.util.Scanner;

public class HW2Prime2 {
	
	static long two = 2;
	public static int sieve(long start, long end) {
		boolean isprime[] = new boolean[1000000000];
		boolean isprimesmall[] = new boolean[100000000];
		
		for(int i = 0 ; (long)i*i<= end; i++) {
	
			isprimesmall[i] = true; 
		}
		for(int i = 0; i <= end - start; i++) {
			isprime[i] = true;
		}
		for(int i = 2; (long)i*i <= end; i ++) {
			if(isprimesmall[i]) {
				for(int j = 2 * i; (long)j*j <= end;  j += i) {
					isprimesmall[j] = false;
				}
				for(long j = Math.max(two,(start+i-1)/i)*i; j <= end; j+=i) {
					isprime[(int)(j-start)] = false;
				}
			}
		} 
		int primenumber = 0;
		int m = (int)(end - start+1);
		for(int i = 0; i <= m; i++ ) {
			if(isprime[i]) primenumber++;
		}
		if (start==1) primenumber--;
		if (start==0) primenumber-=2;
 		return primenumber;
	}
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		while (true){
			Scanner s = new Scanner(System.in);
			long start = s.nextLong();
			long end = s.nextLong();
			System.out.print(sieve(start, end));
		}
        
	}
	
	
	

}
