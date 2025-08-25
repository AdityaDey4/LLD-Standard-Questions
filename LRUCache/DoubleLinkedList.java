package LRUCache;

public class DoubleLinkedList {

    Node start;
    Node end;

    DoubleLinkedList() {
        start = new Node(-1, -1);
        end = new Node(-1, -1);

        start.next = end;
        end.prev = start;
    }

    public Node getEnd() {
        return end.prev;
    }
    
    public void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    } 

    public void add(Node node) {
        Node first = start.next;
        first.prev = node;
        start.next = node;

        node.next = first;
        node.prev = start;
    }
}