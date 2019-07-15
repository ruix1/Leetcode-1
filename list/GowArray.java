package list;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* @ ruihan
 * 
 */
public class GowArray {

    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
         //File file = new File("HW4a.txt");
        
        File file = new File("/Users/ruihan/Desktop/HW4a.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
       
        String str = null;
        int count = 0;
        while ((str = br.readLine()) != null){
            if ((str.toString()).contains("ADD_FRONT")){
            	list = add_front(str.toString());
            }
            if ((str.toString()).contains("ADD_BACK")){
                list = add_back(str.toString());
            }
            if ((str.toString()).contains("OUTPUT") && count <= 3){
                System.out.println("OUTPUT:");
                StringBuffer str1 = new StringBuffer();
                for (int a:list) {
                    str1.append(a).append(",");
                }
                System.out.print(str1.substring(0, str1.length() - 1));
                System.out.println();
            }
            if ((str.toString()).contains("REMOVE_FRONT")){
            	list = remove_front(str.toString());
            }
            if ((str.toString()).contains("REMOVE_BACK ")){
            	list = remove_back(str.toString());
            }
          
        }
    }
    public static List<Integer> add_front(String addf){
        String[] strings;
        strings = addf.split(" ");
        strings = strings[1].split(":");
        int start  = Integer.parseInt(strings[0]);
        int step = Integer.parseInt(strings[1]);
        int end = Integer.parseInt(strings[2]);
        for(int i = start; i <= end; i += step) {
			list.add(0,i);
		}
        return list;
    }
    public static List<Integer> add_back(String addb){
        String[] strings;
        strings = addb.split(" ");
        strings = strings[1].split(":");
        int start  = Integer.parseInt(strings[0]);
        int step = Integer.parseInt(strings[1]);
        int end = Integer.parseInt(strings[2]);
        for (int i = start; i <= end; i += step){
        	list.add(i);
        }
        return list;
    }
    public static List<Integer> remove_front(String removef){
        String[] strings;
        strings = removef.split(" ");
        int a = Integer.parseInt(strings[1]);
        for (int i = 0; i < a; i++){
        	list.remove(0);
        }
        return list;
    }

    public static List<Integer> remove_back(String removeb){
        String[] strings;
        strings = removeb.split(" ");
        int a = Integer.parseInt(strings[1]);
        for (int i = 0; i < a; i++){    
        	list.remove(list.size() - 1);
        }
        return list;
    }
}
