/**
 * Modify innerclasses/Sequence.java so that it throws an
 * appropriate exception if you try to put in too many
 * elements.
 */

/**
 * 一般来说不直接使用RuntimeException，而是使用一个子类，用类名表示出错的类型
 */
package practice12;

class MyException extends RuntimeException{
    public MyException(){}
    public MyException(String s){
        super(s);
    }
}

public class Practice_12 {
    static public void main(String[] args){
        Sequence sequence = new Sequence(10);
        for(int i=0; i < 10; ++i){
            sequence.add(i);
        }
        //!sequence.add(11);
        Selector selector = sequence.selector();
        for(; !selector.end(); selector.next()){
            System.out.print(selector.current() + " ");
        }
        //!selector.next();
        System.out.println();
        Selector selector2 = sequence.reverseSelector();
        for(; !selector2.end(); selector2.next()){
            System.out.print(selector2.current() + " ");
        }
       //!selector2.next();
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
        }else{
           throw new MyException("sequence is full");
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
                }else{
                   throw new MyException("sequence has reached end");
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
                }else{
                    throw new MyException("sequence has reached head");
                }
            }
        };
    }

}
