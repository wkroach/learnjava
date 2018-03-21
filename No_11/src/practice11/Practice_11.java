/**
 * Write a method that uses an Iterator to step
 * through a Collection and print the toString()
 * of each object in the container. Fill all the
 * different types of Collections with objects and
 * apply your method to each container.
 */
package practice11;

import java.util.*;

public class Practice_11 {
    static public void loop(Iterator<Object> iteraotr){
        for(;iteraotr.hasNext();){
            System.out.print(iteraotr.next()+ " ");
        }
        System.out.println();
    }
    static public void main(String[] args){
        Collection[] containers = {
                new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)),
                new LinkedList<String>(Arrays.asList("123","456","789")),
                new HashSet<Double>(Arrays.<Double>asList(7.0, 8.0, 9.0, 10.0))
        };
        loop(containers[0].iterator());
        loop(containers[1].iterator());
        loop(containers[2].iterator());
    }
}

