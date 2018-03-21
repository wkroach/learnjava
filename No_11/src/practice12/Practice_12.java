/**
 * Create two List<Integer>s of the same size,
 * and populate one of them. Use ListIterators
 * to insert elements from the first List into
 * the second in reverse order.
 */

/**
 * ArrayList.Iterator<>用法
 * Iterator为ListIterator基类，只有next(), hashNext(), remove()等方法
 *
 * ArrayList.ListIterator<>用法
 *简而言之：next其实是得到当前元素(i++)，previous其实是得到前一个元素(--i)
 *
 * ListIterator中有两个参数表明当前元素下标
 * cursor: 表示当前下标，iterator()初始化时默认设为0
 * lastRet: 最近一次访问的元素下标，set, remove均对lastRet位置的对象操作
 *
 *next(): lastRet = cursor++, return data[lastRet]
 *      得到的其实是iterator当前位置的元素，且之后的set(), remove()操作均对其进行, 但iterator又往前走了一步
 * previous(): lastRet = --cursor, return data[lastRet]
 *             得到的是当前位置前一个位置的元素，并且iterator也指向了此元素的位置
 * nextIndex(): return cursor
 *              得到的是当前指的位置
 * previousIndex(): return cursor-1
 *              得到的是前一个位置
 */
package practice12;
import java.util.*;
public class Practice_12 {
    static public void main(String[] args){
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
        for(ListIterator<Integer> it1 = list1.listIterator(), it2 = list2.listIterator(list2.size()); it1.hasNext() && it2.hasPrevious();){
            it2.previous();
            it2.set(it1.next());
        }
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        ListIterator<Integer> it3 = list1.listIterator();
        System.out.println(it3.next());
        System.out.println(it3.nextIndex());
        System.out.println(it3.previousIndex());
        System.out.println(it3.previous());
        System.out.println(it3.nextIndex());
        it3.remove();
        System.out.println(it3.next());
        it3.set(100);
        System.out.println(list1);
    }
}

