/**
 * Create a class that contains int, long, float
 * and double fields. Create a toString() method
 * for this class that uses String.format(), and
 * demonstrate that your class works correctly
 */

/**
 * 格式化输出Long和double类型时，只能按照%d和%f输出
 * 如果想输出完整的精度，可以直接%s输出
 */
package practice6;

public class Practice_6 {
    public static void main(String[] args){
        A a = new A();
        System.out.println(a);
    }
}

class A{
    private Integer ia = 1;
    private Long    lb = 1000000000012L;
    private Float   fc = 3.1415926535f;
    private Double  dd = 3.1415926535D;

    @Override
    public String toString() {
        return String.format("ia: %d\nib: %d\nfc: %f\ndd: %s", ia, lb, fc, dd);
    }
}
