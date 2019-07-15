package prime;


public class Lcm {
	public static int getGCD(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return getGCD(n, m % n);
		}
	}
	private static int getLCM(int a, int b) { 
		return a * b / getGCD(a, b);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mutile = getLCM(105, 64);
		System.out.println("最小公倍数为：" + mutile);

	}

}
