public class Practice_2 {

}
class Cleanser{
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
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

class Detergent extends Cleanser{
    //Change amethod;
    @Override
    public void scrub(){
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
    }
    // Add methods to the interface;
    public void foam(){
        append(" foam()");
    }
    // Test the new class;
    public static void main(String[] args){
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}

class Detergent2 extends Detergent{
    @Override
    public void scrub(){
        append(" Detergent2.scrub()");
        super.scrub();
    }
    //add new method
    public void sterilize(){
        append(" sterilize()");
    }
    public static void main(String[] args){
        Detergent2 x = new Detergent2();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.sterilize();
        System.out.println(x);
        System.out.println("Testing upper class:");
        Detergent.main(args);
    }
}


