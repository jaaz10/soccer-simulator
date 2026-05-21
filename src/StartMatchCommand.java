public class StartMatchCommand implements Command {
    private final Match match;

    public StartMatchCommand(Match match) {
        this.match = match;
    }

    @Override
    public void execute() {
        match.startMatch();
    }
}
