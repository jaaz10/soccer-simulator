import java.util.ArrayList;
import java.util.List;

// Invoker - runs commands and keeps ordered history of cmds
public class MatchController {
    private final List<Command> history = new ArrayList<>();

    public void run(Command command) {
        command.execute();
        history.add(command);
    }

    public void printHistory() {
        for (int i = 0; i < history.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + history.get(i).getName());
        }
    }

    public List<Command> getHistory() {
        return new ArrayList<>(history);
    }
}
