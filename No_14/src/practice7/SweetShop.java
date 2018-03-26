/**
 * Modify SweetShop.java so that each type of
 * object creation is controlled by a
 * command-line argument. That is, if your
 * command line is "java SweetShop Candy," then
 * only the Candy object is created. Notice how
 * you can control which Class objects are loaded
 * via the command-line argument.
 */
package practice7;
import java.util.*;

class Candy{
    static {
        System.out.println("Loading Candy");
    }
}

class Gum{
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args){
        System.out.println("In main");
        //System.out.println(new ArrayList(Arrays.asList(args)));
        for(int i = 0; i < args.length; ++i){
           if(args[i].equals("Cookie")){
               new Cookie();
           } else if(args[i].equals("Candy")){
               new Candy();
           } else if(args[i].equals("Gum")){
               new Gum();
           }
        }
    }
}
