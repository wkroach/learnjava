/**
 * Split the string Splitting.knights on the words  * "the" or "you."
 */
package practice8;
import java.util.Arrays;

public class Practice_8 {
    public static void main(String[] args){
        String str = "Then, when you have found the shrubbery, you must "+
                    "cut down the mightiest tree in the forest..."+
                    "with... a herring!";
        System.out.println(Arrays.toString(str.split("you|the")));
    }
}
