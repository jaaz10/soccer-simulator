import java.util.ArrayList;

public class TeamBuilder {
    private String name;
    private ArrayList<Player> players;
    private TacticStrategy tactic;
    
    public TeamBuilder() {
        this.players = new ArrayList<>();
        this.tactic = new AttackingTactic(); // Default
    }
    
    public TeamBuilder setName(String name) {
        this.name = name;
        return this;
    }
    
    public TeamBuilder addPlayer(String playerName, String position) {
        PlayerCreator creator = getCreatorForPosition(position);
        this.players.add(creator.recruitPlayer(playerName));
        return this;
    }
    
    private PlayerCreator getCreatorForPosition(String position) {
        switch (position.toLowerCase()) {
            case "forward":
                return new ForwardCreator();
            case "midfielder":
                return new MidfielderCreator();
            case "defender":
                return new DefenderCreator();
            case "goalkeeper":
                return new GoalkeeperCreator();
            default:
                throw new IllegalArgumentException("Unknown position: " + position);
        }
    }
    
    public TeamBuilder setTactic(TacticStrategy tactic) {
        this.tactic = tactic;
        return this;
    }
    
    public Team build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Team name is required!");
        }
        
        Team team = new Team(name);
        for (Player player : players) {
            team.addPlayer(player);
        }
        team.setTactic(tactic);
        
        System.out.println("🏗️ Team '" + name + "' built successfully!\n");
        return team;
    }
}
