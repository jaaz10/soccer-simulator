// Concrete State - Half Time
public class HalfTimeState implements MatchState {
    private Match match;
    
    public HalfTimeState(Match match) {
        this.match = match;
    }
    
    @Override
    public void startMatch() {
        System.out.println("▶️ Second Half started!");
        match.setState(match.getSecondHalfState());
    }
    
    @Override
    public void endHalf() {
        System.out.println("❌ Already at half time!");
    }
    
    @Override
    public void endMatch() {
        System.out.println("❌ Cannot end match during half time!");
    }
    
    @Override
    public String getStateName() {
        return "Half Time";
    }
    
    @Override
    public boolean canScore() {
        return false; // Can't score during half time!
    }
}
