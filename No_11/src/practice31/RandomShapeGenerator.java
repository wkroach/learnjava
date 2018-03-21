/**
 * Modify polymorphism/shape/RandomShapeGenerator.java
 * to make it Iterable. You’ll need to add a
 * constructor that takes the number of elements
 * that you want the iterator to produce before
 * stopping. Verify that it works.
 */

package practice31;

import java.util.Iterator;
import java.util.Random;

public class RandomShapeGenerator {
    public static void main(String[] args){
        Generator generator = new Generator(10);
        for(Shape shape: generator){
            shape.draw();
        }
    }
}

class Shape{
    public void draw(){
    }
    public void erase(){

    }
}

class Circle extends Shape{
    @Override
    public void draw(){
        System.out.println("Circle.draw()");
    }
    @Override
    public void erase(){
        System.out.println("Circle.erase()");
    }
}

class Square extends Shape{
    @Override
    public void draw(){
        System.out.println("Square.draw()");
    }
    public void erase(){
        System.out.println("Square.erase()");
    }
}

class Generator implements Iterable<Shape>{
    private Random rand = new Random(47);
    private int size = 0;
    public Generator(int size){
        this.size = size;
    }
    public Shape nextShape(){
       switch (rand.nextInt(2)){
           case 0: return new Circle();
           case 1: return new Square();
           default: return new Circle();
       }
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Shape next() {
                if(count < 0 || count >= size){
                    throw new UnsupportedOperationException();
                }
                count++;
                return nextShape();
            }
        };
    }
}

