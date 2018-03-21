/**
 * Repair the problem in LostMessage.java by
 * guarding the call in the finally clause.
 */

/**
 * finally中一定不能抛出异常,否则会覆盖之前try-catch的异常
 * finally中如果要throw异常或者使用可能抛出异常的方法
 * 必须在finally中使用try-catch handle住异常
 */
package practice19;

public class Practice_19 {
    public static void f() throws VeryImportantException{
        throw new VeryImportantException();
    }
    public static void g() throws HoHumException{
        throw new HoHumException();
    }
    public static void main(String[] args){
        /**
         * finally中throw其他异常会屏蔽try-catch中抛出的异常
         */
        try{
            try{
                f();
            } finally {
                try {
                    g();
                }catch (Exception e){
                    e.printStackTrace(System.out);
                }
            }
       } catch (Exception e){
           e.printStackTrace(System.out);
       }
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
