
package apr24.assignmenty1g3;

public class Ship extends Transport {
    public Ship(String name, int maxLoad) {
        super("Ship", name, maxLoad);
    }

    @Override
    public void move() {
        System.out.println(name + " sails.");
    }
}
