import java.util.ArrayList;

public class Database {
    private int listSize = 10;
    //private Superhero[] superHeroList;
    private ArrayList<Superhero> superHeroList;

    public Database() {
        this.superHeroList = new ArrayList<>();
    }

    public void addSuperhero(String name, String realName,
                             String superPower, int yearCreated,
                             String isHuman, String strength) {

        Superhero superhero = new Superhero(name, realName,
                superPower, yearCreated,
                isHuman, strength);
        superHeroList.add(superhero);
    }

    public ArrayList<Superhero> getSuperheroList() {
        return superHeroList;
    }

    public int getCapacity() {
        return listSize;
    }

    // Method to find superheroes by name
    public ArrayList<Superhero> findSuperHero(String name) {
        ArrayList<Superhero> results = new ArrayList<>();
        for (Superhero superhero : superHeroList) {
            if (superhero.getName().equalsIgnoreCase(name)
                    //&& superhero.getSuperPower().equalsIgnoreCase(superPower)
                    //&& superhero.getYearCreated() == yearCreated
                    //&& superhero.getIsHuman().equalsIgnoreCase(isHuman)
                    /*&& superhero.getStrength().equalsIgnoreCase(strength)*/ )
            {
                results.add(superhero);

            }
        }
        return results;
    }
}

