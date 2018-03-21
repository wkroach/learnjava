/**
 * Create an interface containing a nested class.
 * Implement this interface and create an
 * instance of the nested class.
 */
package practice20;

public class Practice_20 {
    static public void main(String[] args){
        TestInterface.Inner inner = new Inherit.Inner();
    }
}

interface TestInterface{
    //public static
    class Inner{
        public Inner(){
            System.out.println("Inner()");
        }
    }
}

class Inherit implements TestInterface{

}
