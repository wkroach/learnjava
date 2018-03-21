/**
 * Create a simple class that inherits from Object
 * and contains no members, and show that you cannot
 * successfully add multiple elements of that class
 * to a PriorityQueue. This issue will be fully
 * explained in the Containers in Depth chapter.
 */

/**
 * 优先队列存放的元素必须是可以比较的，
 * 要么继承自Comparable，实现了compareTo
 * 要么用自定义的Comparator初始化优先队列
 */
package practice29;
import java.util.*;

public class Practice_29 {
    public static void main(String[] args){
        //类继承Comparable
       Queue<A> queue = new PriorityQueue<A>();
       for(int i = 0; i < 10; ++i){
           queue.add(new A(i));
       }
       for(;!queue.isEmpty();){
          System.out.print(queue.poll() + " ");
       }

       System.out.println();

       //使用Comparator初始化PriorityQueue
       Comparator<A> c1 = new Comparator<A>() {
           @Override
           public int compare(A o1, A o2) {
               return o1.getI() - o2.getI();
           }
       };
       queue = new PriorityQueue<A>(c1);
       for(int i = 0; i < 10; ++i){
           queue.add(new A(i));
       }
       for(;!queue.isEmpty();){
           System.out.print(queue.poll() + " ");
       }

       //PriorityQueue必须使用Comparator初始化或者类继承Comparable且实现了compareTo
        Queue<B> queue2 = new PriorityQueue<B>();
        queue2.add(new B());
        //B无法比较，因此无法用优先队列存放
        //!queue2.add(new B());

    }
}

class A implements Comparable<A>{
   private int i;
   public A(int i){
       this.i = i;
   }
   public int getI(){
       return i;
   }

    @Override
    public String toString() {
        return "I: " + i;
    }

    @Override
    public int compareTo(A o) {
        return o.i - this.i;
    }
}

class B{

}
