/**
 * Add a second level of exception loss to
 * LostMessage.java so that the HoHumException is
 * itself replaced by a third exception.
 */

/**
 * 严禁在finally部分throw 其他异常以及return
 * 1. finally中throw其他异常会屏蔽try-catch中抛出 异常
 * 2. finally中return会屏蔽try-catch中抛出的异常
 * 3. finally中return会屏蔽try和catch块中的return
 */
package practice18;

public class Practice_18 {
    public static void f() throws VeryImportantException{
        throw new VeryImportantException();
    }
    public static void g() throws HoHumException{
        throw new HoHumException();
    }
    public static void h() throws VeryTrivialException{
        throw new VeryTrivialException();
    }
    public static void k() throws VeryImportantException{
           try {
               f();
           } finally {
               System.out.println("return from finally");
                return;
           }
    }
    public static String L(){
        try{
            return "return from L() try";
        }finally {
            return "return from L() finally";
        }
    }
    public static String LL(){
        try{
            f();
        } catch (Exception e){
            System.out.println(e);
            return "return from LL() catch";
        } finally {
            return "return from LL() finally";
        }
    }
    public static void main(String[] args){
        /**
         * finally中throw其他异常会屏蔽try-catch中抛出的异常
         */
       try{
           try{
               try{
                  f();
               } finally {
                   g();
               }
           } finally {
               h();
           }
       } catch (Exception e){
           e.printStackTrace(System.out);
       }
        /**
         * finally中return会屏蔽try和catch中throw的异常
         */
       try{
           k();
       } catch (Exception e){
           System.out.println(e);
       }
        /**
         * finally中return部分会屏蔽try块和catch块中的return
         */
        System.out.println(L());
        System.out.println(LL());
    }
}

class VeryImportantException extends Exception{
    @Override
    public String toString() {
        return "very important exception";
    }
}

class HoHumException extends Exception{
    @Override
    public String toString() {
        return "a trivial exception";
    }
}

class VeryTrivialException extends Exception{
    @Override
    public String toString() {
        return "a very trivial exception";
    }
}
