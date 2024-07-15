
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        
        HashMap<Integer, LinkedList<String>> hm = new HashMap<>();

        HashMap.addToMap(hm, 1, "Apple");
        HashMap.addToMap(hm, 2, "Banana");
        HashMap.addToMap(hm, 3, "Cherry");

        System.out.println("Hash Map:");
        hm.printData();

        System.out.println("contains key 3: " + hm.containsKey(3));

        System.out.println("Values for key 3: " + hm.get(3));

        
        hm.remove(3);
        
        System.out.println("Map after remove key 3:");
        hm.printData();

       
        
        hm.clear();
        System.out.println("Hash Map:");
        hm.printData();
    }
}
