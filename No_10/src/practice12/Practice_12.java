/**
 * Repeat Exercise 7 using an anonymous inner class.
 */

package practice12;

public class Practice_12 {
    static public void main(String[] args){
        Outer outer = new Outer();
        System.out.println(outer);
        outer.outerFun(2);
        System.out.println(outer);
    }
}

interface TestInterface{
   void changeI(int i);
   void innerFun();
}

class Outer {
    private int i = 0;

    @Override
    public String toString() {
        return new Integer(i).toString();
    }

    private void fun() {
        System.out.println("Outer fun()");
    }

    public void outerFun(int i) {
        TestInterface inner = getInner();
        inner.changeI(i);
        inner.innerFun();
    }

    public TestInterface getInner(){
        return new TestInterface() {
            @Override
            public void changeI(int i) {
                Outer.this.i = i;
            }
            @Override
            public void innerFun() {
                fun();
            }
        };
    }
}
