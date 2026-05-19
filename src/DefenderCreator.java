public class DefenderCreator extends PlayerCreator {
    
    @Override
    public Player createPlayer(String name) {
        return new Player(name, "Defender", 80);
    }
}
