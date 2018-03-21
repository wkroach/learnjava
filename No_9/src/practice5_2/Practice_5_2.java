/**
 * 只有包中的public的class，interface可以在包外被使用
 */
package practice5_2;
import practice5_1.*;

public class Practice_5_2 {
    public static void main(String[] args){
        Inherit inherit = new Inherit();
        inherit.fun1();
        inherit.fun2(1);
        inherit.fun3("fuck harvard");
    }
}

class Inherit implements Base{
    @Override
   public void fun1(){
       System.out.println("fun1");
   }
   @Override
    public Integer fun2(int i){
        System.out.println("fun2 i=" + i);
        return i;
   }
   @Override
    public String fun3(String s){
        System.out.println("fun3 s=" + s);
        return s;
   }

   public Object fun4(){
        return "shit";
   }
}

