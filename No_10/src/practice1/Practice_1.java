/**
 * Write a class named Outer containing an
 * inner class named Inner. Add a method to Outer
 * that returns an object of type Inner. In
 * main(), create and initialize a reference to
 * an Inner
 */
package practice1;

public class Practice_1 {
    static public void main(String[] args){
        Outer outer = new Outer();
        Outer.Inner outerInner = outer.getInner();
    }
}

class Outer{
    class Inner{
        Inner(){
            System.out.println("Inner()");
        }
    }
    public Inner getInner(){
        return new Inner();
    }
}
