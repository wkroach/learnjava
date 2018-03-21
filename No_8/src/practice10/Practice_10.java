package practice10;

/**
 *当基类函数fun被覆盖了，即使用未覆盖函数间接调用fun依然有多态性
 */
public class Practice_10 {
    public static void main(String[] args){
        A a = new C();
        a.fun1();
        a.fun2();
    }
}

class A{
    public void fun1(){
        System.out.println("A fun1");
        fun2();
    }
    public void fun2(){
        System.out.println("A fun2");
    }
}

class B extends A{
    public void fun(){
        System.out.println("B fun");
    }
    @Override
    public void fun2() {
        System.out.println("B fun2");
    }
}

class C extends B{
    public void fun2(){
        System.out.println("C fun2");
    }
}
