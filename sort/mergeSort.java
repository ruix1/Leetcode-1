package sort;

import java.util.Arrays;

public class mergeSort {

	public static void main(String[] args) {
		int[] a = {1,2,3,554,78,5,6,67,67};
		System.out.println(Arrays.toString(mergeSort(a)));

	}
	
	public static int[] mergeSort(int[] array){
		if(array.length <= 1){
			return array;
		}
		int num = array.length >> 1;
		// x>>1 是位运算中的右移运算, 表示右移一位, 等同于x除以2再取整, 即 x>>1 == Math.floor(x/2) .


		int[] left = Arrays.copyOfRange(array, 0, num);
		int[] right = Arrays.copyOfRange(array, num, array.length);
		
		return merge(mergeSort(left), mergeSort(right));
		
	}
	public static int[] merge(int[] left, int[] right){
		int[] result  = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < left.length && j < right.length){
			if(left[i] <= right[j]){
				result[k++] = left[i++];
			}else{
				result[k++] = right[j++];
			}
		}
		while(i < left.length){
			result[k++] = left[i++];
		}
		while(j < right.length){
			result[k++] = right[j++];
		}
		return result;
	}
}
