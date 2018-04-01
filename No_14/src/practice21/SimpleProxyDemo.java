/**
 * Modify SimpleProxyDemo.java so it measures
 * method-call times.
 */
package practice21;

interface Interface{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface{
    @Override
    public void doSomething() {
       System.out.println("doSomething");
    }
    @Override
    public void somethingElse(String arg) {
       System.out.println("somethingElse" + " " + arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;
    private Integer count1 = 0;
    private Integer count2 = 0;
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
       proxied.doSomething();
       count1++;
    }

    @Override
    public void somethingElse(String arg) {
       proxied.somethingElse(arg);
       count2++;
    }

    @Override
    public String toString() {
        return "doSomething(): " + count1 + "\nsomethingElse(): " + count2;
    }
}
public class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("I love Rice");
    }
    public static void main(String[] args){
        SimpleProxy simpleProxy = new SimpleProxy(new RealObject());
        consumer(simpleProxy);
        System.out.println(simpleProxy);
    }
}
