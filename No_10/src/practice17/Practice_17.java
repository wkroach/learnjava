/**
 * Create a class containing a nested class.
 * In main(), create an instance of the nested
 * class.
 */
package practice17;

public class Practice_17 {
    static public void playGame(GameFactory factory){
        factory.getGame().play();
    }
    static public void main(String[] args){
       playGame(Coin.gameFactory);
       playGame(Dice.gameFactory);
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
    static public GameFactory gameFactory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Coin();
        }
    };
}
class Dice implements Game{
    @Override
    public void play(){
        System.out.println("Dice");
    }
    static public GameFactory gameFactory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Dice();
        }
    };
}

interface GameFactory{
    Game getGame();
}

