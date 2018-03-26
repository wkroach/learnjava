/**
 * Modify the previous exercise so that it uses
 * instanceof to check the type before performing
 * the downcasting
 */
/**
 * 在向下转型时可以用instanceof预先判断类型是否可以转型
 */
package practice4;

abstract class Shape{
    void draw(){
        System.out.println(this + ".draw()");
    }
    abstract public String toString();
}

class Circle extends Shape{
    @Override
    public String toString() {
        return "Circle";
    }
}
class Rhomboid extends Shape{
    @Override
    public String toString() {
        return "Rhmboid";
    }
}
public class Shapes {
   public static void main(String[] args){
       Shape[] shapes = {new Rhomboid(), new Circle()};
       for(Shape shape: shapes) {
           try {
               Circle circle = (Circle) shape;
               System.out.println(circle);
           } catch (ClassCastException e) {
               System.out.println(e);
           }
           try {
               if (shape instanceof Circle) {
                   Circle circle = (Circle) shape;
                   System.out.println(circle);
               } else if(shape instanceof Rhomboid){
                   Rhomboid rhomboid = (Rhomboid)shape;
                   System.out.println(rhomboid);
               };
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }
}
