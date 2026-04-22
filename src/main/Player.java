package main;

public class Player {
    private String name;
    private int skillLevel;
    
    public Player(String name, int skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }
    
    public String getName() {
        return name;
    }
    
    public int getSkillLevel() {
        return skillLevel;
    }
}
