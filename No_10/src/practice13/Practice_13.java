/**
 * Repeat Exercise 9 using an anonymous inner
 * class.
 */
package practice13;
import practice6_1.*;

public class Practice_13 {
    public TestInterface outerFun(){
        return new TestInterface(){
            @Override
            public void fun(){
                System.out.println("Inner fun()");
            }
        };
    }

    static public void main(String[] args){
        Practice_13 practice_13 = new Practice_13();
        TestInterface testInterface = practice_13.outerFun();
        testInterface.fun();
    }
}
