package practice16;
import java.util.*;
import java.nio.*;

public class Practice_16 {
    static public void main(String[] args){
        Scanner scanner = new Scanner(new GenerateChar());
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}

class GenerateChar implements Readable{
    String s = "abcdefghijklmnopqrstuvwxyz";
    @Override
    public int read(CharBuffer cb){
        cb.put(s);
        cb.append(" ");
        return s.length();
    }
}
