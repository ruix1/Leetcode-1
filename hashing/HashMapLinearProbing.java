package hashing;

	import java.io.*;
	
	/**
	 * reference:http://blog.csdn.net/zongxiao08/article/details/8607396
	 * @author ruihan
	 *
	 */

	class Data {//data
	    private int iData;// data item (key)

	    public Data(int i) {
	        iData = i;
	    }
	    public int getKey(){
	        return iData;
	    }

	}

	class HashTable{
	    private Data[] hashArray;
	    private int arraySize;
	    private Data nonItem;// the mark of the delete

	    public HashTable(int size) {
	        arraySize = size;
	        hashArray = new Data[arraySize];
	        nonItem = new Data(-1);//deleted item key is -1
	    }

	    public void displayTable(){
	        System.out.print("Table: ");
	        for(int j=0; j<arraySize; j++)
	        {
	            if(hashArray[j] != null)
	                System.out.print(hashArray[j].getKey() + " ");
	            else
	                System.out.print("** ");
	        }
	        System.out.println("");
	    }

	    public int hashFunction(int key)
	    {
	        return key % arraySize;
	    }
	    
	    public int insert(Data item){
	        int key = item.getKey();
	        int hashVal = hashFunction(key);
	        int insertCount = 1;
	        
	        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
	      
	        	++hashVal;
	            hashVal %= arraySize;
	            insertCount++;
	        }
	        hashArray[hashVal] = item;
	        return insertCount;
	    }

	    int getNullValue(){
	        int countNull = 0;
	        for(int i = 0; i < arraySize; i++){
	           if(hashArray[i]==null){
	               countNull++;
	           }
	        }
	        return countNull;
	    }

	    public Data delete(int key) {
	        int hashVal = hashFunction(key);

	        while(hashArray[hashVal] != null){
	            if(hashArray[hashVal].getKey() == key){
	                Data temp = hashArray[hashVal];
	                hashArray[hashVal] = nonItem;
	                return temp;
	            }
	            ++hashVal;
	            hashVal %= arraySize;
	        }
	        return null;
	    }

	    public Data find(int key) {
	        int hashVal = hashFunction(key);

	        while(hashArray[hashVal] != null) {
	            if(hashArray[hashVal].getKey() == key)
	                return hashArray[hashVal];
	            ++hashVal;
	            hashVal %= arraySize;
	        }
	        return null;
	    }

	}

	public class HashMapLinearProbing{
		 public static String getString() throws IOException{
		        InputStreamReader r = new InputStreamReader(System.in);
		        BufferedReader br = new BufferedReader(r);
		        String s = br.readLine();
		        return s;
		    }
		 
		    public static int getInt() throws IOException
		    {
		        String s = getString();
		        return Integer.parseInt(s);
		    }

		
	    public static void main(String[] args) throws IOException {
	        Data aData;
	        int aKey;
	        int size;
	        int n;

	        System.out.print("Enter size: ");
	        size = getInt();
	        System.out.print("Enter number of items: ");
	        n = getInt();

	        int[] count = new int[n+1];
	        int[] countTry = new int[53];
	        HashTable newHashTable = new HashTable(size);

	        for(int j=0 ; j<n; j++){
	            aKey = (int)(java.lang.Math.random()*10 );
	            aData = new Data(aKey);
	            count[j] = newHashTable.insert(aData);
	        }

	        int nullValue = newHashTable.getNullValue();
	        countTry[0] = nullValue;

	        for(int i = 1 ; i < 51 ; i++){
	            int m = 0;
	            for(int j = 0 ; j < n; j++ ){
	                if(count[j] == i){
	                    m++;
	                }
	            }
	            countTry[i] = m;
	        }

	        for(int i = 0 ; i < n; i++ ){
	            int m = 0;
	            if(count[i] > 50){
	                m++;
	            }
	            countTry[51] = m;
	        }

	        for(int i = 0; i <51 ; i++){
	                System.out.println(i + "   "+countTry[i]);
	            }
	        
	        System.out.println(">50" + "  "+countTry[51]);

	    }
	    

	}



