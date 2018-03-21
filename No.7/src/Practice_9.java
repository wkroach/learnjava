public class Practice_9 {
}

class Root{
   Component_2 component_2 = new Component_2();
   Root(){
       System.out.println("Root constructed");
       Component_1 component_1 = new Component_1();
   }
   Component_3 component_3 = new Component_3();
}

class Stem extends Root{
    Component_1 component_1 = new Component_1();
    Component_2 component_2 = new Component_2();
    Stem(){
        System.out.println("Stem constructed");
        Component_3 component_3 = new Component_3();
    }
   public static void main(String[] args){
       Stem stem = new Stem();
   }
}

class Component_1{
    Component_1(){
        System.out.println("Component_1 constructed");
    }
}

class Component_2{
    Component_2(){
        System.out.println("Component_2 constructed");
    }
}

class Component_3{
    Component_3(){
        System.out.println("Component_3 constructed");
    }
}
