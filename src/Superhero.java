public class Superhero {

    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private String isHuman;
    private String strength;

    public Superhero(String name, String realName,
                     String superPower, int yearCreated,
                     String isHuman, String strength) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public int getYearCreated() {
        return (int) yearCreated;
    }

    public String getIsHuman() {
        return isHuman;
    }

    public String getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRealName (String realName) {
        this.realName = realName;
    }

    public void setSuperPower (String superPower) {
        this.superPower = superPower;
    }
    public void setYearCreated (int yearCreated) {
        this.yearCreated = yearCreated;
    }
    public void setIsHuman(String isHuman) {
        this.isHuman = isHuman;
    }
    public  void setStrength(String strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Superhero\n" +
                "name: " + name + "\n" +
                "realName: " + realName + "\n" +
                "superPower: " + superPower + "\n" +
                "yearCreated: " + yearCreated + "\n" +
                "isHuman: " + isHuman + "\n" +
                "strength: " + strength + "\n";

    }
}
