/**
 *  Create a class with a private field and a
 *  private method. Create an inner class with a
 *  method that modifies the outer-class field and
 *  calls the outer-class method. In a second
 *  outer-class method, create an object of the
 *  inner class and call its method, then show
 *  the effect on the outer-class object.
 */
package practice7;

public class Practice_7 {
    static public void main(String[] args){
        Outer outer = new Outer();
        System.out.println(outer);
        outer.outerFun(2);
        System.out.println(outer);
    }
}

class Outer{
    private int i = 0;
    @Override
    public String toString(){
        return new Integer(i).toString();
    }
    private void fun(){
        System.out.println("Outer fun()");
    }
    public void outerFun(int i){
        Inner inner = new Inner();
        inner.changeI(i);
        inner.innerFun();
    }
    class Inner{
        void changeI(int i){
            Outer.this.i = i;
        }
        void innerFun(){
            fun();
        }
    }
}
