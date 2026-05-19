import java.util.ArrayList;

public class WorldCup {
    // Singleton instance
    private static WorldCup instance;
    
    private String tournamentName;
    private ArrayList<Team> teams;
    
    // Private constructor prevents direct instantiation
    private WorldCup() {
        this.tournamentName = "FIFA World Cup";
        this.teams = new ArrayList<>();
        System.out.println("🏆 World Cup instance created!");
    }
    
    // Public method to get the single instance
    public static WorldCup getInstance() {
        if (instance == null) {
            instance = new WorldCup();
        }
        return instance;
    }
    
    public void addTeam(Team team) {
        teams.add(team);
        System.out.println("✅ " + team.getName() + " qualified for World Cup");
    }
    
    public void displayWorldCup() {
        System.out.println("\n=== " + tournamentName + " ===");
        System.out.println("Teams qualified: " + teams.size());
        for (Team team : teams) {
            System.out.println("  - " + team.getName());
        }
    }
    
    public String getTournamentName() {
        return tournamentName;
    }
}
