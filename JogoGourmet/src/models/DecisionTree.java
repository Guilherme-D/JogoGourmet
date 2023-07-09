package models;

public class DecisionTree {

  Node node;

  public DecisionTree() {
    Node currentNode = new Node("massa");
    Node rootNo = new Node("Bolo de Chocolate");
    Node rootYes = new Node("Lasanha");

    currentNode.setYes(rootYes);
    currentNode.setNo(rootNo);

    this.node = currentNode;
  }

  public Node getNode() {
    return node;
  }

  public void setNode(Node node) {
    this.node = node;
  }
}
