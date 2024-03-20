
public class LinkedList {

    private Node head;

    public void add(int value){
        Node node = new Node(value, null);

        node.setValue(value);
        node.setNext(null);

        if (this.head == null){
            this.head = node;
        }
        else{
            Node n = this.head;
            while (n.getNext()!=null){
                n = n.getNext();
            }
            n.setNext(node);
        }
    }
    public void addReverseOrder(int value) {
        Node newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }
    public void reverse() {
        if (head == null || head.getNext() == null) {
            return;
        }

        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);

            prev = current;
            current = next;
        }
        head = prev;
    }
    public static LinkedList addition(LinkedList linkedlist_1, LinkedList linkedlist_2) {
        LinkedList result = new LinkedList();
        Node head_1 = linkedlist_1.head;
        Node head_2 = linkedlist_2.head;
        Node current = null;
        int tmp = 0;

        while (head_1 != null || head_2 != null || tmp > 0) {
            int digit_1 = (head_1 != null) ? head_1.getValue() : 0;
            int digit_2 = (head_2 != null) ? head_2.getValue() : 0;
            int total = digit_1 + digit_2 + tmp;
            tmp = total / 10;
            int digit = total % 10;

            if (current == null) {
                current = new Node(digit, null);
                result.head = current;
            } else {
                Node n = new Node(digit, null);
                current.setNext(n);
                current = n;
            }

            if (head_1 != null) {
                head_1 = head_1.getNext();
            }
            if (head_2 != null) {
                head_2 = head_2.getNext();
            }
        }

        return result;
    }
    public static LinkedList multiplication(LinkedList linkedlist_1, LinkedList linkedlist_2) {
        LinkedList result = new LinkedList();
        Node current_1 = linkedlist_1.head;
        int position = 0;

        while (current_1 != null) {
            Node current_2 = linkedlist_2.head;
            LinkedList tmp_result = new LinkedList();
            int carry = 0;

            for (int i = 0; i < position; i++) {
                tmp_result.add(0); // Add zeros to align digits
            }

            while (current_2 != null) {
                int product = current_1.getValue() * current_2.getValue() + carry;
                carry = product / 10;
                int digit = product % 10;
                tmp_result.add(digit);
                current_2 = current_2.getNext();
            }

            if (carry > 0) {
                tmp_result.add(carry);
            }

            result = LinkedList.addition(result, tmp_result);
            current_1 = current_1.getNext();
            position++;
        }

        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList other_list = (LinkedList) o;

        Node currentNode1 = this.head;
        Node currentNode2 = other_list.head;

        while (currentNode1 != null && currentNode2 != null) {
            if (currentNode1.getValue() != currentNode2.getValue()) {
                return false;
            }
            currentNode1 = currentNode1.getNext();
            currentNode2 = currentNode2.getNext();
        }
        return currentNode1 == null && currentNode2 == null;
    }

    @Override
    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();

        Node current = head;
        while (current != null) {
            stringbuilder.append(current.getValue());
            current = current.getNext();
        }
        return stringbuilder.toString();
    }
}