public class ForwardCreator extends PlayerCreator {
    
    @Override
    public Player createPlayer(String name) {
        return new Player(name, "Forward", 90);
    }
}
