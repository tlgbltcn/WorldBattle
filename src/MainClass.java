import Character.Hero;
import Character.Common.Common;
import Character.Factory.CommonFactory;
import Character.Interface.CommonFactoryInterface;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/*
* This project was built using basic object oriented programming components. These are encapsulation, abstraction,
* inheritance and polymorphism. Factory Pattern is used to produce objects. The characters created with the Factory
* Pattern have been expanded in a common class, which is an abstract class. And using the interfaces, each character's
* behavior is controlled. Results are written to a results.txt file by performing logical operations on the Main Class.
* It would be more useful to use the generic method that contains non-constant characters for both types that will
* fight the logical method. For this reason, the generic method is not used.
*
* Intellij Idea is used for this project.
*
*/

public class MainClass {


    private static final CommonFactoryInterface factory = CommonFactory.instance;

    public static final int resources = 5000;
    private static CreateFile file = new CreateFile();


    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        Common[] enemy = randomEnemies();  //Random enemy characters are created and assigned to the enemy variable.
        Hero myHero = myHero();            //Hero characters are created and assign to myHero variable.
        battle(myHero, enemy);             //fights characters in param and gives results
    }

    public static Common battle(Hero g1, Common[] g2) throws FileNotFoundException, UnsupportedEncodingException {
        //g1 represents the variant hero, g2 represents the variant enemies.
        file.openFile();
        String str1 = ("Resources are " + resources + " meter away\n" +
                g1.getName() + " has " + g1.getHealth() + " hp\n" +
                g1.getName() + " attack is " + g1.attackPoint()+"\n");
        file.addRecors(str1);

        // Gives information about all the features of the enemies
        for (Common temp : g2) {

            String str2 = (temp.getName() + " is Character." + " has hp " + temp.getHealth() + " attack point " +
                    temp.attackPoint() + " location " + temp.getLocation() + " meter.\n");

            file.addRecors(str2);

        }


        for (int i = 0; i < g2.length; i++) {

            boolean survive = true;

            while (survive) {
                //The conditions of the cycle depend on the survival of the characters

                if (g2[i].isAlive() || g1.isAlive()) {
                    survive = false;
                    continue;
                }

                g1.attack(g2[i]);
                g1.setHealth(g1.getHealth() - g2[i].attackPoint());

                if (g1.isAlive()) {

                    String str2 = (g1.getName() + " vs " + g2[i].getName() + " battle and " + g1.getName() +
                            " died" + " at " + g2[i].getLocation() + " meters.");

                    file.addRecors(str2);
                    survive = false;

                } else if (g2[i].isAlive()) {

                    String str3 = (g1.getName() + " vs " + g2[i].getName() + " battle and " + g1.getName() +
                            " won. " + g1.getHealth() + " health left.\n");
                    file.addRecors(str3);
                    survive = false;
                }

            }

        }

        file.closeFile();

        return null;
    }


    public static Common[] randomEnemies() {
        //This method returns a serial with the enemy characters.

        int totalEnemy = (int) (Math.random() * 7);         //Random number max bound.
        Common[] enemy = new Common[totalEnemy];

        int[] location = new int[totalEnemy];               //Random location.
        Random generator = new Random();

        for (int j = 0; j < enemy.length; j++) {
            location[j] = (generator.nextInt(resources));
        }

        Arrays.sort(location);                              // small to large location's number.

        for (int i = 0; i < enemy.length; i++) {

            int[] randomLocation = location;

            int enemyType = (int) (Math.random() * 5);      // Character types are randomly formed.
            switch (enemyType) {
                case 0:
                    enemy[i] = (Common) factory.make("Bug");
                    enemy[i].setLocation(randomLocation[i]);
                    break;
                case 1:
                    enemy[i] = (Common) factory.make("Lion");
                    enemy[i].setLocation(randomLocation[i]);

                    break;
                case 2:
                    enemy[i] = (Common) factory.make("Mutant");
                    enemy[i].setLocation(randomLocation[i]);

                    break;
                case 3:
                    enemy[i] = (Common) factory.make("Zombie");
                    enemy[i].setLocation(randomLocation[i]);

                    break;
                case 4:
                    enemy[i] = (Common) factory.make("ZombieDog");
                    enemy[i].setLocation(randomLocation[i]);

                    break;
            }

        }
        return enemy;
    }

    public static Hero myHero() {
        //This method creates our hero

        Hero hero = (Hero) factory.make("Hero");
        return hero;
    }

}
