/**
 * Starting with Statistics.java, create a
 * program that runs the test repeatedly and
 * looks to see if any one number tends to appear
 * more than the others in the results.
 */

/**
 * 自定义排序的两种方法(java使用的TimSort是StableSort, 会维护相等元素原有的先后顺序)：
 * 法1: 自定义类A 实现泛型接口Comparable<A>和排序函数compareTo
 *    int  compareTo(A o): return <0: this在前
 *                      return >0: this在后，o在前
 *                      return 0: this和o相等
 *
 * 法2: 自定义Compartor<A> compator（可以使内部类或者匿名内部类）和compare函数
 *    int compare(A left, A right): return <0: left在前
 *                                  return >0: left在后，right在前
 *                                  return 0: left和right相等
 */
package practice23;
import java.util.*;

public class Statistics {
    public static Map<Integer, Integer> Stat(){
        Random rand = new Random(47);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < 10000;++i){
            int tmp = rand.nextInt(20);
            map.put(tmp, map.getOrDefault(tmp, 0)+1);
        }
        return map;
    }
    public static void main(String[] args){
        Map<Integer, Integer> map = Stat();

        //方法1：
        ArrayList<Counter> counters = new ArrayList<Counter>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            counters.add(new Counter(entry.getKey(), entry.getValue()));
        }
        Collections.sort(counters);
        System.out.println("using comparable: " + counters);

        //方法2
        Comparator<Counter> c = new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return o1.getCount() - o2.getCount();
            }
        };
        Collections.sort(counters, c);
        System.out.println("using Compator: " + counters);
    }
}

class Counter implements Comparable<Counter>{
    private Integer i;
    private Integer count;

    public Counter(int i, int count){
        this.i = i;
        this.count = count;
    }
    public int getI(){
        return this.i;
    }
    public int getCount(){
        return this.count;
    }

    @Override
    public String toString() {
        return "i: " + i + " count: " + count;
    }

    @Override
    /**
     * compareTo 比较left, right
     * this为left
     * 默认排序规则: return >0: this在后
     *              return 0: 相等;
     *              return <0: this在前
     */
    public int compareTo(Counter o) {
        return o.count - this.count;
    }
}
