package practice24;
import java.util.*;

public class RegisteredFactories {
    public static void main(String[] args){
        System.out.println(Part.Creator.createNullPart());
        for(int i = 0; i < 5; ++i){
            System.out.println(Part.Creator.createNullPart(Part.Creator.createRandom().getClass()));
        }
    }
}
