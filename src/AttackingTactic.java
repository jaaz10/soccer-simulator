public class AttackingTactic implements TacticStrategy {
    
    @Override
    public int calculateAttackBonus() {
        return 15; // +15 attack bonus
    }
    
    @Override
    public int calculateDefenseBonus() {
        return -5; // -5 defense penalty
    }
    
    @Override
    public String getTacticName() {
        return "Attacking (4-3-3)";
    }
}
