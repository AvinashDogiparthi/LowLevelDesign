package N_ZeptoStoreDesign;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Location {
    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Location location){
        return (int) sqrt(pow(x-location.x,2)+pow(y-location.y,2));
    }
}
