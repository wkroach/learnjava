/**
 * Using a Map<String,Integer>, follow the form of
 * UniqueWords.java to create a program that counts
 * the occurrence of words in a file. Sort the
 * results using Collections.sort() with a second
 * argument of String.CASE_INSENSITIVE_ORDER (to
 * produce an alphabetic sort), and display the result.
 */
package practice21;
import java.util.*;
import java.io.*;

public class UniqueWords {
    public static void main(String[] args){
        String s =
                "I want AD from CMU MSIN I want AD from CMU MSIT-mob I want AD from CMU MCDS I want AD from CMU MSAIE I want AD from UCSD MSCS I want AD from UCLA MSCS I want AD from Gatech MSCS I want AD from Columbia MSCS I want AD from Rice MCS I want AD from UIUC MCS I want AD from Cornell Meng I want AD from UWM PMP I want AD from Umich MSCS I want AD from UCB Meng I want AD from NYU MSCS I want AD from USC MSCS";
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(s.split(" ")));
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(String ss: arrayList){
            hashMap.put(ss, hashMap.getOrDefault(ss, 0)+1);
        }
        ArrayList<String> arr = new ArrayList<String>(hashMap.keySet());
        Collections.sort(arr);
        System.out.println(hashMap);
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        for(String ss: arr){
            linkedHashMap.put(ss, hashMap.get(ss));
        }
        System.out.println(linkedHashMap);
    }
}
