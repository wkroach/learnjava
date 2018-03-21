/**
 * 验证final关键字和static关键字的作用
 * 类中的final 对象在类内部必须被初始化，且不可再改变（常量为值，对象为引用）
 * static指此对象在类中只被初始化一次
 * static final 即类的静态不变成员，即静态常量
 * java中没有方法能够使对象的值不改变，只能让常量值和对象引用不改变
 */
public class Practice_18 {
}

class FinalB{
    int i;
    FinalB(int i){
        this.i = i;
    }
}

class FinalA{
    public final int i;
    public static final int J = 1;
    public final FinalB finalB;
    public static final FinalB FINAL_B = new FinalB(1);
    public FinalA(){
        this.i = 0;
        this.finalB = new FinalB(0);
    }
    public FinalA(int i){
        this.i = i;
        this.finalB = new FinalB(i);
    }
    public void testFinal(final FinalB finalB){
        System.out.println(finalB.i);
        finalB.i = 0;
        //!finalB = new FinalB(0);
    }
    public static void main(String[] args) {
        FinalA final_A = new FinalA();
        System.out.println(final_A.finalB.i);
        final_A = new FinalA(1);
        System.out.println(final_A.finalB.i);
        //!final_A.finalB = new FinalB(2);
        FinalB finalB = new FinalB(1);
        FinalB finalB1 = finalB;
        System.out.println("finalB " + finalB.i + " finalB1 " + finalB1.i);
        finalB1.i = -1;
        System.out.println("finalB " + finalB.i + " finalB1 " + finalB1.i);

    }
}
