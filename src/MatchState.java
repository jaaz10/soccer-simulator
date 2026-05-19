// State Interface
public interface MatchState {
    void startMatch();
    void endHalf();
    void endMatch();
    String getStateName();
    boolean canScore();
}
