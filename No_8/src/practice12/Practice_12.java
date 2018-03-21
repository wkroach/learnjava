package practice12;

/**
 * 此题展示多态中的手动析构顺序(与C++中的析构顺序一致)
 * 手动的析构函数必须被override
 * 1. 先当前类析构：成员(与声明顺序相反)->基类析构函数
 * 2. 依次逐层向上析构基类
 */

public class Practice_12 {
    public static void main(String[] args){
        Rodent r1 = new Rodent();
        System.out.println("");
        Rodent r2 = new Mouse();
        System.out.println("");
        Rodent r3 = new Hamster();
        System.out.println("");
        r1.dispose();
        System.out.println("");
        r2.dispose();
        System.out.println("");
        r3.dispose();
    }
}

class Foot{
    int foot;
    public Foot(int foot){
        this.foot = foot;
        System.out.println("Init Feature, foot="+this.foot);
    }
    public void dispose(){
        System.out.println("Foot dispose()");
    }
}
class Fur{
    int fur;
    public Fur(int fur){
        this.fur = fur;
        System.out.println("Init Fur, fur="+this.fur);
    }
    public void dispose(){
        System.out.println("Fur dispose()");
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
    public void dispose(){
        System.out.println("Rodent dispose()");
        fur.dispose();
        foot.dispose();
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
    public void dispose(){
        System.out.println("Mouse dispose()");
        fur.dispose();
        foot.dispose();
        super.dispose();
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
    public void dispose(){
        System.out.println("Hamster dispose()");
        fur.dispose();
        foot.dispose();
        super.dispose();
    }
}
