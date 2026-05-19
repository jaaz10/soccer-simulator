import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Soccer Simulator ===");
        System.out.println("Hello World - Sprint 1");
        System.out.println("\nProject started up successfully!");
        
        // Basic test
        Random random = new Random();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Test");
        
        System.out.println("Random test: " + random.nextInt(100));
        System.out.println("ArrayList test: " + testList.get(0));
    }
}
