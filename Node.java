
/**
 * Node represents a node in a linked list.
 *
 * @author Java Foundations, mvail
 * @version 4.0
 */
public class Node<T> {

    private Node<T> next;
    private T element;
    private Node<T> previous;

    /**
     * Creates an empty node.
     */
    public Node() {
        next = null;
        element = null;
        previous = null;

    }

    /**
     * Returns the node that trails this one
     * 
     * @return the node that trails this one
     */
    public Node<T> getPrevious(){
        return previous;
    }

    /**
     * Sets the Node that trails this one
     *
     * 
     * @param node the node to be set to trail the current one
     */
    public void setPrevious(Node<T> previous){
        this.previous = previous;
    }

    /**
     * creates a node storing the specified element
     * 
     * @param elem
     * the element can be stored within new node
     */
    public Node(T elem) {
        previous = null;
        next = null; 
        element = elem;
    }



    /**
     * Returns the node that follows this one.
     *
     * @return the node that follows the current one
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one.
     *
     * @param node the node to be set to follow the current one
     */
    public void setNext(Node<T> node) {
        next = node;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return the element stored in this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param elem the element to be stored in this node
     */
    public void setElement(T elem) {
        element = elem;
    }

    @Override
    public String toString() {
        return "Element: " + element.toString() + " Has next: " + (next != null) + " Has previous" + (previous != null);
    }
}
