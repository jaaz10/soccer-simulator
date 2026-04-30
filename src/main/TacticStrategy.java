package main;

public interface TacticStrategy {
    String getFormation();
    int getAttackBonus();
    int getDefenseBonus();
    void execute();
}
