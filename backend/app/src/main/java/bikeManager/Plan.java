package bikeManager;

import java.util.function.IntBinaryOperator;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Planos")
@XmlEnum
public enum Plan {
    
    Plan10(5.0f,10, "Plan10" ),
    Plan15(7.5f,15, "Plan15" ),
    Plan30(15.0f,30, "Plan30" ),
    Plan40(20.0f,40, "Plan40" ),
    Plan60(30.0f,60, "Plan60" ),
    Plan90(45.0f,90, "Plan90" );


    private final float price;
    private final int time;
    private final String name;

    Plan(float price, int time, String name) {
        this.price = price;
        this.name = name;
        this.time = time;
    }

    /**
     * Returns the Location enum value of the given name.
     *
     * @param name the name of the location
     * @return the Location enum value of the given name
     */
    public static Plan valueOfName(String name) {
        for (Plan plan : Plan.values()) {
            if (plan.name.equals(name)) {
                return plan;
            }
        }
        throw new IllegalArgumentException("Invalid location name: " + name);
    }


    /**
     * Returns the y-coordinate of the location.
     * @return the y-coordinate of the location
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * Returns the name of the location.
     * @return the name of the location
     */
    public String getName() {
        return this.name;
    }

    public int getTime() {
        return this.time;
    }

}