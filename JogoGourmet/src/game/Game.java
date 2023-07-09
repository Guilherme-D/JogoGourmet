package game;

import models.DecisionTree;
import models.Node;
import views.UiMessages;

public class Game {

  public void run(DecisionTree tree) {
    while(true){

      boolean pressedOk = UiMessages.askFoodYouLike();

      //close the window if user press 'X'
      if(!pressedOk) break;

      //start guessing
      this.guess(tree.getNode(), tree.getNode(),null);
    }

  }

  private void guess(Node currentNode, Node rootNode, Boolean side) {

    boolean youThoughtAbout = UiMessages.askWhatYouThoughtAbout(currentNode.getValue());

    //check if choose the 'yes' or 'no' side from root
    boolean chooseYesSide = side == null? currentNode.equals(rootNode) && youThoughtAbout : side;

    //check if founded
    if (hasFound(currentNode, rootNode, youThoughtAbout, chooseYesSide)) {
      return;
    }

    //recursively checks next yes or no Models.Node
    if(youThoughtAbout){
      this.guess(currentNode.getYes(), rootNode, chooseYesSide);
    }else{
      this.guess(currentNode.getNo(), rootNode, chooseYesSide);
    }

  }

  private boolean hasFound(Node currentNode, Node rootNode, boolean answer, boolean chooseYesSide) {
    //if answer 'yes' in a leaf node, say that it hits else add new node
    if(currentNode.isLeaf()) {
      if (answer) {
        UiMessages.sayHitAgain();
      } else {
        this.addNewNodes(currentNode, rootNode, chooseYesSide);
      }
      return true;
    }

    return false;
  }

  private void addNewNodes(Node node, Node rootNode, boolean chooseYesSide){

    //asks for food and hint
    String food = UiMessages.askFood();
    String hint = UiMessages.askHint(food, node.getValue());

    Node hintNode = new Node(hint);
    Node leafNode = new Node(food);

    //add leaf node to hint
    hintNode.setYes(leafNode);

    //add new hint to rootNode 'yes' or 'no'
    if(chooseYesSide) {
      hintNode.setNo(rootNode.getYes());
      rootNode.setYes(hintNode);
    }else{
      hintNode.setNo(rootNode.getNo());
      rootNode.setNo(hintNode);
    }
  }
}
