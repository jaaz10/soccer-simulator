package main;

public class DefensiveTactic implements TacticStrategy {
    
    @Override
    public String getFormation() {
        return "5-4-1 (Defensive)";
    }
    
    @Override
    public int getAttackBonus() {
        return -5;
    }
    
    @Override
    public int getDefenseBonus() {
        return 15; 
    }
    
    @Override
    public void execute() {
        System.out.println("Using defensive formation: " + getFormation());
        System.out.println("Attack penalty: " + getAttackBonus());
        System.out.println("Defense bonus: +" + getDefenseBonus());
    }
}
