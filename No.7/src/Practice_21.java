/**
 * 验证类的final方法无法在子类中被override
 * 非private final方法无法被子类override
 * private方法无法override, 子类中可以定义与父类private方法同名通参数列表的方法
 * !!能够被重写，并且使用多态的只有非final的接口方法（public， protected， 包）
 */
public class Practice_21 {
}
class WithFinal{
    public void f(){
        System.out.println("With Final f()");
    }
    public final void g(){
        System.out.println("With Final final g()");
    }
    private void h(){
        System.out.println("With Final private h()");
    }
}

class OverrideFinal extends WithFinal{
    public void f(){
        System.out.println("Override Final f()");
    }
    public void gg(){ //! g无法覆盖父类中的public final方法
        System.out.println("Override Final g()");
    }
    public void h(){
        System.out.println("Override Final h()");
    }
    public static void main(String[] args){
        OverrideFinal overrideFinal = new OverrideFinal();
        overrideFinal.f();
        overrideFinal.g();
        overrideFinal.h();
        WithFinal withFinal = new OverrideFinal();
        withFinal.f();
        withFinal.g();
    }
}
