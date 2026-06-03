import java.util.ArrayList;
import java.util.List;

// Context - maintains current state and delegates behavior
public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private final List<MatchObserver> observers = new ArrayList<>();
    
    // States
    private MatchState preMatchState;
    private MatchState firstHalfState;
    private MatchState halfTimeState;
    private MatchState secondHalfState;
    private MatchState fullTimeState;
    
    private MatchState currentState;
    
    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        
        // Initialize all states
        this.preMatchState = new PreMatchState(this);
        this.firstHalfState = new FirstHalfState(this);
        this.halfTimeState = new HalfTimeState(this);
        this.secondHalfState = new SecondHalfState(this);
        this.fullTimeState = new FullTimeState(this);
        
        // Start in PreMatch state
        this.currentState = preMatchState;
        
        System.out.println("\n⚽ Match created: " + homeTeam.getName() + " vs " + awayTeam.getName());
        System.out.println("📊 Current State: " + currentState.getStateName());
        notifyObservers("Match scheduled: " + homeTeam.getName() + " vs " + awayTeam.getName());
    }

    public void addObserver(MatchObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String event) {
        for (MatchObserver observer : observers) {
            observer.update(event);
        }
    }
    
    // State getters (needed by concrete states)
    public MatchState getPreMatchState() { return preMatchState; }
    public MatchState getFirstHalfState() { return firstHalfState; }
    public MatchState getHalfTimeState() { return halfTimeState; }
    public MatchState getSecondHalfState() { return secondHalfState; }
    public MatchState getFullTimeState() { return fullTimeState; }
    
    // Set current state
    public void setState(MatchState state) {
        this.currentState = state;
        System.out.println("📊 Current State: " + currentState.getStateName());
        notifyObservers("State: " + currentState.getStateName());
    }
    
    // Delegate to current state
    public void startMatch() {
        currentState.startMatch();
    }
    
    public void endHalf() {
        currentState.endHalf();
    }
    
    public void endMatch() {
        currentState.endMatch();
    }
    
    public void scoreGoal(String team, String player) {
        if (currentState.canScore()) {
            if (team.equals(homeTeam.getName())) {
                homeScore++;
            } else {
                awayScore++;
            }
            System.out.println("⚽ GOAL! " + player + " scores for " + team + 
                             " | Score: " + homeTeam.getName() + " " + homeScore + 
                             " - " + awayScore + " " + awayTeam.getName());
            notifyObservers("GOAL! " + player + " (" + team + ") — " +
                homeTeam.getName() + " " + homeScore + " - " + awayScore + " " + awayTeam.getName());
        } else {
            System.out.println("❌ Cannot score in " + currentState.getStateName() + " state!");
            notifyObservers("No goal — play stopped in " + currentState.getStateName());
        }
    }
    
    public void displayMatchInfo() {
        System.out.println("\n=== Match Info ===");
        System.out.println(homeTeam.getName() + " " + homeScore + " - " + awayScore + " " + awayTeam.getName());
        System.out.println("State: " + currentState.getStateName());
    }
}
