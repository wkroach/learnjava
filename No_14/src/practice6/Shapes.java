/**
 * Modify Shapes.java so that it can "highlight"
 * (set a flag) in all shapes of a particular
 * type. The toString() method for each derived
 * Shape should indicate whether that Shape is
 * "highlighted."
 */
/**
 * class的isInstance()方法等同于object instanceof class
 */
package practice6;

abstract class Shape{
    void draw(){
        System.out.println(this + ".draw()" + " highlighted? " + flag);
    }
    private boolean flag = false;
    public void highlight(){
        flag = true;
    }
    public void clear(){
        flag = false;
    }
    @Override
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
   public static void highlight(Shape[] shapes, Class type){
       for(Shape shape: shapes){
           if(type.isInstance(shape)){
              shape.highlight();
           }
       }
   }
   public static void main(String[] args){
       Shape[] shapes = {new Rhomboid(), new Circle()};
       try {
           highlight(shapes, Class.forName("practice6.Rhomboid"));
       }catch (ClassNotFoundException e){
           System.out.println(e);
       }
       for(Shape shape: shapes){
           shape.draw();
       }
   }
}
