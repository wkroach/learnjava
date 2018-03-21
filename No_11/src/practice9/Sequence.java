/**
 * Modify innerclasses/Sequence.java so that
 * Sequence works with an Iterator instead of a
 * Selector.
 */
package practice9;

import java.util.*;

interface Selector{
    boolean end();
    Object current();
    void next();
}
public class Sequence {
    private List items;
    private int next = 0;
    public Sequence(int size){
       items = new ArrayList(size);
    }
    public void add(Object x){
        if(next < items.size()){
            items.set(next++, x);
        } else{
            items.add(x);
            next++;
        }
    }
    public Iterator<Object> iterator() {
        return items.iterator();
    }
    static public void main(String[] args){
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 15; ++i){
            sequence.add(Integer.toString(i));
        }
        for(Iterator<Object> iterator = sequence.iterator(); iterator.hasNext();){
            System.out.print(iterator.next() + " ");
        }
    }
}
