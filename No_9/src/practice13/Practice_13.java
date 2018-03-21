/**
 *  Create an interface, inherit two new
 *  interfaces from it, then multiply-inherit
 *  a third interface from the second two
 */
/**
 * ！！！！Java allows multiple interface inheritance
 * but not multiple implementation inheritance,
 * which eliminates ambiguity about which of two identical members we use
 * when combining implementations of the same base class.
 * We replicate f( ) in the interfaces above to demonstrate that
 * Java avoids the “diamond problem”
 *
 * java允许多接口继承但是不允许实现(类)多继承,
 * 这样能够消除将两个一样根类成员和方法合并时产生的
 * 二义性。在java中，我们在接口中重复了f()，但是实现只有一份，
 * 且不同接口中的f()共用一份实现，因此不会产生菱形继承问题
 * !!接口中的域均为final static，因此菱形接口继承时不会有域冲突
 */
package practice13;

public class Practice_13 {
    static public void main(String[] args){
        Inherit inherit = new Inherit();
        inherit.fun();
    }
}

interface Base{
    void fun();
}

interface Base1 extends Base{
    @Override
    void fun();
}

interface Base2 extends Base{
    @Override
    void fun();
}

class Inherit implements Base1, Base2{
    @Override
    public void fun(){
       System.out.println("Inherit fun");
    }
}
