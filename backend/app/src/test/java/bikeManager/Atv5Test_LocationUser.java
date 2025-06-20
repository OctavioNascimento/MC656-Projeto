package bikeManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import bikeManager.Location;
import bikeManager.Plan;
import bikeManager.Passenger;
import bikeManager.Ride;
import bikeManager.RidePayment;
import bikeManager.Bike;
import bikeManager.Payment;
import exceptions.UnsupportedObjectTypeException;
import databaseManager.Database;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.StringWriter;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.Data;

import org.junit.jupiter.api.Assertions;



public class Atv5Test_LocationUser {

    @Test
    public void testValueOfName_ValidName() {
        // Assume Location.IB exists and its name is "IB"
        Location loc = Location.valueOfName("IB");
        assertNotNull(loc);
        assertEquals("IB", loc.getName());
    }

    @Test
    public void testValueOfName_InvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Location.valueOfName("INVALID_NAME");
        });
        assertTrue(exception.getMessage().contains("Invalid location name"));
    }

    @Test
    public void testValueOfCoordinates_ValidCoordinates() {
        // Assume Location.IB exists and has x=0, y=0 (replace with actual values)
        Location expected = Location.IB;
        Location actual = Location.valueOfCoordinates(expected.getX(), expected.getY());
        assertEquals(expected, actual);
    }

    @Test
    public void testValueOfCoordinates_InvalidCoordinates() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Location.valueOfCoordinates(999, 999);
        });
        assertTrue(exception.getMessage().contains("Invalid location coordinates"));
    }
}
