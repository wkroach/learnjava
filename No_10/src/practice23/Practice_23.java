/**
 * Create an interface U with three methods.
 * Create a class A with a method that produces a
 * reference to a U by building an anonymous
 * inner class. Create a second class B that
 * contains an array of U. B should have one
 * method that accepts and stores a reference to
 * a U in the array, a second method that sets a
 * reference in the array (specified by the
 * method argument) to null, and a third method
 * that moves through the array and calls the
 * methods in U. In main(), create a group of A
 * objects and a single B. Fill the B with U
 * references produced by the A objects. Use the
 * B to call back into all the A objects. Remove
 * some of the U references from the B.
 */
package practice23;

public class Practice_23 {
    static public void main(String[] args){
        B b = new B(4);
       for(int i = 0; i < 4; ++i){
          A a = new A();
          b.append(a.funA());
       }
       b.loop();
       b.erase(0);
       b.erase(2);
       b.loop();
    }
}

interface U{
    void fun1();
    void fun2();
    void fun3();
}

class A{
    U funA(){
        return new U() {
            @Override
            public void fun1() {
               System.out.println("A fun1()");
            }

            @Override
            public void fun2() {
                System.out.println("A fun2()");
            }

            @Override
            public void fun3() {
                System.out.println("A fun3()");
            }
        };
    }
}

class B{
    private int next = 0;
    private U[] items;
    public B(int size){
        items = new U[size];
    }
    void append(U u){
       if(next < items.length){
           items[next++] = u;
       }
    }
    void erase(int pos){
        if(pos >=0 && pos <items.length){
            items[pos] = null;
        }
    }
    void loop(){
        for(int i = 0; i < items.length; ++i){
            U u = items[i];
            System.out.println("U " + i);
            if(u != null){
                u.fun1();
                u.fun2();
                u.fun3();
            }
        }
    }
}
