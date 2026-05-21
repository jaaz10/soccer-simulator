// Invoker - only runs commands (does not know match details)
public class MatchController {
    public void run(Command command) {
        command.execute();
    }
}
