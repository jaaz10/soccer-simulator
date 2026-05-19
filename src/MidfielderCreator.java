public class MidfielderCreator extends PlayerCreator {
    
    @Override
    public Player createPlayer(String name) {
        return new Player(name, "Midfielder", 85);
    }
}
