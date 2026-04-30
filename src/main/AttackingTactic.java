package main;

public class AttackingTactic implements TacticStrategy {
    
    @Override
    public String getFormation() {
        return "4-3-3 (Attacking)";
    }
    
    @Override
    public int getAttackBonus() {
        return 15; 
    }
    
    @Override
    public int getDefenseBonus() {
        return -5; 
    }
    
    @Override
    public void execute() {
        System.out.println("Using attacking formation: " + getFormation());
        System.out.println("Attack bonus: +" + getAttackBonus());
        System.out.println("Defense penalty: " + getDefenseBonus());
    }
}
