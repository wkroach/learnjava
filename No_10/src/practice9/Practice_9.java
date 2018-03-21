/**
 * Create an interface with at least one method,
 * and implement it by defining an
 * inner class within a method that returns a
 * reference to your interface.
 */
package practice9;
import practice6_1.*;

public class Practice_9 {
    public TestInterface outerFun(){
        class Inner implements TestInterface{
            @Override
            public void fun(){
                System.out.println("Inner fun()");
            }
        }
        return new Inner();
    }

    static public void main(String[] args){
        Practice_9 practice_9 = new Practice_9();
        TestInterface testInterface = practice_9.outerFun();
        testInterface.fun();
    }
}
