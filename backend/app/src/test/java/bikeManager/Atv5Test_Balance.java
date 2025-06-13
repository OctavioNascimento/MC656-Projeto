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

public class Atv5Test_Balance {

    private Passenger passenger;
    private Database database = new Database(true);

    @Test
    public void testAtv5Test_Balance_1_SuccessfulValidation() {
        Passenger passenger = new Passenger();
        passenger.register();
        passenger.update("balance", "100.0");
        passenger.setLocation(Location.IC);

        assertEquals(100.0f, passenger.getBalance(), "Balance should be 100.0");
        assertEquals(Location.IC, passenger.getLocation(), "Location should be IC");

        Ride ride = new Ride(passenger);

        // Should not throw any exception since balance is sufficient and plan is provided
        assertDoesNotThrow(() -> {
            ride.requestRide(passenger.getLocation(), Location.IB, Plan.Plan10);
        });
    }

    @Test
    public void testAtv5Test_Balance_1_PassengerNull() {
        Ride ride = new Ride("");

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            ride.requestRide(Location.IC, Location.IB, Plan.Plan10);
        });
        assertEquals("Passageiro não encontrado para validação de saldo.", exception.getMessage());
    }

    @Test
    public void testAtv5Test_Balance_1_PlanNull() {
        Passenger passenger = new Passenger();
        passenger.register();
        passenger.update("balance", "100.0");
        passenger.setLocation(Location.IC);

        Ride ride = new Ride(passenger);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            ride.requestRide(passenger.getLocation(), Location.IB, null);
        });
        assertEquals("Plano não informado.", exception.getMessage());
    }

    @Test
    public void testAtv5Test_Balance_1_InsufficientBalance() {
        Passenger passenger = new Passenger();
        passenger.register();
        passenger.update("balance", "4.0f"); // Less than Plan10 price
        passenger.setLocation(Location.IC);

        Ride ride = new Ride(passenger);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ride.requestRide(passenger.getLocation(), Location.IB, Plan.Plan10);
        });
        assertTrue(exception.getMessage().contains("Saldo insuficiente para o plano solicitado."));
    }
}