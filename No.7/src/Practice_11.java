import com.sun.org.apache.bcel.internal.util.Class2HTML;

/**
 * 将practice2 的继承结构改成代理结构
 */
public class Practice_11 {

}
class Cleanser_2{
    private String s = "Cleanser";
    public void append(String a) {
        s += a;
    }
    public void dilute(){
        append(" dilute()");
    }
    public void apply(){
        append(" apply()");
    }
    public void scrub(){
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }
    public static void main(String[] args){
        Cleanser_2 x = new Cleanser_2();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

class Detergent_2 {
    Cleanser_2 cleanser_2 = new Cleanser_2();
    //delgeted methods
    public void append(String a){
        cleanser_2.append(a);
    }
    public void scrub(){
        append(" Detergent.scrub()");
        cleanser_2.scrub(); // Call base-class version
    }
    public void dilute(){
        cleanser_2.dilute();
    }
    public void apply(){
        cleanser_2.apply();
    }
    // Add methods to the interface;
    public void foam(){
        cleanser_2.append(" foam()");
    }
    @Override
    public String toString(){
        return cleanser_2.toString();
    }
    // Test the new class;
    public static void main(String[] args){
        Detergent_2 x = new Detergent_2();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}



