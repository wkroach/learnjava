/**
 * Modify SimpleCollection.java to use a Set for c
 */
/**
 * Collection是所有list和set的抽象基类
 * HashSet中的元素是无序的
 */
package practice2;
import java.util.*;

public class SimpleCollection {
    static public void main(String[] args){
        Collection<Integer> c = new HashSet<Integer>();
        for(int i = 10; i >= 0; --i){
            c.add(i);
        }
        for(int i:c){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
