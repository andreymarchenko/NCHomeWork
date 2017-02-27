public class Node<E> {
    private E element;
    private Node nextNode;

    public Node() {

    }

    public Node(E element) {
        this.element = element;
        nextNode = null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
