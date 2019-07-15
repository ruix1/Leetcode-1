package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) throws Exception {
		File file = new File("/Users/ruihan/Desktop/hw2a.dat");

		FileInputStream FileInutStream = new FileInputStream(file);

		byte[] b = new byte[(int) file.length()];
		FileInutStream.read(b);

		String str = new String(b);
		System.out.println(str);
		String[] number = str.split(" ");
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}

		int[] temp = new int[number.length];
        qucikSort(temp, 0, temp.length - 1);
		for (int i = 0; i < number.length; i++) {
			temp[i] = Integer.parseInt(number[i]);
			
		//	System.out.println(Arrays.toString(temp));
			System.out.print(temp[i] + " ");
		}
		FileInutStream.close();
	}

	// qucikSort(a, 0, a.length-1);
	// FileReader fs = new FileReader(".dat");
	// File file =new File("hw2a.dat");
	// FileInputStream FileInutStream=new FileInputStream(file);
	// System.out.println(Arrays.toString(a));
	// }
	/**
	 * public static void read2() throws IOException{ File file =new
	 * File("hw2a.dat"); FileInputStream FileInputStream=new
	 * FileInputStream(file); int content=0; while((content =
	 * FileInputStream.read())!=-1){ System.out.print((char)content); }
	 * FileInputStream.close(); }
	 **/
	public static void qucikSort(int[] a, int low, int high) {

		if (a.length <= 1) {
			return;
		}
		if (low >= high) {
			return;
		}

		int left = low;
		int right = high;

		// int tmp = a[left];//pivot
		int tmp = a[left];

		while (left < right) {
			while (left < right && a[right] >= tmp) {
				right--;
			}
			a[left] = a[right];
			while (left < right && a[left] <= tmp) {
				left++;
			}
			a[right] = a[left];
		}
		a[left] = tmp;// ?将基准元素放置到最后的正确位置上
		qucikSort(a, low, left - 1);// left先在走到基准上
		qucikSort(a, left + 1, high);

	}
}
