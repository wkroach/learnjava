/**
 基类和子类中有重复定义的成员时，子类的成员默认为this.component, 使用父类成员变量时用super.component
 */
public class Practice_10 {
}

class Roott{
   Component_22 component_22 = new Component_22("22");
   Roott(String s){
       System.out.println("Root constructed");
       Component_11 component_11 = new Component_11("11");
   }
   Component_33 component_33 = new Component_33("33");
}

class Stemm extends Roott{
    Component_11 component_11 = new Component_11("1");
    Component_22 component_22 = new Component_22("2");
    Stemm(String s){
        super(s);
        System.out.println(component_22.s);
        System.out.println("Stem constructed");
        Component_33 component_33 = new Component_33("3");
    }
   public static void main(String[] args){
       Stemm stemm = new Stemm("stemm");
   }
}

class Component_11{
    String s;
    Component_11(String s){
        this.s = s;
        System.out.println("Component_11 constructed");
    }
}

class Component_22{
    String s;
    Component_22(String s){
        this.s = s;
        System.out.println("Component_22 constructed");
    }
}

class Component_33{
    String s;
    Component_33(String s){
        this.s = s;
        System.out.println("Component_33 constructed");
    }
}
