// Concrete State - Second Half
public class SecondHalfState implements MatchState {
    private Match match;
    
    public SecondHalfState(Match match) {
        this.match = match;
    }
    
    @Override
    public void startMatch() {
        System.out.println("❌ Match already in progress!");
    }
    
    @Override
    public void endHalf() {
        System.out.println("❌ Cannot end half - this is the second half!");
    }
    
    @Override
    public void endMatch() {
        System.out.println("🏁 Match Ended! Final whistle!");
        match.setState(match.getFullTimeState());
    }
    
    @Override
    public String getStateName() {
        return "Second Half";
    }
    
    @Override
    public boolean canScore() {
        return true;
    }
}
