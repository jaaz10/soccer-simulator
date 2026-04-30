package main;

public class PlayerFactory {
        public static Player createPlayer(String name, String position) {
        switch (position.toLowerCase()) {
            case "striker":
                return new Player(name, 85); 
            case "midfielder":
                return new Player(name, 75); 
            case "defender":
                return new Player(name, 70); 
            case "goalkeeper":
                return new Player(name, 60);
            default:
                return new Player(name, 70);
        }
    }
    
    public static Player createPlayer(String name, String position, int customSkill) {
        return new Player(name, customSkill);
    }
}
