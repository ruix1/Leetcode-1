package list;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class growArray {
	
		public static void main(String[] args) throws FileNotFoundException{
			growArray list1 = new growArray();
			//Scanner s = new Scanner(new FileReader("/Users/ruihan/Desktop/HW4a.txt"));
			Scanner s = new Scanner(new BufferedReader(new FileReader("/Users/ruihan/Desktop/HW4a.txt")));
			String str;
			while(s.hasNext()){
				str=s.next();
				switch(str){
				case"ADD_FRONT":
					growArray list2 = new growArray();
					while(s.hasNextInt()){
						int n1=s.nextInt();
						list2.addEnd(n1);
					}
					list1.addStart(list2);
					list2=null;
					continue;
				case"ADD_BACK":
					while(s.hasNextInt()){
						int n2=s.nextInt();
						list1.addEnd(n2);
					}
					continue;
				case"REMOVE_FRONT":
					while(s.hasNextInt()){
						int n3=s.nextInt();
						for(int i=1;i<=n3;i++){
							list1.removeStart();
						}
					}
					continue;
				case"REMOVE_BACK":
					while(s.hasNextInt()){
						int n4=s.nextInt();
						for(int i=1;i<=n4;i++){
							list1.removeEnd();
						}
					}
					continue;
				case"OUTPUT": 
					int len=list1.size();
					for (int i = 0; i < len; i++){
						System.out.print(list1.get(i)+" ");
					}
					System.out.println("");
					continue;
				}
			}
			s.close();
		}
		
		private int[] p;
		private int sized;
		private int used;
		
		public void grow(){
			sized=2*sized;
		}
		public growArray() {
			sized=1;
			p=new int[sized];
			used=0;
		}
		public void addStart(growArray r) {
			int[] temp = p;
			used=r.used+used;
			while(used>=sized){
				grow();
			}
			p=new int[sized];
			for(int i=0;i<r.used;i++){
				p[i]=r.p[i];
			}
			for(int i=r.used;i<used;i++){
				p[i]=temp[i-r.used];
			}
		}

		public void addEnd(int v) {
			int[] temp = p;
			if(used==sized){
				grow();
				p = new int[sized];
				for (int i = 0; i < used; i++)
					p[i] = temp[i];
				
			}
			p[used] = v;
			used++;
		}
		
		public void removeStart() {
			int[] temp = p;
			for (int i = 0; i < temp.length-1; i++){
				p[i] = temp[i+1];
			}
			used--;
		}
		
		public void removeEnd() {
			used--;
		}
		
		public int get(int pos)  {
			return p[pos];
		}
		
		int size() {
			return used;
		}

	}

	


