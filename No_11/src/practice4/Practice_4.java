/**
 * Create a generator class that produces String objects
 * with the names of characters from your favorite
 * movie each time you call next(), and then loops
 * around to the beginning of the character list
 * when it runs out of names. Use this generator to
 * fill an array, an ArrayList, a LinkedList, a
 * HashSet, a LinkedHashSet, and a TreeSet, then
 * print each container.
 */

package practice4;

import java.util.*;

public class Practice_4 {
    static public void main(String[] args){
        //java不支持泛型数组
        //!Collection<String>[] collections
        Collection[] collections = {new ArrayList<String>(),
                                    new LinkedList<String>(),
                                    new HashSet<String>(),
                                    new LinkedHashSet<String>(),
                                    new TreeSet<String>()};
        for(int i = 0; i < 100; ++i){
            Collection<String> collection = collections[i%collections.length];
            collection.add(Generator.next());
        }
        for(Collection<String> collection: collections){
            System.out.println(collection);
        }
    }
}

class Generator{
    static private int index = 0;
    static private String[] nameSet={"Luke","Yuda","Black Knight","Sky Walker","Han Solo"};
    static public String next(){
       return nameSet[(index++)%nameSet.length];
    }
}

