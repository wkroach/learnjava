package practice15;

/**
 * 禁止复杂化构造函数，严禁在构造函数里调用非private和final的接口方法
 * java编译器化将未初始化的类全部设置成0（null）,调用未初始化的子类的方法，会访问未初始化的域
 */

public class Practice_15 {
}

class Glyph {
    void draw(){
        System.out.println("Glyph.draw()");
    }
    Glyph(){
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
    @Override
    public String toString() {
        return "Glyph()";
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r){
        radius = r; //基本类型未初始化时为0
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
        draw();
    }
    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends RoundGlyph {
    private Glyph hehe; //引用未初始化时为null
    RectangularGlyph(int r){
        super(r);
        this.hehe = new Glyph();
        System.out.println("RectangularGlyph(), hehe = " + hehe);
    }
    @Override
    void draw() {
        System.out.println("RectangularGlyph.draw(), hehe = " + hehe);
    }
}

class PolyConstructors {
   public static void main(String[] args){
       new RectangularGlyph(5);
   }
}
