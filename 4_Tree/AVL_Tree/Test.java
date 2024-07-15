
public class Test {
    public static void main(String[] args) {
        
        AVL<Integer> avl = new AVL<>();
        avl.insert(10);
        avl.insert(20);
        avl.insert(5);
        avl.insert(6);
        avl.insert(15);
        System.out.println("AVL:");
        avl.print();
        System.out.println("\n"+"Tree structure:");
        System.out.println(avl.traverseLevel());

    }
}

