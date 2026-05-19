public class Main {
    public static void main(String[] args) {
        System.out.println("=== Soccer Simulator - Sprint 3 REFACTORED ===");
        System.out.println("Design Patterns: Factory Method, Strategy, Singleton, Builder\n");

        // ===== SINGLETON PATTERN DEMO =====
        System.out.println("--- Singleton Pattern ---");
        
        WorldCup worldCup1 = WorldCup.getInstance();
        WorldCup worldCup2 = WorldCup.getInstance();
        
        if (worldCup1 == worldCup2) {
            System.out.println("✅ Both references point to the SAME World Cup instance");
        }
        System.out.println();

        // ===== BUILDER + FACTORY METHOD PATTERN DEMO =====
        System.out.println("--- Builder + Factory Method Pattern ---");
        
        Team brazil = new TeamBuilder()
            .setName("Brazil 🇧🇷")
            .addPlayer("Neymar", "Forward")
            .addPlayer("Casemiro", "Midfielder")
            .addPlayer("Marquinhos", "Defender")
            .addPlayer("Alisson", "Goalkeeper")
            .setTactic(new AttackingTactic())
            .build();
        
        Team argentina = new TeamBuilder()
            .setName("Argentina 🇦🇷")
            .addPlayer("Lionel Messi", "Forward")
            .addPlayer("Rodrigo De Paul", "Midfielder")
            .addPlayer("Nicolas Otamendi", "Defender")
            .addPlayer("Emiliano Martinez", "Goalkeeper")
            .setTactic(new DefensiveTactic())
            .build();

        // ===== DISPLAY ROSTERS =====
        brazil.displayRoster();
        argentina.displayRoster();
        System.out.println("\n✅ Factory Method Pattern: Position-specific creators");
        System.out.println();

        // ===== STRATEGY PATTERN DEMO =====
        System.out.println("--- Strategy Pattern Demo (Focused Calcs) ---");
        
        brazil.displayTacticalStats();
        argentina.displayTacticalStats();
        
        System.out.println("\n--- Argentina Switches to Attacking! ---");
        argentina.setTactic(new AttackingTactic());
        argentina.displayTacticalStats();
        
        System.out.println("\n✅ Strategy Pattern: Dynamic bonus calcs");
        System.out.println();

        // ===== ADD TEAMS TO WORLD CUP =====
        WorldCup worldCup = WorldCup.getInstance();
        worldCup.addTeam(brazil);
        worldCup.addTeam(argentina);
        worldCup.displayWorldCup();
        
        System.out.println("\n=== All 4 Design Patterns Demonstrated! ===");
        System.out.println("✅ Factory Method Pattern - Position-specific player creators");
        System.out.println("✅ Strategy Pattern - Focused tactical bonus calculations");
        System.out.println("✅ Singleton Pattern - One World Cup instance");
        System.out.println("✅ Builder Pattern - Team building");
    }
}
