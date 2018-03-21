/**
 * Modify innerclasses/Sequence.java so you
 * can add any number of elements to it
 */
package practice3;
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
    public Selector selector(){
        return new Selector() {
            private int i = 0;
            @Override
            public boolean end() {
                return i == items.size();
            }

            @Override
            public Object current() {
                return items.get(i);
            }

            @Override
            public void next() {
                if(i < items.size()){
                    i++;
                }
            }
        };
    }
    static public void main(String[] args){
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 15; ++i){
            sequence.add(Integer.toString(i));
        }
        for(Selector selector = sequence.selector(); !selector.end(); selector.next()){
            System.out.print(selector.current() + " ");
        }
    }
}
