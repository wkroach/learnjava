/**
 * 用工厂模式实现一个简单游戏的框架
 */
package practice19;

public class Practice_19 {
    static public void playGame(GameFactory factory){
        factory.getGame().play();
    }
    static public void main(String[] args){
       playGame(new CoinFactory());
       playGame(new DiceFactory());
    }
}

interface Game{
    void play();
}
class Coin implements Game{
    @Override
    public void play(){
        System.out.println("Coin");
    }
}
class Dice implements Game{
    @Override
    public void play(){
        System.out.println("Dice");
    }
}

interface GameFactory{
    Game getGame();
}
class CoinFactory implements GameFactory{
    @Override
    public Coin getGame(){
        return new Coin();
    }
}
class DiceFactory implements GameFactory{
    @Override
    public Dice getGame(){
        return new Dice();
    }
}
