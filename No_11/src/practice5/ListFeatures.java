/**
 * 一般来说，==比较对象内存地址，equals比较值(需要自定义，Object是默认比较地址)
 * 基本数据类型==, equals()比较的是值
 * 包装器类型Integer,String等：
 * 1. 隐式初始化(不用new)，值相等时内存地址也相等，值不等时内存地址也不等
 * 2. 显示初始化(用new)，内存地址一定不等，==一定为false，equals判断值是否相等
 */

/**
 * 包装器类型以及String，属于默认类型，赋值语句传值而不是引用
 * Integer p1 = 0;  Integer p2 = p1; 修改p1不改变p2的值
 */

/**
 * String.valueOf(object): 将一个object toString后返回一个String对象，null则返回"null"
 * Integer.valueOf(object):同上类似
 */

/**
 *List.toArray 有两种重载的函数
 *toArray(): 返回一个Object[]，包含所有List中的元素，但是是Object类型
 *toArray(T[]): 返回一个类型与T[]中元素类型一致的数组，
 *如果T[]的length小于List.size(), 则返回原List长的数组
 *如果T[]的length大于List.size(), 则返回T[].length长数组，超出部分为null
 */

/**
 * 基本类型如int，remove时不能直接用remove(int)，此时是remove(index)
 * ints.remove(100);
 * 正确做法：使用Integer.valueOf(int)返回一个值为100的Integer
 */

/**
 * List.subList()是原有List的一部分，所以sort和shuffle会改变原来List的内容
 */

package practice5;

import java.util.*;
import static java.lang.System.out;

public class ListFeatures {
    public static void main(String[] args){
        Random rand = new Random(31);
        List<Integer> ints = new ArrayList<Integer>();
        for(int i = 0; i < 7; ++i){
            ints.add(rand.nextInt());
        }
        out.println("1: " + ints);

        ints.add(100);
        out.println("2: " + ints);
        out.println("3: " + ints.contains(100));

        //基本类型如int，remove时不能直接用remove(int)，此时是remove(index)
        //!ints.remove(100);
        //正确做法：使用Integer.valueOf(int)返回一个值为100的Integer
        ints.remove(Integer.valueOf(100));
        out.println("4: " + ints);

        Integer p = ints.get(2);
        out.println("5: " + p + " " + ints.indexOf(p));

        out.println("6: " + ints.remove(p));
        out.println("7: " + ints);

        ints.add(3, 50);
        out.println("8: " + ints);

        //subList(s, e): [s, e)
        List<Integer> sub = ints.subList(1,4);
        out.println("subject: " + sub);
        out.println("9: " + ints.containsAll(sub));

        //sub是原有List的一部分，所以sort和shuffle会改变原来List的内容
        Collections.sort(sub);
        out.println("sorted subList: " + sub);
        out.println("10: " + ints.containsAll(sub));
        out.println("11: " + ints);

        //此时sub是使用原List的对象创建的，而由于包装器是值传递，因此修改sub不影响原有List
        sub = Arrays.asList(ints.get(1), ints.get(4));
        out.println("sub: " + sub);
        Collections.shuffle(sub, rand);
        out.println("sub after shuffle: " + sub);
        out.println("12: " + ints);

        List<Integer> copy = new ArrayList<Integer>(ints);
        copy.retainAll(sub);
        out.println("12: " + copy);

        copy = new ArrayList<Integer>(ints);
        copy.remove(2);
        out.println("13: " + copy);

        copy.removeAll(sub);
        out.println("14: " + copy);

        copy.set(1, 101);
        out.println("15: " + copy);

        copy.addAll(2, sub);
        out.println("16: " + copy);

        out.println("17: " + ints.isEmpty());
        ints.clear();
        out.println("18: " + ints);
        out.println("19: " + ints.isEmpty());

        //List.toArray 有两种重载的函数
        //toArray(): 返回一个Object[]，包含所有List中的元素，但是是Object类型
        //toArray(T[]): 返回一个类型与T[]中元素类型一致的数组，
        // 如果T[]的length小于List.size(), 则返回原List长的数组
        //如果T[]的length大于List.size(), 则返回T[].length长数组，超出部分为null
        ints.addAll(sub);
        out.println("20: " + ints);
        //Integer[] objs = ints.toArray();
        Object[] objs = ints.toArray();
        out.println("21: " + objs[0]);

        Integer[] inta = ints.toArray(new Integer[5]);
        out.println("22: " + inta.length );
        for(Integer i: inta){
            out.print(i + " ");
        }
        out.println();
        Integer[] intb = ints.toArray(new Integer[0]);
        for(Integer i: intb){
            out.print(i + " ");
        }
        out.println();
    }
}


