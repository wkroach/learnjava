import java.util.*;
public class Practice_3 {
}

class Art{
    Art(){
        System.out.println("Art constructor");
    }
}

class Drawing extends Art{
    Drawing(){
        System.out.println("Drawing constructor");
    }
}

class Cartoon extends  Drawing{
   // public Cartoon(){
   //     System.out.println("Cartoon constructor");
   // }
    public static void main(String[] args){
        Cartoon x = new Cartoon();
    }
}
