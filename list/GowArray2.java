package list;


import java.util.ArrayList;


public class GowArray2 {
	
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		public ArrayList<Integer> ADD_FRONT(int start,int step,int end){
			int i=(end-start)/step;
			while (start<end){
				list.add(start+step*i);
				i--;
				//end-=step;
				end=end-step;
			}
			return list;
		}
		public ArrayList<Integer> ADD_BACK(int start,int step,int end){
			int i=0;
			while (start<=end){
				list.add(start+step*i);
				i++;
				end-=step;
			}
			return list;
		}
		public ArrayList<Integer> REMOVE_FRONT (int n){
			for (int i=n-1; i>=0;i--){
				list.remove(i);
			}
			return list;
		}
		public ArrayList<Integer> REMOVE_BACK (int n){
			int length=list.size();
			for (int i=length-1; i>=length-n;i--){
				list.remove(i);
			}
			return list;
		}
		


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			GowArray2 g=new GowArray2();
			g.ADD_FRONT(1, 2, 10);
			System.out.println(g.ADD_BACK(5, 5, 25));
			g.REMOVE_FRONT(2);
			System.out.println(g.REMOVE_BACK(2));
			
			
		}

	}



