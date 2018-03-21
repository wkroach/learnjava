/**
 类初始化顺序：
    先静态：静态先从基类到子类依次初始化
    再基类初始化: 先成员变量，后构造函数
    再成员变量初始化
    再构造函数
 */
public class Practice_5 {
}

class A{
    A(){
        System.out.println("A constructed");
    }
}

class B{
    int id;
    B(int id){
        this.id = id;
        System.out.println("B constructed "+this.id);
    }
}

class C extends A{
    B b = new B(1);
    public static void main(String[] args){
        C c = new C();
    }
    B bb = new B(2);
    //C(){
    //    System.out.println("C constructed");
    //}
}
