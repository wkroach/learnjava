public class Practice_1 {
    public Integer i = 0;
    Test test;
    Practice_1(){
        System.out.println("Practice_1 constructed");
        if(test == null){
            test = new Test();
        }
        System.out.println(test.info);
    }
    public static void main(String[] args){
        Practice_1 practice_1 = new Practice_1();
    }
}

class Test{
    String info;
    Test(){
        System.out.println("Test constructed");
        info = "hehe";
    }

    @Override
    public String toString() {
        return info;
    }
}
