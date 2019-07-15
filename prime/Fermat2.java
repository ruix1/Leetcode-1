package prime;

import java.math.BigInteger;
import java.util.Random;

public class Fermat2 {
	private static Random rnd = new Random();
	public static boolean fermatTest(BigInteger p, int k) {
		BigInteger pminus1 = p.subtract(BigInteger.ONE);//pminus1=p-1
		BigInteger result=new BigInteger("0");
		for (int i = 0; i < k; ++i) {   
			//这里的k表示循环次数，因为根据费马定理是一个充分条件
			//它的前提是p为素数，而这个算法是假设a^p-1同余1(mod p)成立
			//有可能求出的p不是素数，举例：2^340mod341余数也是1，但是341不是素数
			//所以基于以上问题，我们加入多层循环，多次取a使得这个可能性降低
			//所以这个算法求出的是：（重点）p可能是素数，而不是一定的，不然也不有miller rabin算法
		BigInteger a;
			do {
				a = new BigInteger(p.bitCount(), rnd);
				//BigInteger(int numBits, Random rnd)   
				//构造一个随机生成的 BigInteger，它是在 0 到 (2^numBits - 1)（包括）范围内均匀分布的值
			} while (a.compareTo(p) >= 0 || a.compareTo(BigInteger.ONE) <= 0);
			//这个就是根据定理a的范围在1到p,BigInteger.ONE就当作1
			result=a.modPow(pminus1, p);
			if (!result.equals(BigInteger.ONE)) 
				//if (a.modPow(p, p).compareTo(a) != 0)
				//如果a^p-1除以p的余数不等于1，说明不是素数，不满足定理
			  return false;
		}
		return true;
	}

public static void main(String[]args) {
		BigInteger p1 = new BigInteger("17");
		System.out.println(fermatTest(p1, 2));

		BigInteger p2 = new BigInteger("42");
		System.out.println(fermatTest(p2, 2));
		BigInteger p3 = new BigInteger("341");
		System.out.println(fermatTest(p3, 2));
	}

}


