package main;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing Random for Soccer Simulator ===\n");
        
        Random random = new Random();
        
        // Test random number generation
        System.out.println("Rolling dice 5 times (0-100):");
        for (int i = 1; i <= 5; i++) {
            int roll = random.nextInt(100);
            System.out.println("Roll " + i + ": " + roll);
        }
        
        // Test coin flip
        System.out.println("\nCoin flip: " + (random.nextBoolean() ? "Team A attacks" : "Team B attacks"));
        
        // Test player
        Player player = new Player("Messi", 85);
        System.out.println("\nCreated player: " + player.getName() + " (Skill: " + player.getSkillLevel() + ")");
    }
}
