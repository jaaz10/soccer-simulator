public class GoalkeeperCreator extends PlayerCreator {
    
    @Override
    public Player createPlayer(String name) {
        return new Player(name, "Goalkeeper", 88);
    }
}
