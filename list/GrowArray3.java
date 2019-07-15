package list;
import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.lang.reflect.InvocationTargetException;
	import java.util.ArrayList;
	import java.util.Scanner;

public class GrowArray3 {
	


	
	    static ArrayList<Integer> list = new ArrayList<Integer>(); 
		public static void ADD_FRONT(int start, int step, int end) {
			for(int i = start; i <= end; i += step) {
				list.add(0,i);
			}
		}
		public void ADD_BACK(int start, int step, int end) {
			for(int i = start; i <= end; i += step) {
				list.add(i);
			}
		}
		
		public void REMOVE_FRONT(int n){
			for(int i = 0; i < n; i++) {
				list.remove(0);
			}
		}
		
		public void REMOVE_BACK(int n) {
			for(int i = 0; i < n; i ++) {
				list.remove(list.size() - 1);
			}
			
		}
		
		public static void OUTPUT() {
			
			System.out.println(list);
		}
		
		//«∞√Ê «Àƒ∏ˆ∑Ω∑®
		public void test(String s) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

			try {
				Class clazz2 = new GrowArray3().getClass();  //’‚∏ˆæÕ «∞—clazz2∑µªÿ≥…‘≠ ºµƒclass ’‚—˘≤≈ƒ‹”√getMethord∑Ω∑®
				                      //»Áπ˚÷±Ω”Growarray4a clazz2 = new Growarray4a() ÷ªƒ‹÷±Ω” π”√±æ∂‘œÛ÷–µƒ∑Ω∑® ≤ªƒ‹µ˜”√getMethord£®£©
			
				
				String[] single = s.split("\\s+");  //˝
				String func = single[0];  //
			if(single.length<2) {
			
				clazz2.getMethod(func,null).invoke(clazz2.newInstance(),null);
				
			}else {
				String[] num = single[1].split(":");

			if(num.length==1) {
			
				clazz2.getMethod(func,int.class).invoke(clazz2.newInstance(),Integer.parseInt(num[0]));				
				
			}else if(num.length==3) {
				clazz2.getMethod(func,int.class,int.class,int.class).invoke(clazz2.newInstance(),Integer.parseInt(num[0]),Integer.parseInt(num[1]),Integer.parseInt(num[2]));
					
				}
				//clazz2.getMethod("OUTPUT",null).invoke(clazz2.newInstance(),null);
				
			}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// Õ®π˝º”‘ÿ∆˜…˙≥…Demoµƒ◊÷Ω⁄¬Î
			
			
		}
		
		
		
		public static void main(String[] args) throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
	         Scanner s = null;
	         
	         GrowArray3 g = new GrowArray3();
	       
	         
	         Scanner scanner = s = new Scanner(new BufferedReader(new FileReader("HW4a.txt")));
	        
	     
	         
	         while(s.hasNext()) {
	        	
	        	
	        	g.test(s.nextLine()); 
	        	 
	         }
	         
		}
			   
			   
	}


	


