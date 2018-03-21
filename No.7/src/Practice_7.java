/**
 类初始化顺序：
    先静态：静态先从基类到子类依次初始化
    再基类初始化: 先成员变量，后构造函数
    再成员变量初始化
    再构造函数
    !!!基类如果有非默认构造器而没有默认构造器，则子类构造函数中需要手动调用super()
 */
public class Practice_7 {
}

class AA{
    AA(int i){
        System.out.println("A constructed");
    }
}

class BB{
    int id;
    BB(int id){
        this.id = id;
        System.out.println("BB constructed "+this.id);
    }
}

class CC extends AA{
    BB b = new BB(1);
    public static void main(String[] args){
        CC c = new CC();
    }
    BB bb = new BB(2);
    CC(int i){
        super(1);
       System.out.println("C constructed");
   }
   CC(){
        super(1);
        System.out.println("CC default constructed");
   }
}
