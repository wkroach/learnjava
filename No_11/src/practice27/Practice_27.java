package practice27;

import sun.plugin.com.event.COMEventHandler;

import java.util.LinkedList;
import java.util.Queue;

public class Practice_27 {
    public static void main(String[] args){
        Queue<Command> queue = new LinkedList<Command>();
        A.fill(queue);
        while(!queue.isEmpty()){
            queue.poll().operation();
        }
    }
}

class Command{
    private String info;
    public Command(String info){
        this.info = info;
    }
    public void operation(){
        System.out.println(info);
    }
}

class A{
    public static Queue<Command> fill(Queue<Command> queue){
        queue.add(new Command("I"));
        queue.add(new Command("want"));
        queue.add(new Command("AD"));
        queue.add(new Command("from"));
        queue.add(new Command("CMU"));
        return queue;
    }
}
