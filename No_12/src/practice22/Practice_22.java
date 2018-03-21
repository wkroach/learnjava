/**
 * Create a class called FailingConstructor with a
 * constructor that might fail partway through the
 * construction process and throw an exception. In
 * main(), write code that properly guards against
 * this failure.
 */

/**
 * 对于一个构造可能失败或者构造器可能抛出异常的类
 * 1.对于每个对象，都要在try中new，并在catch中接住异常
 * 2.对于每个必须要手动进行销毁处理的对象，必须在new之后接try-catch-finally，并在finally中进行销毁处理
 */
package practice22;

public class Practice_22 {
    public static void main(String[] args){
        for(int i = 0; i < 4; ++i) {
            try {
                FailingConstructor failingConstructor = new FailingConstructor(i);
                try {
                    failingConstructor.process();
                } finally {
                    failingConstructor.depose();
                }
            } catch (Exception e) {
                System.out.println("Construct fail");
            }
        }

    }
}

class FailingConstructor{
    FailingConstructor(){}
    FailingConstructor(int i){
        if(i % 2 == 1) {
            throw new RuntimeException();
        }
    }
    void process(){
        System.out.println("process()");
    }
    void depose(){
        System.out.println("depose()");
    }
}
