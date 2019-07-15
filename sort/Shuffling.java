package sort;

	public class Shuffling {
	    public static void RadomShuffling(Object[] a)
	    {
	        for(int i=0;i<a.length;i++)
	        {
	            int r = (int)(Math.random()*(i+1));//随机数在0-i之间  Math.random为[0.0,1.0)
	            System.out.println(r);
	            exch(a,i,r);
	        }
	    }
	    private static void exch(Object[] a, int i, int j) {
	        Object temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }
	    public static void main(String[] args){
	        Object[] a={1,2,3,4,5,6,7,8,9,10};
	        RadomShuffling(a);
	        for(int i=0;i<a.length;i++)
	        {
	            System.out.print(a[i]+" ");
	        }
	    }
	}

