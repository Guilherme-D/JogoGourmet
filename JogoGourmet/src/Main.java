import game.Game;
import models.DecisionTree;

public class Main {

  public static void main(String[] args) {
    Game game = new Game();
    game.run(new DecisionTree());
  }
}
