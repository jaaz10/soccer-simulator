package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Soccer Simulator - Design Patterns Demo ===\n");
        
        // FACTORY PATTERN DEMO
        System.out.println("--- Factory Pattern Demo ---");
        Player striker = PlayerFactory.createPlayer("Rodriguez", "striker");
        Player midfielder = PlayerFactory.createPlayer("Chen", "midfielder");
        Player defender = PlayerFactory.createPlayer("Smith", "defender");
        Player goalkeeper = PlayerFactory.createPlayer("Martinez", "goalkeeper");
        
        System.out.println("Created " + striker.getName() + " (Striker) - Skill: " + striker.getSkillLevel());
        System.out.println("Created " + midfielder.getName() + " (Midfielder) - Skill: " + midfielder.getSkillLevel());
        System.out.println("Created " + defender.getName() + " (Defender) - Skill: " + defender.getSkillLevel());
        System.out.println("Created " + goalkeeper.getName() + " (Goalkeeper) - Skill: " + goalkeeper.getSkillLevel());
        
        // STRATEGY PATTERN DEMO
        System.out.println("\n--- Strategy Pattern Demo ---");
        System.out.println("\nTeam A choosing attacking strategy:");
        TacticStrategy attackingStrategy = new AttackingTactic();
        attackingStrategy.execute();
        
        System.out.println("\nTeam B choosing defensive strategy:");
        TacticStrategy defensiveStrategy = new DefensiveTactic();
        defensiveStrategy.execute();
        
        System.out.println("\n=== Demo Complete ===");
    }
}
