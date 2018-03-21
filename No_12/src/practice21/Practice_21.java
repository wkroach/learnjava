/**
 * Demonstrate that a derived-class constructor
 * cannot catch exceptions thrown by its
 * base-class constructor.
 */

/**
 * 如果默认基类的默认构造器中要throw异常(非Runtime)
 * 子类默认构造器不加异常声明会有编译错误：方法未handle异常
 * 如果是RuntimeException，则加不加异常声明都一样，但不能在子类构造器中handle父类构造器的异常
 *
 * 如果显示地调用super()并尝试try-catch handle异常依旧是编译错误
 * 因为显示调用的super()必须是第一行，而不能使try
 *
 * 根本原因：构造器中throw 异常，则此对象不会被编译器创建
 *          基类对象都不能被创建，那么子类一定是不完整的，捕获异常并恢复毫无意义
 */
package practice21;

public class Practice_21 {
    public static void main(String[] args){
        try {
            Inherit inherit = new Inherit();
        }catch (Exception e){
            //此时handle住的异常来源于隐式的基类构造器
            e.printStackTrace();
        }
    }
}

class Base{
    Base()throws Exception{
        throw new Exception();
    }
    Base(int i) throws Exception{
        throw new Exception();
    }
}
class Inherit extends Base{
    /**
     * 如果默认基类的默认构造器中要throw异常(非Runtime)
     * 子类默认构造器不加异常声明会有编译错误：方法未handle异常
     */
    //!Inherit(){
    //!}

    /**
     * 如果显示地调用super()并尝试try-catch handle异常依旧是编译错误
     * 因为显示调用的super()必须是第一行，而不能使try
     */
    Inherit()throws Exception{}
//    Inherit(int i) {
//        try{
//            super(i);
//        }catch (Exception e){
//            e.printStackTrace(System.out);
//        }
//    }
}
