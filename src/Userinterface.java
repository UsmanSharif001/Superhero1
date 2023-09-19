import java.util.ArrayList;
import java.util.Scanner;

public class Userinterface {
    public void startProgram() {
        System.out.println("Start program Userinterface: ");

        Scanner scanner = new Scanner(System.in);

        Database heroDatabase = new Database();
        Object superherolist = heroDatabase.getSuperheroList();
        int capacity = heroDatabase.getCapacity();
        int count = 0;

        System.out.println("Welcome to the Superhero Univers - are you ready to begin YOUR superhero journey?");

        while (count <= capacity) {

            System.out.println("""
            1. Add Superhero:
            2. Search Superhero
            6. Show list
            7. Rediger Superhelt
            9. Exit Program """);

            String nextMove = scanner.nextLine();

            if (nextMove.equals("1") && (count < capacity)) {

                System.out.println("Write the name of your superhero");
                System.out.print("name: ");
                String name = scanner.nextLine();

                System.out.println("Write your superheros real name");
                System.out.print("Real name: ");
                String realName = scanner.nextLine();

                System.out.println("Write your superheros superpower");
                System.out.print("Superpower: ");
                String superPower = scanner.nextLine();

                System.out.println("Write the year your superhero was created");
                System.out.print("year created: ");
                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.println("Year created must be a whole number");
                }
                int yearCreated = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Is your superhero a human? type no or yes\n [no] / [yes]: ");
                String isHuman = scanner.nextLine();

                System.out.println("What is your superheros strength?");
                System.out.print("Strength: ");
                String strength = scanner.next();


                heroDatabase.addSuperhero(name, realName, superPower, yearCreated, isHuman, strength);

                count++;
                //Noget med at en booleon i overskud gør at der er en ekstra "nextline" i bufferen som skydes af når loopet gentages
                scanner.nextLine();
            }
            if (nextMove.equals("6") && (count == capacity)) {
                System.out.println("You have added the maximum number of heroes to the list");
            }
            if (nextMove.equals("9")) {
                System.exit(0);
            }
            if (nextMove.equals("6")) {
                System.out.println(superherolist);
            } else if (nextMove.equals("2")) {
                System.out.println("We will begin the journey of finding your SUPERHERO!!");

                System.out.println("Enter the SUPERHEROES NAME: ");
                String searchName = scanner.nextLine();
                ArrayList<Superhero> searchResults = heroDatabase.findSuperHero(searchName);


                if (searchResults.isEmpty()) {
                    System.out.println("Your superhero is still in the creation state");
                } else {
                    System.out.println("The following superheroe(s) matched your criterias");
                    for (Superhero superhero : searchResults) {
                        System.out.println(superhero);

                    }
                }
            } if (nextMove.equals("7")) {
                //Navn indtastes fra brugeren
                System.out.println("Edit your superhero: ");
                String brugerinput = scanner.nextLine();

                //Vi går ned i arraylisten i heroDatabase og finder superhelt
                ArrayList<Superhero> searchResultat = heroDatabase.findSuperHero(brugerinput);
                Superhero superheroDerSkalRedigeres = null;

                //Hvis søgningen ikke finder nogen superhelt
                if(searchResultat.size() == 0) {
                    System.out.println("No superheroes matches your criteria(s)");

                } else if (searchResultat.size()>1) {
                    //Vælg en i søgeresultatet med flere superhelte
                    System.out.println("Choose superhero");
                    int tæller = 1;
                    for (Superhero superhero: searchResultat) {
                        System.out.println(tæller+++" " + superhero.getName() + " " +
                                superhero.getRealName() + " " +
                                superhero.getSuperPower() + " " +
                                superhero.getYearCreated() + " " +
                                superhero.getIsHuman() + " " +
                                superhero.getStrength() );
                    }
                    int superHeroValg = scanner.nextInt();
                    scanner.nextLine(); //Scanner bug
                    superheroDerSkalRedigeres = searchResultat.get(0);
                }
                else {
                    superheroDerSkalRedigeres = searchResultat.get(0);
                }

                //Nu kommer vi til redigering af valgte personer hvis vi vil det
                if (superheroDerSkalRedigeres !=null) {
                    System.out.println("Edit superhero information. Press enter if you want to keep the information");
                    String nyVærdi;
                    System.out.println("Navn: " + superheroDerSkalRedigeres.getName());
                    nyVærdi = scanner.nextLine();
                    if (!nyVærdi.isEmpty()) {
                        superheroDerSkalRedigeres.setName(nyVærdi);
                    }
                    System.out.println("Real name: " + superheroDerSkalRedigeres.getRealName());
                    nyVærdi = scanner.nextLine();
                    if (!nyVærdi.isEmpty()){
                        superheroDerSkalRedigeres.setRealName(nyVærdi);
                    }
                    System.out.println("Superpower: " + superheroDerSkalRedigeres.getSuperPower());
                    nyVærdi = scanner.nextLine();
                        if (!nyVærdi.isEmpty()) {
                            superheroDerSkalRedigeres.setSuperPower(nyVærdi);
                        }

                    System.out.println("Year created: " + superheroDerSkalRedigeres.getYearCreated());
                    System.out.println("Enter the year created (or press Enter to keep current value): ");
                    while (!scanner.hasNextInt()) {
                        scanner.nextLine();
                        System.out.println("Year created must be a whole number.");
                    }
                    nyVærdi = scanner.next();
                    if (!nyVærdi.isEmpty()) {
                        superheroDerSkalRedigeres.setYearCreated(Integer.parseInt(nyVærdi));
                        String text = scanner.next();
                        System.out.println(text + "WHAT A YEAR");
                    }

                    System.out.println("Is human: " + superheroDerSkalRedigeres.getIsHuman());
                        nyVærdi = scanner.nextLine();
                        if (!nyVærdi.isEmpty()) {
                            superheroDerSkalRedigeres.setIsHuman(nyVærdi);
                        }
                    System.out.println("Strength: " + superheroDerSkalRedigeres.getStrength());
                        if (!nyVærdi.isEmpty()) {
                            superheroDerSkalRedigeres.setStrength(nyVærdi);
                        }
                    System.out.println(superheroDerSkalRedigeres + "er blevet opdateret");

                }
            }
        }
    }

}
