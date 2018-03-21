package practice6_3;
import practice6_2.*;
import practice6_1.*;
public class Inherit extends Base {
    public TestInterface fun(){
        return new Inner();
    }
    static public void main(String[] args){
        TestInterface testInterface = new Inherit().fun();
        testInterface.fun();
    }
}
