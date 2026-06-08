public class Main {
    public static void main(String[] args) {
        System.out.println("=== Soccer Simulator - All Design Patterns ===");
        System.out.println("Factory Method | Strategy | Singleton | Builder | State | Command | Observer\n");

        // --- SINGLETON: one WorldCup instance for the whole app ---
        System.out.println("--- 1. SINGLETON PATTERN ---");
        WorldCup worldCup = WorldCup.getInstance();
        WorldCup sameCup = WorldCup.getInstance(); // returns existing instance, no second constructor call
        System.out.println("Same instance? " + (worldCup == sameCup));

        // --- BUILDER + FACTORY METHOD: step-by-step teams, creators make players by
        // position ---
        System.out.println("\n--- 2. BUILDER + FACTORY METHOD PATTERNS ---");
        Team brazil = new TeamBuilder()
                .setName("Brazil 🇧🇷")
                .addPlayer("Neymar", "Forward") // ForwardCreator (Factory Method)
                .addPlayer("Casemiro", "Midfielder") // MidfielderCreator
                .addPlayer("Marquinhos", "Defender") // DefenderCreator
                .addPlayer("Alisson", "Goalkeeper") // GoalkeeperCreator
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

        worldCup.addTeam(brazil);
        worldCup.addTeam(argentina);
        worldCup.displayWorldCup();

        // --- STRATEGY: swap tactics at runtime, different bonus calculations ---
        System.out.println("\n--- 3. STRATEGY PATTERN ---");
        brazil.displayTacticalStats();
        argentina.displayTacticalStats();

        System.out.println("\nBrazil switches tactic mid-demo:");
        brazil.setTactic(new DefensiveTactic());
        brazil.displayTacticalStats();

        // --- STATE + COMMAND (Sprint 4): phases control rules; commands trigger
        // actions ---
        System.out.println("\n--- 4. STATE + COMMAND PATTERNS (Sprint 4) ---");
        Match match = new Match(brazil, argentina);
        MatchController controller = new MatchController();

        System.out.println("\nTrying to score before match starts (State blocks it):");
        controller.run(new ScoreGoalCommand(match, "Brazil 🇧🇷", "Neymar"));

        System.out.println("\nStarting match:");
        controller.run(new StartMatchCommand(match));

        System.out.println("\nFirst half goals:");
        controller.run(new ScoreGoalCommand(match, "Brazil 🇧🇷", "Neymar"));
        controller.run(new ScoreGoalCommand(match, "Argentina 🇦🇷", "Lionel Messi"));

        System.out.println("\nEnding first half:");
        controller.run(new EndHalfCommand(match));

        System.out.println("\nTrying to score during half time (State blocks it):");
        controller.run(new ScoreGoalCommand(match, "Brazil 🇧🇷", "Neymar"));

        System.out.println("\nStarting second half:");
        controller.run(new StartMatchCommand(match));

        System.out.println("\nSecond half goals:");
        controller.run(new ScoreGoalCommand(match, "Argentina 🇦🇷", "Lionel Messi"));
        controller.run(new ScoreGoalCommand(match, "Brazil 🇧🇷", "Neymar"));

        System.out.println("\nEnding match:");
        controller.run(new EndMatchCommand(match));

        System.out.println("\nTrying to score after full time (State blocks it):");
        controller.run(new ScoreGoalCommand(match, "Brazil 🇧🇷", "Neymar"));

        match.displayMatchInfo();

        // --- OBSERVER (Sprint 5): Match notifies listeners; CommentaryObserver prints
        // events ---
        System.out.println("\n--- 5. OBSERVER PATTERN (Sprint 5) ---");
        System.out.println("Subscribe CommentaryObserver — live 📢 lines on goals and state changes:\n");

        Match observedMatch = new Match(brazil, argentina);
        observedMatch.addObserver(new CommentaryObserver());

        controller.run(new StartMatchCommand(observedMatch));
        controller.run(new ScoreGoalCommand(observedMatch, "Brazil 🇧🇷", "Neymar"));
        controller.run(new ScoreGoalCommand(observedMatch, "Argentina 🇦🇷", "Lionel Messi"));
        controller.run(new EndHalfCommand(observedMatch));
        controller.run(new StartMatchCommand(observedMatch));
        controller.run(new ScoreGoalCommand(observedMatch, "Brazil 🇧🇷", "Neymar"));
        controller.run(new EndMatchCommand(observedMatch));

        observedMatch.displayMatchInfo();

        System.out.println("\nCommand History:");
        controller.printHistory();

        System.out.println("\n=== All Patterns Demonstrated ===");
        System.out.println("✅ Singleton     - WorldCup.getInstance()");
        System.out.println("✅ Builder       - TeamBuilder builds teams step by step");
        System.out.println("✅ Factory Method - PlayerCreator makes players by position");
        System.out.println("✅ Strategy      - AttackingTactic / DefensiveTactic swapped on Team");
        System.out.println("✅ State         - Match phases control when scoring is allowed");
        System.out.println("✅ Command       - MatchController runs Start/End/Score commands");
        System.out.println("✅ Observer      - CommentaryObserver gets goals and state changes from Match");
    }
}
