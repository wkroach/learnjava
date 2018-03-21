package practice14;

/**
 * 此题展示对于有多重引用对象时如何应用应用计数方式进行析构
 */

public class Practice_14 {
    public static void main(String[] args){
        Foot foot = new Foot(4);
        Rodent r1 = new Rodent(foot);
        System.out.println("");
        Rodent r2 = new Mouse(foot);
        System.out.println("");
        Rodent r3 = new Hamster(foot);
        System.out.println("");
        r1.dispose();
        System.out.println("");
        r2.dispose();
        System.out.println("");
        r3.dispose();
    }
}

class Foot{
    /**
        Foot具有引用计数机制保证多重引用析构时能够完全析构
     */
    private long refCount = 0; //引用计数
    private static long count = 0; //统计总共有多少Foot对象
    private long id = count++; //当前Foot对象的id号

    int foot;
    public Foot(int foot){
        this.foot = foot;
        System.out.println("Init Feature, foot="+this.foot+" id="+id);
    }
    public void addRef(){ //每次新增一个引用时必须调用addRef()
        refCount++;
    }
    public void dispose(){
        if(--refCount == 0) { //只有当引用计数为0时才进行析构
            System.out.println("Foot dispose() id=" + id);
        }
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
    public Rodent(Foot foot){
        this.foot = foot;
        this.foot.addRef();
        System.out.println("Rodent()");
    }
    Foot foot;
    Fur fur = new Fur(3);
    public void run(){
        System.out.println("Rodent run");
    }
    public void dispose(){
        System.out.println("Rodent dispose()");
        foot.dispose();
        fur.dispose();
    }
}

class Mouse extends Rodent{
    public Mouse(Foot foot){
        super(foot);
        this.foot = foot;
        this.foot.addRef();
        System.out.println("Mouse()");
    }
    Foot foot;
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
    public Hamster(Foot foot){
        super(foot);
        this.foot = foot;
        this.foot.addRef();
        System.out.println("Hamster()");
    }
    Foot foot;
    Fur fur = new Fur(1);
    public void run(){
        System.out.println("Hamster run");
    }
    public void dispose(){
        System.out.println("Hamster dispose()");
        foot.dispose();
        fur.dispose();
        super.dispose();
    }
}
