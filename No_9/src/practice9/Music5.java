/**
 * Refactor Music5.java by moving the common
 * methods in Wind, Percussion and Stringed into
 * an abstract class
 */
/**
 * 重构技巧：将子类的公共方法放在抽象类中实现
 */
package practice9;

enum Note{
    MIDDLE_C, C_SHARP, B_FLAT;
}
abstract class AbstractInstrument{
    public void play(Note n){
        System.out.println(this + ".play() " +n);
    }
    public void adjust(){
        System.out.println(this + " .adjust()");
    }

    @Override
    abstract public String toString();
}

class Wind extends AbstractInstrument{
    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion extends AbstractInstrument{
    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed extends AbstractInstrument{
    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind{
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind{
    @Override
    public String toString() {
        return "Woodwind";
    }
}

public class Music5 {
    static void tune(AbstractInstrument i){
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(AbstractInstrument[] e){
        for(AbstractInstrument i: e){
            tune(i);
        }
    }
    public static void main(String[] args){
        AbstractInstrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
