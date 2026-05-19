//Factory Method Pattern
public abstract class PlayerCreator {
    
	public abstract Player createPlayer(String name);
    
    public Player recruitPlayer(String name) {
        Player player = createPlayer(name);
        System.out.println("✅ Recruited: " + player.getName() + 
                         " (" + player.getPosition() + ", Skill: " + player.getSkillLevel() + ")");
        return player;
    }
}
