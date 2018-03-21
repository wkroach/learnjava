/**
 * Show that OnOffSwitch.java can fail by
 * throwing a RuntimeException inside the try
 * block.
 */

/**
 * 如果有必须要处理的部分，尽量放在finally中，
 * 否则就要放在在每try-catch的每个部分
 * 且try-catch必须能够handle所有可能的异常
 */
package practice14;

class Swich{
    private boolean state = false;
    public boolean read(){
        return state;
    }
    public void on(){
        state = true;
        System.out.println(this);
    }
    public void off(){
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "on" : "false";
    }
}
class OnOffException extends Exception{

}
public class OnOffSwitch {
    private static Swich sw = new Swich();
    public static void fun() throws OnOffException{
        throw new RuntimeException();
    }
    public static void main(String[] args){
        try{
            sw.on();
            fun();
            sw.off();
        } catch (OnOffException e){
            System.out.println(e);
            sw.off();
        } catch (Exception e){
            System.out.println(e);
            System.out.println("switch's state is not off " + sw);
        }
    }
}
