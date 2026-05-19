import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Soccer Simulator - Sprint 2 ===\n");

        // Create a simple team
        ArrayList<Player> team = new ArrayList<>();
        team.add(new Player("Messi", "Forward", 95));
        team.add(new Player("Ronaldo", "Forward", 94));
        team.add(new Player("Ramos", "Defender", 88));

        // Display team
        System.out.println("Team Roster:");
        for (Player player : team) {
            System.out.println("  " + player);
        }

        System.out.println("\nSprint 2 Complete: Player class and ArrayList demonstrated!");
    }
}
