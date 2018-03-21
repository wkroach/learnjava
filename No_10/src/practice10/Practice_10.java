/**
 *  Repeat Exercise 9 but define the inner
 *  class within a scope within a method.
 */
package practice10;
import practice6_1.*;

public class Practice_10 {
    public TestInterface outerFun(){
        class Inner implements TestInterface{
            @Override
            public void fun(){
                System.out.println("Inner fun()");
            }
        }
        return new Inner();
    }

    public void outerFun2(int i){
       if(i > 0){
           class Inner2 implements TestInterface{
               @Override
               public void fun(){
                   System.out.println("Inner2 fun()");
               }
           }
           TestInterface testInterface =  new Inner2();
           testInterface.fun();
       }
       else{
           //!TestInterface testInterface =  new Inner2();//不能在内部类的定义区域外定义内部类对象
           //!testInterface.fun();
           System.out.println("outerFun2()");
       }
    }

    static public void main(String[] args){
        new Practice_10().outerFun2(0);
        new Practice_10().outerFun2(1);
    }
}
