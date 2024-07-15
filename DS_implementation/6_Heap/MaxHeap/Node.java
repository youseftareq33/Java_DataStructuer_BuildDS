
public class Node<T> {
    private T value;
    private int priority;

    public Node(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public T getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }
}