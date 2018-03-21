/**
 * Create a private inner class that implements a
 * public interface. Write a method that returns
 * a reference to an instance of the private
 * inner class, upcast to the interface. Show
 * that the inner class is completely hidden by
 * trying to downcast to it.
 */
/**
 * private的内部类在外部类的外部不能直接访问与创建对象，只能通过向上转型访问
 */
package practice11;
import practice6_1.*;

class Main{
    static public void main(String[] args){
        TestInterface testInterface = new Practice_11().getInterface();
        testInterface.fun();
        //无法向下转型，Inner在Practice_11中是private
        //!((Practice_11.Inner)testInterface).fun2();
    }
}

public class Practice_11 {
    private class Inner implements TestInterface{
        @Override
        public void fun(){
            System.out.println("Inner fun()");
        }
        public void fun2(){
            System.out.println("Inner fun2()");
        }
    }
    public TestInterface getInterface(){
        return new Inner();
    }


}
