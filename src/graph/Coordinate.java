package graph;

public class Coordinate {
    public final int x;
    public final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate))
            return false;
        Coordinate c = (Coordinate) o;
        return this.x == c.x && this.y == c.y;
    }

    // The following is similar to the proposal by Jack Hair in the
    // module facebook group.  We need to make sure that
    //
    //        (*) Equal objects have equal hash codes.
    //
    @Override
    public int hashCode() {
        return x + y; // Any function of x and y with property (*) will do.

        // "return 0;" works, but having all data to have the same hash
        // code defeats the idea of hash tables and make them inefficient.
    }

    @Override
    public String toString() {
        return "[Coordinate] " + x + ", " + y;
    }
}
