// Concrete State - Full Time
public class FullTimeState implements MatchState {
    private Match match;
    
    public FullTimeState(Match match) {
        this.match = match;
    }
    
    @Override
    public void startMatch() {
        System.out.println("❌ Match already finished!");
    }
    
    @Override
    public void endHalf() {
        System.out.println("❌ Match already finished!");
    }
    
    @Override
    public void endMatch() {
        System.out.println("❌ Match already finished!");
    }
    
    @Override
    public String getStateName() {
        return "Full Time";
    }
    
    @Override
    public boolean canScore() {
        return false;
    }
}
