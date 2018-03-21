/**
 * Add a class with a dispose() method to the
 * previous exercise. Modify FailingConstructor so
 * that the constructor creates one of these
 * disposable objects as a member object, after which
 * the constructor might throw an exception, after
 * which it creates a second disposable member object.
 * Write code to properly guard against failure, and
 * in main() verify that all possible failure
 * situations are covered.
 */

/**
 * 如果类的构造器中可能会throw异常，且类中有成员需要手动销毁
 * 应该在构造器中handle异常，并手动销毁已构造的成员，再throw异常
 */
package practice24;

public class Practice_24 {
    public static void main(String[] args){
        try {
            FailingConstructor failingConstructor = new FailingConstructor();
            try{
               System.out.println(failingConstructor);
            }finally {
                failingConstructor.dispose();
            }
        }catch (Exception e){
           System.out.println("Construct fail");
        }
    }
}

class Disposable{
    private String s;
    Disposable(){}
    Disposable(String s){
        this.s = s;
    }
    public void dispose(){
        System.out.println("dispose()");
        s = "";
    }

    @Override
    public String toString() {
        return s;
    }
}

class FailingConstructor{
    private Disposable disposable;
    private Disposable disposable2;
    FailingConstructor() throws Exception{
        disposable = new Disposable("I want AD from CMU");
        try{
            if(true) {
                throw new Exception();
            }
        }catch (Exception e){
            disposable.dispose();
            throw e;
        }
        disposable2 = new Disposable("I want AD from UCSD");
    }
    public void dispose(){
        disposable.dispose();
        disposable2.dispose();
    }

    @Override
    public String toString() {
        return disposable + " " + disposable2;
    }
}
