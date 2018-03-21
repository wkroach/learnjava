/**
 * Implement reverseSelector() in Sequence.java
 */
/**
 * 用匿名内部类实现数组的正向，反向迭代器
 */
package practice22;

public class Practice_22 {
    static public void main(String[] args){
        Sequence sequence = new Sequence(10);
        for(int i=0; i < 10; ++i){
            sequence.add(i);
        }
        for(Selector selector = sequence.selector(); !selector.end(); selector.next()){
            System.out.print(selector.current() + " ");
        }
        System.out.println();
        for(Selector selector = sequence.reverseSelector(); !selector.end(); selector.next()){
            System.out.print(selector.current() + " ");
        }
    }
}

interface Selector{
    boolean end();
    Object current();
    void next();
}
class Sequence{
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if(next < items.length){
            items[next++] = x;
        }
    }
    public Selector selector(){
        return new Selector() {
            private int i = 0;

            @Override
            public boolean end(){
                return i == items.length;
            }

            @Override
            public Object current() {
                return items[i];
            }

            @Override
            public void next() {
               if(i < items.length){
                   i++;
                }
            }
        };
    }

    public Selector reverseSelector(){
        return new Selector() {
            private int i = items.length-1;

            @Override
            public boolean end() {
                return i == -1;
            }

            @Override
            public Object current() {
                return items[i];
            }

            @Override
            public void next() {
                if(i > -1){
                    i--;
                }
            }
        };
    }

}
