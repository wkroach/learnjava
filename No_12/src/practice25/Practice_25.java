/**
 * Create a three-level hierarchy of exceptions.
 * Now create a base class A with a method that
 * throws an exception at the base of your
 * hierarchy. Inherit B from A and override the
 * method so it throws an exception at level two
 * of your hierarchy. Repeat by inheriting class
 * C from B. In main(), create a C and upcast it
 * to A, then call the method.
 */

/**
 * 在多态中throw异常时，catch必须用基类的异常声明，即基类方法声明MyException，
 * 即使子类方法声明MyException3，如果用子类实现基类引用并调用方法，则实际以MyException形式throw
 * throw MyException3
 * 总而言之：由于多态是在不改变原有代码就可以用基类引用使用子类对象，显然catch时也要用基类方法的异常声明，
 * 否则就不能保证多态性
 */
package practice25;

public class Practice_25 {
    public static void main(String[] args){
        Base base3 = new Base3();
        try{
            base3.fun();
            //!必须用基类方法声明的异常来catch，不能用MyException3
        }catch (MyException e){
            //e.printStackTrace(System.out);
        }
    }
}

class MyException extends Exception{}
class MyException2 extends MyException{}
class MyException3 extends MyException2{}

class Base{
    void fun() throws MyException{
        throw new MyException();
    }
}

class Base2 extends Base{
    @Override
    void fun() throws MyException2{
        throw new MyException2();
    }
}

class Base3 extends Base{
    @Override
    void fun() throws MyException3{
        throw new MyException3();
    }
}
