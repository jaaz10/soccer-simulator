public class EndHalfCommand implements Command {
    private final Match match;

    public EndHalfCommand(Match match) {
        this.match = match;
    }

    @Override
    public void execute() {
        match.endHalf();
    }

    @Override
    public String getName() {
        return "EndHalf";
    }
}
