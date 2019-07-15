package hashing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class LinkedHashEntry { 
    public double key; 
    public String value; 
    public LinkedHashEntry next; 

    LinkedHashEntry(double key, String value) { 
          this.key = key; 
          this.value = value; 
          this.next = null; 
    } 

    public String getValue() { 
          return value; 
    } 

    public void setValue(String value) { 
          this.value = value; 
    } 

    public double getKey() { 
          return key; 
    } 

    public LinkedHashEntry getNext() { 
          return next; 
    } 

    public void setNext(LinkedHashEntry next) { 
          this.next = next; 
    } 
} 
public class hashchaining { 
	
      private final static double TABLE_SIZE = 128; 
 
      LinkedHashEntry[] table; 
 
      hashchaining() { 
            table = new LinkedHashEntry[(int)TABLE_SIZE]; 
            for (int i = 0; i < (int)TABLE_SIZE; i++) { 
                  table[i] = null; }
      } 
 
  /**    public String get(int key) { 
            int hash = (int)mod(key, TABLE_SIZE); 
            if (table[hash] == null) 
                  return null; 
            else { 
                  LinkedHashEntry entry = table[hash]; 
                  while (entry != null && entry.getKey() != key) 
                        entry = entry.getNext(); 
                  if (entry == null) 
                        return null; 
                  else 
                        return entry.getValue(); 
            } 
      } 
 */
      public void put(double key, String value) { 
            int hash = (int)mod (key,TABLE_SIZE); 
            if (table[hash] == null) {
                  table[hash] = new LinkedHashEntry(key, value);}
            else { 
                  LinkedHashEntry entry = table[hash]; 
                  while (entry.getNext() != null ) {
                        entry = entry.getNext(); 
                        
                  }
                        entry.setNext(new LinkedHashEntry(key, value)); 
            } 
      } 
 
  /**    public void remove(int key) { 
            int hash = (key mod TABLE_SIZE); 
            if (table[hash] != null) { 
                  LinkedHashEntry prevEntry = null; 
                  LinkedHashEntry entry = table[hash]; 
                  while (entry.getNext() != null && entry.getKey() != key) { 
                        prevEntry = entry; 
                        entry = entry.getNext(); 
                  } 
                  if (entry.getKey() == key) { 
                        if (prevEntry == null) 
                             table[hash] = entry.getNext(); 
                        else 
                             prevEntry.setNext(entry.getNext()); 
                  } 
            } 
      }  */
      public double getsum(String s) {
    	  char a[] = s.toCharArray();
    	  int sum = 0;
    	  for(int i = 0; i < a.length; i++) {
    		 sum += a[i] * Math.pow(7, a.length - i - 1);
    	  }
    	  return sum;
      }
      public double mod(double a, double b) {
    	  
    	  return Math.abs(a - Math.ceil(a/b)*b);
      }
      
      public static void main(String[] args) throws FileNotFoundException {
    	  hashchaining dict = new hashchaining();
    	  Scanner s = new Scanner(new BufferedReader(new FileReader("/Users/ruihan/Desktop/dict.txt")));
    	  for(int i = 0; i < 213557; i++) {
    		  String a = s.nextLine();
    	  dict.put(dict.getsum(a), a);}
    	  s.close();
    	
    	/* System.out.println(dict.table[(int)dict.mod(dict.getsum("zymotize"), TABLE_SIZE)].getKey());*/
    	 //int k = 0;
    	 for (int i = 0; i < 128; i ++) {
    		 int sum = 0;
        	 LinkedHashEntry m = dict.table[i];
             while(m!=null) {
            	 sum = sum + 1;
            	 //k=k+1;
            	 m = m.getNext();
             }
             System.out.print(i);System.out.print(" ");
            
             System.out.println(sum);
             //System.out.println(k);
    	 }
         
    	 Scanner x = new Scanner(new BufferedReader(new FileReader("/Users/ruihan/Desktop/HW8.dat")));
    	 x.nextLine();
         while(x.hasNext()) {
        	 String p = "false";
        	 String i = x.nextLine();
        	 System.out.print(i);System.out.print(" ");
        	 int q = (int)dict.mod(dict.getsum(i),TABLE_SIZE);
        	 LinkedHashEntry w = dict.table[q];
        	 while(w.getNext()!=null) {
        		
        		 if(w.getValue().equals(i)) {
        			p = "true"; 
        			break;
        		 }
        		 w = w.getNext();
        	 }
        	 System.out.println(p);
        	 
         }
      }
}
