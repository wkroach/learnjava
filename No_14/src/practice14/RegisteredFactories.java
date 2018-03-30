/**
 * A constructor is a kind of factory method. Modify
 * RegisteredFactories.java so that instead of using
 * an explicit factory, the class object is stored
 * in the List, and newInstance() is used to create
 * each object.
 */
package practice14;
import part.*;
public class RegisteredFactories {
     public static void main(String[] args){
        for(int i = 0; i < 5; ++i){
            System.out.println(Part.classCreateRandom());
        }
    }
}
