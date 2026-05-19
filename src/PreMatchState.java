// Concrete State - PreMatch
public class PreMatchState implements MatchState {
    private Match match;
    
    public PreMatchState(Match match) {
        this.match = match;
    }
    
    @Override
    public void startMatch() {
        System.out.println("⏱️ Match started! Switching to First Half");
        match.setState(match.getFirstHalfState());
    }
    
    @Override
    public void endHalf() {
        System.out.println("❌ Cannot end half - match hasn't started yet!");
    }
    
    @Override
    public void endMatch() {
        System.out.println("❌ Cannot end match - match hasn't started yet!");
    }
    
    @Override
    public String getStateName() {
        return "Pre-Match";
    }
    
    @Override
    public boolean canScore() {
        return false;
    }
}
