public class AttackingTactic implements TacticStrategy {
    @Override
    public void execute() {
        System.out.println("⚡ Executing ATTACKING tactic:");
        System.out.println("   - Focus on offense");
        System.out.println("   - More forwards pushing up");
        System.out.println("   - High pressing");
    }

    @Override
    public String getDescription() {
        return "Attacking (4-3-3)";
    }
}
