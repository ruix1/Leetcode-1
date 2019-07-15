package list;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author ruihan
 *
 */

class DoubleLinkedList{
    
    DoubleLinkedList pre = this;
    DoubleLinkedList next = this;
    Object value;
    
    DoubleLinkedList(Object value){
        this.value = value;
    }
}

public class HW4b {
	    private static DoubleLinkedList head = new DoubleLinkedList(null);
	    private static DoubleLinkedList tail = head;
	    private static int length;

	    public static void main(String[] args) throws IOException {
	        File file = new File("HW4b.txt");
	        BufferedReader data = new BufferedReader(new FileReader(file));
	        String temp = null;
	        int count = 0;
	        while ((temp = data.readLine()) != null) {
	            if ((temp.toString()).contains("ADD_FRONT")) {
	                List<Integer> result;
	                result = split_data(temp.toString());
	                for (int i = 0; i < result.size(); i++){
	                    addFirst(result.get(i));
	                }
	                //print();
	            }
	            if ((temp.toString()).contains("ADD_BACK")){
	                List<Integer> result;
	                result = split_data(temp.toString());
	                for (int i = 0; i < result.size(); i++){
	                    addback(result.get(i));
	                }
	                //print();
	            }
	            if ((temp.toString()).contains("OUTPUT") && count <= 3){
	                System.out.println("OUTPUT:");
	                print();
	                System.out.println();
	            }
	            if ((temp.toString()).contains("REMOVE_FRONT")){
	                String[] strings;
	                strings = (temp.toString()).split(" ");
	                int a = Integer.parseInt(strings[1]);
	                removeFront(a);
	                //print();
	            }
	            if ((temp.toString()).contains("REMOVE_BACK")){
	                String[] strings;
	                strings = (temp.toString()).split(" ");
	                int a = Integer.parseInt(strings[1]);
	                removeBack(a);
	                //print();
	            }
	            if ((temp.toString()).contains("OUTPUT") && count > 3){
	                System.out.println("OUTPUT:");
	                print();
	                System.out.println();
	            }


	            count++;

	        }
	    }

	    public static List<Integer> split_data(String add_f){
	        List<Integer> result = new ArrayList<Integer>();
	        String[] strings;
	        strings = add_f.split(" ");
	        strings = strings[1].split(":");
	        int start  = Integer.parseInt(strings[0]);
	        int step = Integer.parseInt(strings[1]);
	        int end = Integer.parseInt(strings[2]);
	        int count = (end - start)/step + 1;
	        int endReal = start + (count - 1)*step;
	        for (int i = start; i <= endReal; i += step){
	            result.add(i);
	        }
	        return result;
	    }


	    public static void addFirst(Object value) {
	       
	    	DoubleLinkedList Node = new DoubleLinkedList(value);
	        if (head == null){
	            return;
	        }
	        if (head.next == null){
	            head.next = Node;
	            Node.pre = head;
	            tail = head.next;
	            length++;
	        }
	        else {
	        	Node.pre = head;
	        	Node.next = head.next;
	        	Node.next.pre = Node;
	        	Node.pre.next = Node;
	            tail = tail.next;
	            length++;
	        }
	       }
	    

	    public static void addback(Object value){
	        DoubleLinkedList Node = new DoubleLinkedList(value);
	        if (head == null){
	            return;
	        }
	        if (head.next == null){
	            head.next = Node;
	            Node.pre = head;
	            tail = head.next;
	            length++;
	        }
	        else {
	            tail.next = Node;
	            Node.pre = tail;
	            tail = tail.next;
	            length++;
	        }
	    }
	   
	    public static void removeFront(int num){
	        DoubleLinkedList Node = head;
	        Node = Node.next;
	        Node.pre=null;
	    }

	    public static void removeBack(int num){
	           tail = tail.pre;
	           tail.next = null;
	           length--;
	    }

	    public static void print(){
	        DoubleLinkedList cur = head;
	        StringBuffer str = new StringBuffer();
	        for (int i = 0; i < length; i++){
	            str.append(cur.next.value).append(",");
	            cur = cur.next;
	        }
	        System.out.print(str.substring(0, str.length() - 1));
	    }
	}


	//Node class
	