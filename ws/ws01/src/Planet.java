public class Planet {
    private double x;
    private double y;
    private double mass;

    public Planet(double x, double y, double mass) {
        this.x = x;
        this.y = y;
        this.mass = mass;
    }

    public double distanceTo(Planet other) {
        return Math.sqrt(Math.pow((other.x - x), 2) + Math.pow((other.y - y), 2));
    }

    public static double sumMass(Planet p1, Planet p2) {
        return p1.mass + p2.mass;
    }

    static void main() {
        Planet p1 = new Planet(5, 10, 100);
        Planet p2 = new Planet(1, 2, 200);

        IO.println(p1.distanceTo(p2));
        IO.println(Planet.sumMass(p1, p2));
    }
}
