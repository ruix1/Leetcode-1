package prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;

public class MR2 {
	private static Random rnd = new Random(); // always seed with a known value for testing
    private static BigInteger TWO = new BigInteger("2");//TWO当作2
    public static boolean millerRabin(BigInteger p, int k) {
	
	BigInteger pminus1 = p.subtract(BigInteger.ONE);//p-1
	// find out how many trailing zeros there are in p-1
	int r = pminus1.getLowestSetBit(); 
	// 去网址上看看大数类的函数用法http://www.cnblogs.com/gispathfinder/p/6193988.html?utm_source=itdadao&utm_medium=referral
	//getLowestSetBit()：返回此 BigInteger 最右端（最低位）1 比特的索引
	//（即从此字节的右端开始到本字节中最右端 1 比特和 0 比特之间的位数）
	//getLowestSetBit(8)：3   getLowestSetBit(7)：0
	BigInteger d = pminus1.shiftRight(r);
	//算数右移，4（100）右移两位为1（001）相当于除以2^2
	//这两步的含义很重要，自己可以找两个数比如7，8感受一下
	//如果p-1=8，a^8就是(a^d)^8;  如果p-1=6，a^6就是(a^d)^2,这样不断减少次方
	//我单独发了一个test,输出几个数的结果看看就明白了
	nextTrial://这个使用方法是label,参考http://blog.csdn.net/whiteotiger/article/details/6522261
	for (int i = 0; i < k; ++i) {
	    BigInteger temp;
	    BigInteger a;
	    do {   //if < 3 we have a problem
		temp = new BigInteger(pminus1.bitCount()+ 10, rnd);
		a = temp.mod(pminus1);
	    } while (a.compareTo(TWO) < 0); //false跳出循环执行下面的语句
	    // 1 < a < p-2
	    // compute a^d mod p
	    BigInteger x = a.modPow(d, p);
	    if (x.compareTo(BigInteger.ONE) == 0 || x.compareTo(pminus1) == 0)
	    continue;   //若x=1或者p-1则跳出本次循环继续下一次循环
    	for (; r > 0; r--) {
    		x = x.modPow(TWO,p); // x^TWO mod p
    		if (x.compareTo(BigInteger.ONE) == 0)
    			return false;
    		if (x.compareTo(pminus1) == 0)
    			System.out.println(x);
    			continue nextTrial;
    		
    	}
	    
	    return false;
	}
        return true;
 
    }
    public static  void main(String[] args) throws IOException {
	
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BigInteger p = new BigInteger(br.readLine());
	System.out.println(millerRabin(p, 100));

    }
	
	

}
