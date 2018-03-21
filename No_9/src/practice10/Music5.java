/**
 *  Add a Playable to Modify Music5.java, and move
 *  the play() declaration from Instrument to
 *  Playable. Include Playable in the implements
 *  list to add it to the derived classes.
 *  Change tune() so it takes a Playable instead
 *  of an Instrument.
 */
/**
 * 重构技巧：将类的共有方法分别声明在不同interface中
 */
package practice10;

enum Note{
    MIDDLE_C, C_SHARP, B_FLAT;
}
interface Instrument{
    void adjust();
    @Override
    String toString();
}

interface Playable{
    void play(Note n);
}

class Wind implements Instrument, Playable{
    @Override
    public String toString() {
        return "Wind";
    }
    @Override
    public void play(Note n){
        System.out.println(this + ".play() " +n);
    }
    @Override
    public void adjust(){
        System.out.println(this + " .adjust()");
    }
}

class Percussion implements Instrument, Playable{
    @Override
    public String toString() {
        return "Percussion";
    }
    @Override
    public void play(Note n){
        System.out.println(this + ".play() " +n);
    }
    @Override
    public void adjust(){
        System.out.println(this + " .adjust()");
    }
}

class Stringed implements Instrument, Playable{
    @Override
    public String toString() {
        return "Stringed";
    }
    @Override
    public void play(Note n){
        System.out.println(this + ".play() " +n);
    }
    @Override
    public void adjust(){
        System.out.println(this + " .adjust()");
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
    static void tune(Playable i){
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable[] e){
        for(Playable i: e){
            tune(i);
        }
    }
    public static void main(String[] args){
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
