package prime;

import java.math.BigInteger;
import java.util.Random;

public class Fermat {

	
		 	private static Random rnd = new Random(0);
		 	
		 	public static boolean fermatTest(BigInteger p, int k) {
		 		BigInteger pminus1 = p.subtract(BigInteger.ONE);
		 		for (int i = 0; i < k; ++i) {
		 			BigInteger a;
		 			do {
		 				a = new BigInteger(p.bitCount(), rnd);
		 			} while (a.compareTo(p) >= 0 || a.compareTo(BigInteger.ONE) <= 0);
		 			// invariant: 1 < a < p
		 			//			if (a.modPow(pminus1), p).compareTo(BigInteger.ONE) != 1)
		 			if (a.modPow(p, p).compareTo(a) != 0)
		 			  return false;
		 		}
		 		return true;
		 	}
		 
		 	public static void main(String[]args) {
				BigInteger p1 = new BigInteger("17");
		 		System.out.println(fermatTest(p1, 2));
		 
		 		BigInteger p2 = new BigInteger("42");
		 		System.out.println(fermatTest(p2, 2));
		 
		 		BigInteger p3 = new BigInteger("60977817398996785");
		 		System.out.println(fermatTest(p3, 2));
		 	}
		 
		 }

