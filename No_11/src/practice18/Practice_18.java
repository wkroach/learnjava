/**
 * Fill a HashMap with key-value pairs. Print the results
 * to show ordering by hash code. Extract the pairs, sort
 * by key, and place the result into a LinkedHashMap.
 * Show that insertion order is maintained.
 */

/**
 * LinkedHashmap和LinkedHashSet可以维护插入的顺序
 */
package practice18;

import java.util.*;

public class Practice_18 {
    static public void main(String[] args){
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        for(int i = 10; i > 0; --i){
            hashMap.put(i*i, String.valueOf(i*i));
        }
        System.out.println(hashMap);
        Integer[] arr = hashMap.keySet().toArray(new Integer[0]);
        Arrays.sort(arr);
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
        for(int i = arr.length-1; i >= 0; --i){
            linkedHashMap.put(arr[i], hashMap.get(arr[i]));
        }
        System.out.println(linkedHashMap);
    }
}
