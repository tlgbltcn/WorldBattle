package Character;

import Character.Common.Common;
import Character.Interface.CommonInterface;

/*
* One of the enemy characters
*/

public class ZombieDog extends Common implements CommonInterface {

    public ZombieDog(int health) {
        super("ZombieDog", health);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int getLocation() {
        return super.getLocation();
    }

    @Override
    public int attackPoint() {
        return 10;
    }
}
