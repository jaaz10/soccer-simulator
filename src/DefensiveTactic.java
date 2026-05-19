public class DefensiveTactic implements TacticStrategy {
    @Override
    public void execute() {
        System.out.println("🛡️ Executing DEFENSIVE tactic:");
        System.out.println("   - Focus on defense");
        System.out.println("   - More defenders back");
        System.out.println("   - Counter-attack style");
    }

    @Override
    public String getDescription() {
        return "Defensive (5-4-1)";
    }
}
