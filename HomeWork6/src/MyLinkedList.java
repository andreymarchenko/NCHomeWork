import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node firstNode = null;
    private Node lastNode = null;
    private int size = 0;

    @Override
    public void add(E element) {
        Node<E> newNode = new Node<E>();
        newNode.setElement(element);
        if (lastNode == null) {
            firstNode = newNode;
            lastNode = newNode;
            size++;
        } else {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
            size++;
        }
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = this.firstNode;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index - 1; i++) {
                node = node.getNextNode();
            }
            Node<E> newNode = new Node<E>(element);
            newNode.setNextNode(node.getNextNode());
            node.setNextNode(newNode);
            size++;
        }
    }

    @Override
    public void clear() {
        this.firstNode = null;
        this.lastNode = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> node = this.firstNode;
        if (index >= 0 && index < this.size) {
            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
            }
        }
        return node.getElement();
    }

    public Node getNode(int index) {
        Node<E> node = this.firstNode;
        if (index >= 0 && index < this.size) {
            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
            }
        }
        return node;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = this.firstNode;
        for (int i = 0; i < size; i++) {
            if (node.getElement() == element)
                return i;
            else node = node.getNextNode();
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        Node<E> node = this.firstNode;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index - 1; i++) {
                node = node.getNextNode();
            }
            node.setNextNode(node.getNextNode().getNextNode());
        }
        size--;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = this.firstNode;
        Object oldElement = null;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
                oldElement = node.getElement();
            }
            node.setElement(element);
        }
        return (E) oldElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        Object[] array = new Object[size];
        Node<E> node = this.firstNode;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                array[i] = node;
                node = node.getNextNode();
            }
        }
        return (E[]) array;
    }

    @Override
    public String toString() {
        String str = "";
        Node<E> node = this.firstNode;
        if (this.size()!=0) {
            for (int i = 0; i < size; i++) {
                str += node.getElement().toString() + " ";
                node = node.getNextNode();
            }
        }
        return str;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(this);
    }
}

class MyIterator implements Iterator {
    private int index = -1;
    private MyLinkedList myLinkedList;

    public MyIterator(MyLinkedList list) {
        this.myLinkedList = list;
    }

    @Override
    public boolean hasNext() {
        if (index < myLinkedList.size()) return true;
        else return false;
    }

    @Override
    public Node next() throws NullPointerException{
        Node result = myLinkedList.getNode(index);
        index++;
        return result;
    }
}
