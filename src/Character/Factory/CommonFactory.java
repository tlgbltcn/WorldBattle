package Character.Factory;

import Character.*;
import Character.Interface.CommonFactoryInterface;
import Character.Interface.CommonInterface;

/**
 * In this class, there is a design that allows all characters to be created.
 * the characters' healths are assigned here.
 */

public class CommonFactory implements CommonFactoryInterface {

    public static final CommonFactoryInterface instance = new CommonFactory();

    @Override
    public CommonInterface make(String type) {
        switch (type) {
            case "Hero":
                return new Hero("Hero", 500);
            case "Bug":
                return new Bug(50);
            case "Mutant":
                return new Mutant(400);
            case "Lion":
                return new Lion(100);
            case "Zombie":
                return new Zombie(300);
            case "ZombieDog":
                return new ZombieDog(75);

        }
        return null;
    }


    private CommonFactory() {

    }

}
