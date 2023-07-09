package models;

public class Node {
  private Node yes;
  private Node no;
  private String value;

  public Node() {
  }

  public Node(String food) {
    this.value = food;
  }

  public Node getYes() {
    return yes;
  }

  public void setYes(Node yes) {
    this.yes = yes;
  }

  public Node getNo() {
    return no;
  }

  public void setNo(Node no) {
    this.no = no;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public boolean hasFood(){
    return this.getValue() != null && !this.getValue().isEmpty();
  }
  public boolean isLeaf(){
    return this.getNo() == null && this.getYes() == null;
  }
}
