/**
 * Write code to generate and catch an
 * ArrayIndexOutOfBoundsException.
 */

/**
 *ArrayIndexOutOfBoundException以及其他IndexOutOfBoundException
 *的基类都是RuntimeException，因此可以直接throw不需要异常说明
 */
package practice3;

public class ArrayIndexOutOfBoundsExceptions {
    public static void main(String[] args){
        MyArray myArray = new MyArray(3);
        try{
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            myArray.add(4);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            e.printStackTrace(System.out);
        }
        try{
            myArray.get(-1);
            myArray.get(4);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            e.printStackTrace(System.out);
        }
    }
}

class MyArray{
    private Integer[] arr;
    private Integer cursor = 0;
    public MyArray(Integer size){
        arr = new Integer[size];
    }
    public void add(Integer i){
        arr[cursor++] = i;
    }
    public Integer get(Integer i){
        return arr[i];
    }
}
