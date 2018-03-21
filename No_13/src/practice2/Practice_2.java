/**
 * Repair InfiniteRecursion.java.
 */

/**
 * 禁止在toString中使用this，要使用对象地址的话，调用super.toString()
 */
package practice2;

public class Practice_2 {
    public static void main(String[] args){
        InfiniteRecursion infiniteRecursion = new InfiniteRecursion();
        System.out.println(infiniteRecursion);
    }
}

class InfiniteRecursion {
    @Override
    //!在toString使用this会造成递归，最终产生StackOverflow
    //如要打印this应该使用super.toString()
    public String toString() {
       //! return "address: " + this + "\n";
        return "address: " + super.toString() + "\n";
    }
}
