
import java.util.ArrayList;

public class MaxHeap<T> {
    private ArrayList<Node<T>> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(T value, int priority) {
        Node<T> node = new Node<>(value, priority);
        heap.add(node);
        siftUp(heap.size() - 1);
    }

    public T extractMax() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        Node<T> maxNode = heap.get(0);
        Node<T> lastNode = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastNode);
            siftDown(0);
        }

        return maxNode.getValue();
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap.get(index).getPriority() > heap.get(parentIndex).getPriority()) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).getPriority() > heap.get(largestIndex).getPriority()) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).getPriority() > heap.get(largestIndex).getPriority()) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            siftDown(largestIndex);
        }
    }

    private void swap(int i, int j) {
        Node<T> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printData() {
        if (isEmpty()) {
            System.out.println("Max Heap is empty");
        } else {
            for (Node<T> node : heap) {
                System.out.println("Value: " + node.getValue() + ", Priority: " + node.getPriority());
            }
        }
    }
}
