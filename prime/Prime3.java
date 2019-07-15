package prime;



public class Prime3 {
	public static void countPrimes(int num) {
		
      // long begin = System.currentTimeMillis();
        boolean[] array = new boolean[1000000000];
    //    for (int i = 0; i < num; i=i+2) {//去偶数
           // array[i]=false;
       // }
        for (int i = 2; i < num; i++) {//留奇数
            array[i]=true;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (array[ i]) {
                for (int j = i + i; j < num; j = j + i) {
                    array[ j] = false;
                }
            }
        }
        int count = 0;
        for (boolean b : array) {
            if (b) {
                count++;
            }
        }
       //long end = System.currentTimeMillis();
        System.out.println("total=" + count );
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		countPrimes(3000);

	}

}
