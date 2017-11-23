package Character.Common;

import Character.Interface.CommonInterface;

/**
 * This abstract class all the characters have common characteristics they have. Like name, health and location.
 * At the same time this field values are get and set.
 */

public abstract class Common implements CommonInterface {

    public String name;
    public int health;
    public int location;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Common(String enemyName, int enemyHealth) {
        setName(enemyName);
        this.health = enemyHealth;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void health(int decrease) {
        health = health - decrease;
    }

    @Override
    public boolean isAlive() {
        return (getHealth() <= 0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
