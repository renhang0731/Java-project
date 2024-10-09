
package apr24.assignmenty1g3;

public abstract class Transport implements Movable {
    protected String type;
    protected String name;
    protected int currentLoad;
    protected int maxLoad;

    public Transport(String type, String name, int maxLoad) {
        this.type = type;
        this.name = name;
        this.maxLoad = maxLoad;
        this.currentLoad = 0;
    }

    public void load(int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Invalid weight to load. Loading cancelled.");
        } else if (currentLoad + weight > maxLoad) {
            throw new IllegalArgumentException("Exceeds max load capacity. Loading cancelled.");
        } else {
            currentLoad += weight;
            System.out.println("Loaded successfully.");
        }
    }

    public void unload(int weight) {
        if (weight < 0 || weight > currentLoad) {
            throw new IllegalArgumentException("Invalid weight to unload. Unloading cancelled.");
        } else {
            currentLoad -= weight;
            System.out.println("Unloaded successfully.");
        }
    }

    @Override
    public String toString() {
        return "Type=" + type + ", Name=" + name + ", max Load=" + maxLoad + " kg, current Load=" + currentLoad + " kg";
    }

    @Override
    public abstract void move();
}

