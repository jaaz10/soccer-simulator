
public class DefensiveTactic implements TacticStrategy {
    
    @Override
    public int calculateAttackBonus() {
        return -5; // -5 attack penalty
    }
    
    @Override
    public int calculateDefenseBonus() {
        return 15; // +15 defense bonus
    }
    
    @Override
    public String getTacticName() {
        return "Defensive (5-4-1)";
    }
}
