package Character;

import Character.Common.Common;
import Character.Interface.CommonInterface;

/*
* One of the enemy characters
*/

public class Lion  extends Common implements CommonInterface {


    public Lion(int health) {
        super("Lion", health);
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
    public void setLocation(int location) {
        super.setLocation(location);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }


    @Override
    public int attackPoint() {
        return 15;
    }
}
