package practice5;

import java.util.Random;

public class Practice_5 {
    public static void main(String[] args) {
        Random random = new Random(47);
        while (true) {
            Integer r = random.nextInt();
            try {
                if (r % 4 == 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                break;
            } finally {
                System.out.println(r + " " + r%4);
            }
        }
    }
}

