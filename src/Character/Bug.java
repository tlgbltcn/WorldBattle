package Character;

import Character.Common.Common;
import Character.Interface.CommonInterface;

/*
* One of the enemy characters
*/

public class Bug  extends Common implements CommonInterface {

    public Bug(int health) {
        super("Bug" ,health );
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
        return 2;
    }
}
