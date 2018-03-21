/**
 * Modify Exercise 1 so Outer has a private
 * String field (initialized by the constructor),
 * and Inner has a toString() that displays this
 * field. Create an object of type Inner and
 * display it.
 */
/**
 * 内部类可以无视访问权限来访问外部类的域
 */
package practice3;

public class Practice_3 {
    static public void main(String[] args) {
        Outer outer = new Outer("fuck UWM");
        Outer.Inner outerInner = outer.getInner();
        System.out.println(outerInner);
    }
}

class Outer{
    private String s;
    public Outer(String s){
        this.s = s;
    }
    public Inner getInner(){
        return new Inner();
    }
    class Inner{
        @Override
        public String toString() {
            return s;
        }
    }
}
