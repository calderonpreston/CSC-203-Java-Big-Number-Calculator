public class Node {

   private Node next;
   private int value;


   public Node(int value, Node next) {
      this.value = value;
      this.next = next;
   }

   public int getValue(){return value;}

   public void setNext(Node next){
      this.next = next;
   }

   public void setValue(int value) {
      this.value = value;
   }

   public Node getNext(){return next;}
}
