public class Main {
    public static void main(String[] args) {
        System.out.println("=== Soccer Simulator - Sprint 4: STATE PATTERN ===");
        System.out.println("Design Patterns: Factory Method, Strategy, Singleton, Builder, STATE\n");

        // Build teams
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

        System.out.println("\n--- STATE PATTERN DEMO ---");
        
        // Create match
        Match match = new Match(brazil, argentina);
        
        // Try to score before match starts
        System.out.println("\n--- Trying to score before match starts ---");
        match.scoreGoal("Brazil 🇧🇷", "Neymar");
        
        // Start match
        System.out.println("\n--- Starting Match ---");
        match.startMatch();
        
        // Score some goals in first half
        System.out.println("\n--- First Half Goals ---");
        match.scoreGoal("Brazil 🇧🇷", "Neymar");
        match.scoreGoal("Argentina 🇦🇷", "Lionel Messi");
        
        // End first half
        System.out.println("\n--- Ending First Half ---");
        match.endHalf();
        
        // Try to score during half time
        System.out.println("\n--- Trying to score during half time ---");
        match.scoreGoal("Brazil 🇧🇷", "Neymar");
        
        // Start second half
        System.out.println("\n--- Starting Second Half ---");
        match.startMatch();
        
        // Score in second half
        System.out.println("\n--- Second Half Goals ---");
        match.scoreGoal("Argentina 🇦🇷", "Lionel Messi");
        match.scoreGoal("Brazil 🇧🇷", "Neymar");
        
        // End match
        System.out.println("\n--- Ending Match ---");
        match.endMatch();
        
        // Try to score after match ends
        System.out.println("\n--- Trying to score after match ends ---");
        match.scoreGoal("Brazil 🇧🇷", "Neymar");
        
        // Display final info
        match.displayMatchInfo();
        
        System.out.println("\n=== STATE PATTERN Demonstrated! ===");
        System.out.println("✅ Match transitions through states: PreMatch → FirstHalf → HalfTime → SecondHalf → FullTime");
        System.out.println("✅ Each state has different behaviors (can/cannot score)");
        System.out.println("✅ State transitions happen automatically");
    }
}
