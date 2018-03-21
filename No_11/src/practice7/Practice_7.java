/**
 * Create a class and make an initialized array
 * of your class objects. Fill a List from
 * your array. Create a subset of your List using
 * subList(), then remove this subset from
 * your List.
 */

/**
 * subList = list.subList()
 * subList此时是list的一部分，如果对list进行修改会导致subList不可用
 * 比较好的操作是直接修改subList(如subList.clear())，这样的话原list也会得到修改
 */
package practice7;

import java.util.ArrayList;
import java.util.List;

public class Practice_7 {
    static public void main(String[] args){
        List<Base> list = new ArrayList<Base>();
        for(int i = 0; i < 10; ++i){
            list.add(new Base(i));
        }
        List<Base> subList = list.subList(1,4);
        System.out.println("list: " + list);
        System.out.println("subList: " + subList);

        //subList此时是list的一部分，如果对list进行修改会导致subList不可用
        //!list.remove(1);
        //!System.out.println("subList: " + subList);

        //比较好的操作是直接修改subList，这样的话原list也会得到修改
        subList.clear();
        System.out.println("list: " + list);
    }
}

class Base{
    private Integer i;
    Base(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }
}
