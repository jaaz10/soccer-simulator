public class Player {
    private String name;
    private String position;
    private int skillLevel;

    public Player(String name, String position, int skillLevel) {
        this.name = name;
        this.position = position;
        this.skillLevel = skillLevel;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    @Override
    public String toString() {
        return name + " (" + position + ", Skill: " + skillLevel + ")";
    }
}
