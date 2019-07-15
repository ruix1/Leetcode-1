package hashing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


class LinkedEntry{
	 String key;
	 int value;
	 LinkedEntry next;
	 LinkedEntry(String key,int value){
		 this.key=key;
		 this.value=value;
		 this.next=null;
	 }
  }

   

public class LinearChaining {
		   private int TABLE_SIZE;
		   private int size;
		   private LinkedEntry[]table;
		   public LinearChaining(int ts){
			   size=0;
			   TABLE_SIZE=ts;
			   table=new LinkedEntry[TABLE_SIZE];
			   for(int i=0;i<TABLE_SIZE;i++){
				   table[i]=null;
			   }
		   }

		   public int getSize(){
			   return size;
			   }
		   
		   public void makeEmpty(){
			   for(int i=0;i<TABLE_SIZE;i++){
				   table[i]=null;
			   }
		   }
		   
		   public int get(String key){
			   int hash=(myhash(key)%TABLE_SIZE);
			   if(table[hash]==null){return -1;}
			   else{
				   LinkedEntry entry=table[hash];
		
				   while(entry!=null&&!entry.key.equals(key))
					   entry=entry.next;
				   if(entry==null){return -1;}
				   else return entry.value;
			   }
		   }
		   
		   
		   public void insert(String key,int value){
			   int hash=(myhash(key)%TABLE_SIZE);
			   if(table[hash]==null)
				   table[hash]=new LinkedEntry(key,value);
			   else{
				   LinkedEntry entry=table[hash];
				   while(entry.next!=null&&!entry.key.equals(key))
					   entry=entry.next;
				   if(entry.key.equals(key))
					   entry.value=value;
				   else{ entry.next=new LinkedEntry(key,value); }
			   }
			   size++;
		   }
		  
		   
		   private int myhash(String x){
			   int hashVal=x.hashCode();
			   hashVal%=TABLE_SIZE;
			   if(hashVal<0)
				   hashVal+=TABLE_SIZE;
			   return hashVal;
		   }
		   
		   public static void main(String[] args) throws FileNotFoundException{
			   LinearChaining x=new LinearChaining(700);
				   Scanner data=new Scanner(new FileInputStream("/Users/ruihan/Desktop/hw8.dat"));
				   while(data.hasNext()) 
					   x.insert(data.next(),5);
			   }
			 
		   
	   }
	
	
	
