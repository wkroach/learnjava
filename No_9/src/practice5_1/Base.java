/**Create an interface with three methods in its
 * own package. Implement the interface in a
 * different package
 */
/**
 * 一个包中只有public的class，interface可以在包外被使用
 * 所以interface，abstract class最好单独在java文件中定义
 * ！interface中所有方法均默认为public，所有域均为final static
 */
package practice5_1;

public interface Base{
    void fun1();
    Object fun2(int i);
    public String fun3(String s);
    //!protected void fun4(); 接口内的方法必须是public(默认)
}


