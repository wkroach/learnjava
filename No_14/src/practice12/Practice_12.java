/**
 * Use TypeCounter with the RegisteredFactories.java  * example in this chapter.
 */
package practice12;
import TypeCounter.*;
import factory.*;
import RegisteredFactories.*;
import part.*;

public class Practice_12 {
    public static void main(String[] args){
        TypeCounter counter = new TypeCounter(Part.class);
        for(int i = 0; i < 4; ++i){
            Part part = Part.createRandom();
            System.out.println(part.getClass().getSimpleName() + " ");
            counter.count(part);
        }
        System.out.println(counter);
    }
}
