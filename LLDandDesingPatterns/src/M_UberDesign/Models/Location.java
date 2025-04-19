package M_UberDesign.Models;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Location {

    public int x;
    public double y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calculateDistance(Location location){
        return (int) sqrt(pow(this.x-location.x,2) + pow(this.y - location.y,2));
    }
}
