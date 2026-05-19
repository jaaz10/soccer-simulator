// Concrete State - First Half
public class FirstHalfState implements MatchState {
    private Match match;
    
    public FirstHalfState(Match match) {
        this.match = match;
    }
    
    @Override
    public void startMatch() {
        System.out.println("❌ Match already started!");
    }
    
    @Override
    public void endHalf() {
        System.out.println("⏸️ Half Time! Switching to Half Time break");
        match.setState(match.getHalfTimeState());
    }
    
    @Override
    public void endMatch() {
        System.out.println("❌ Cannot end match - still in first half!");
    }
    
    @Override
    public String getStateName() {
        return "First Half";
    }
    
    @Override
    public boolean canScore() {
        return true;
    }
}
