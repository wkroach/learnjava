/**
 * java中，子类的方法不会覆盖父类中重载的其他方法，只会覆盖有相同名字和形参列表的方法，如果想重写而不是重载应该用@Override
 */
public class Practice_13 {
}

class Father{
    public void hehe(int i){
        System.out.println(i);
    }
    public void hehe(String s){
        System.out.println(s);
    }
    public void hehe(int arr[]){
        for(int i: arr) {
            System.out.println(i);
        }
    }
}

class Son extends Father{
    public void hehe(String args[]){
        System.out.println(args.length);
        for(Object s: args){
            System.out.println(s);
        }
    }
    public static void main(String[] args){
        Son son = new Son();
        son.hehe(args);
        son.hehe(1);
        son.hehe("fuck miis");
        int arr[] = {1,2,3};
        son.hehe(arr);
    }
}
