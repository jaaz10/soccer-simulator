public class ScoreGoalCommand implements Command {
    private final Match match;
    private final String teamName;
    private final String playerName;

    public ScoreGoalCommand(Match match, String teamName, String playerName) {
        this.match = match;
        this.teamName = teamName;
        this.playerName = playerName;
    }

    @Override
    public void execute() {
        match.scoreGoal(teamName, playerName);
    }

    @Override
    public String getName() {
        return "ScoreGoal(" + playerName + ", " + teamName + ")";
    }
}
