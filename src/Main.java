import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String s = "shit";
        String arr[] = {"shit", "fuck"};
        for(String ss:arr){
            System.out.println(ss);
        }
        Foo.fuck();
    }
}

interface Foo{
    public int id=1;
    public String name="fuck miis";
    static public void fuck(){
        System.out.println("fuck miis");
    }
    abstract void shit();
    //public Foo(int id, String name){
    //   this.id = id;
    //   this.name = name;
    //   System.out.println("out" + id + " " + name);
    //}
}
