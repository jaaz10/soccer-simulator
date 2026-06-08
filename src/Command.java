// Command interface - each action is a separate class
public interface Command {
    void execute();
    String getName();
}
