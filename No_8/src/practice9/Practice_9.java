package practice9;

/**
 * 此题展示多态的作用以及多态继承关系中类的构造顺序
 * 构造函数为static函数，没有多态性
 * 1. 先基类构造：静态->成员(声明顺序)->构造函数
 * 2. 依次逐层向下构造基类
 * 3. 按照声明顺序构造成员
 * 4. 构造函数
 */

public class Practice_9 {
    public static void main(String[] args){
        Rodent r1 = new Rodent();
        System.out.println("");
        Rodent r2 = new Mouse();
        System.out.println("");
        Rodent r3 = new Hamster();
        System.out.println("");
        r1.run();
        r2.run();
        r3.run();
    }
}

class Foot{
    int foot;
    public Foot(int foot){
        this.foot = foot;
        System.out.println("Init Feature, foot="+this.foot);
    }
}
class Fur{
    int fur;
    public Fur(int fur){
        this.fur = fur;
        System.out.println("Init Fur, fur="+this.fur);
    }
}

class Rodent {
    public Rodent(){
        System.out.println("Rodent()");
    }
    Foot foot = new Foot(1);
    Fur fur = new Fur(3);
    public void run(){
        System.out.println("Rodent run");
    }
}

class Mouse extends Rodent{
    public Mouse(){
        System.out.println("Mouse()");
    }
    Foot foot = new Foot(2);
    Fur fur = new Fur(2);
    public void run(){
        System.out.println("Mouse run");
    }
}

class Hamster extends Mouse{
    public Hamster(){
        System.out.println("Hamster()");
    }
    Foot foot = new Foot(3);
    Fur fur = new Fur(1);
    public void run(){
        System.out.println("Hamster run");
    }
}
