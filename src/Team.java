import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;
    private TacticStrategy tactic;
    
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.tactic = new AttackingTactic(); // Default
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public void setTactic(TacticStrategy tactic) {
        this.tactic = tactic;
        System.out.println(name + " changed tactic to: " + tactic.getTacticName());
    }
    
    public void displayRoster() {
        System.out.println("\n" + name + " Roster:");
        for (Player player : players) {
            System.out.println("  " + player.getName() + " (" + player.getPosition() + 
                             ", Skill: " + player.getSkillLevel() + ")");
        }
    }
    
    public void displayTacticalStats() {
        System.out.println("\n" + name + " is using " + tactic.getTacticName());
        System.out.println("⚔️ Attack Bonus: " + tactic.calculateAttackBonus());
        System.out.println("🛡️ Defense Bonus: " + tactic.calculateDefenseBonus());
    }
    
    public String getName() {
        return name;
    }
}
