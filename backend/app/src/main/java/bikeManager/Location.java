package bikeManager;

import java.util.function.IntBinaryOperator;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="location")
@XmlEnum
public enum Location {
    
    IB   (0, 0, "IB"   ),
    IQ   (1, 1, "IQ"   ),
    IFGW (2, 2, "IFGW" ),
    IMECC(3, 3, "IMECC"),
    IFCH (4, 4, "IFCH" ),
    IEL  (5, 5, "IEL"  ),
    IA   (6, 6, "IA"   ),
    IC   (8, 8, "IC"   ),
    PB   (9, 9, "PB"   ),
    CB   (10, 10, "CB" ),
    BC   (7, 7, "Biblioteca Central");


    private final int x;
    private final int y;
    private final String name;

    Location(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * Returns the Location enum value of the given name.
     *
     * @param name the name of the location
     * @return the Location enum value of the given name
     */
    public static Location valueOfName(String name) {
        for (Location location : Location.values()) {
            if (location.name.equals(name)) {
                return location;
            }
        }
        throw new IllegalArgumentException("Invalid location name: " + name);
    }


    /**
     * Returns the Location enum value for the given x and y coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return the Location enum value with the given coordinates
     * @throws IllegalArgumentException if no Location with the given coordinates exists
     */
    public static Location valueOfCoordinates(int x, int y) {
        for (Location location : Location.values()) {
            if (location.x == x && location.y == y) {
                return location;
            }
        }
        throw new IllegalArgumentException("Invalid location coordinates: x=" + x + ", y=" + y);
    }


    /**
     * Returns the x-coordinate of the location.
     * @return the x-coordinate of the location
     */
    public int getX() {
        return this.x;
    }


    /**
     * Returns the y-coordinate of the location.
     * @return the y-coordinate of the location
     */
    public int getY() {
        return this.y;
    }

    /**
     * Returns the name of the location.
     * @return the name of the location
     */
    public String getName() {
        return this.name;
    }

}