public class EndMatchCommand implements Command {
    private final Match match;

    public EndMatchCommand(Match match) {
        this.match = match;
    }

    @Override
    public void execute() {
        match.endMatch();
    }

    @Override
    public String getName() {
        return "EndMatch";
    }
}
