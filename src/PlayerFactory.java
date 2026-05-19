public class PlayerFactory {
    
    
    public static Player createPlayer(String name, String position) {
        int skillLevel;
        
        switch (position.toLowerCase()) {
            case "forward":
                skillLevel = 90;
                break;
            case "midfielder":
                skillLevel = 85;
                break;
            case "defender":
                skillLevel = 80;
                break;
            case "goalkeeper":
                skillLevel = 88;
                break;
            default:
                skillLevel = 75;
        }
        
        return new Player(name, position, skillLevel);
    }
}
