package practice6_2;
import practice6_1.*;

public class Base {
    protected class Inner implements TestInterface{
        //构造函数必须是public的，否则Inherit类中无法new Inner
        public Inner(){}
        //同理
        public void fun(){
           System.out.println("Inner fun()");
        }
    }
}
