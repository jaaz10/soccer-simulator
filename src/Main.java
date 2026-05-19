public class Main {
    public static void main(String[] args) {
        System.out.println("=== Soccer Simulator - Sprint 3: Design Patterns ===\n");

        // ===== FACTORY PATTERN DEMO =====
        System.out.println("--- Factory Pattern Demo ---");
        Team team1 = new Team("Barcelona");
        
        // Factory creates players with position-specific skills
        team1.addPlayer(PlayerFactory.createPlayer("Messi", "Forward"));
        team1.addPlayer(PlayerFactory.createPlayer("Xavi", "Midfielder"));
        team1.addPlayer(PlayerFactory.createPlayer("Pique", "Defender"));
        team1.addPlayer(PlayerFactory.createPlayer("Ter Stegen", "Goalkeeper"));
        
        team1.displayRoster();
        System.out.println("✅ Factory Pattern: Centralized player creation\n");

        // ===== STRATEGY PATTERN DEMO =====
        System.out.println("\n--- Strategy Pattern Demo ---");
        Team team2 = new Team("Real Madrid");
        
        team2.addPlayer(PlayerFactory.createPlayer("Benzema", "Forward"));
        team2.addPlayer(PlayerFactory.createPlayer("Modric", "Midfielder"));
        
        // Default tactic (Attacking)
        team2.executeTactic();
        
        // Change tactic dynamically
        System.out.println("\n--- Changing Tactics ---");
        team2.setTactic(new DefensiveTactic());
        team2.executeTactic();
        
        System.out.println("\n--- Switching Back ---");
        team2.setTactic(new AttackingTactic());
        team2.executeTactic();
        
        System.out.println("\n✅ Strategy Pattern: Dynamic behavior changes\n");
        
        System.out.println("\n=== Both Design Patterns Demonstrated! ===");
    }
}
