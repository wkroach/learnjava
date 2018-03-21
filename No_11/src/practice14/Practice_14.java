/**
 * Create an empty LinkedList<Integer>. Using a
 * ListIterator, add Integers to the List by always
 * inserting them in the middle of the List.
 */

/**
 * LinkedList用法
 *有first，last两个对Node的引用
 * 初始化情况：
 *      默认初始化：first = last = null
 *      有值或者add之后：first指向第0个Node，last指向最后一个Node
 *
 * LinkedList.listInterator用法
 * 有next和lastRet两个引用（与ArrayList的listIterator对应)
 * next指向当前Node，lastRet指向最近访问过的Node
 * next(), previous(),nextIndex(),previousIndex()与ArrayList的listIterator对应
 * move(), set()也是对lastRet进行操作
 *
 * 初始化问题：
 * 空LinkedList的listIterator的next和lastRet均为null
 *
 * add问题:
 * iterator.add每次在当前next引用之前添加Node
 * 所以如果不用iterator.previous()而是一直iterator.add(), next引用始终都指向last后的null
 */
package practice14;

import java.util.LinkedList;
import java.util.ListIterator;

public class Practice_14 {
    static public void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ListIterator<Integer> it = linkedList.listIterator();
        for(int i = 0; i < 10; ++i){
            it.add(i);
            if(linkedList.size()%2 == 0){
                it.previous();
            }
        }
        System.out.println(linkedList);

        it = linkedList.listIterator();
        System.out.println(it.nextIndex());
        System.out.println(it.previousIndex());

        it = new LinkedList<Integer>().listIterator();
        it.add(1);
        System.out.println(it.previous());

        it = new LinkedList<Integer>().listIterator();
        for(int i = 0; i < 10; ++i){
            it.add(i);
        }
        //此时it的next引用仍旧为null
        //System.out.println(it.next());

    }
}
