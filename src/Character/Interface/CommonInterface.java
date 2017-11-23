package Character.Interface;

/*
* Define the methods that all classes that extend from the Common class must have.
* */

public interface CommonInterface {

    void health(int decrease);
    boolean isAlive();
    String getName();
    void setName(String name);
    int attackPoint();


}
