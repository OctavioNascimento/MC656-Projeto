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

public class Atv5Test_AuthUser {

    private Passenger passenger;
    private Database database = new Database(true);



    @Test
    public void Atv5Test_AuthUser_1() {
        assertDoesNotThrow(() -> {
            this.passenger = new Passenger("f135220@dac.unicamp.br");
        });
    }

    @Test
    public void Atv5Test_AuthUser_EmailNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger(null);
        });
        assertEquals("O email não pode ser nulo", exception.getMessage());
    }

    @Test
    public void Atv5Test_AuthUser_EmailEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("");
        });
        assertEquals("O email não pode ser vazio", exception.getMessage());
    }

    @Test
    public void Atv5Test_AuthUser_InvalidDomain() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("f135220@gmail.com");
        });
        assertEquals("O email deve terminar com @dac.unicamp.br", exception.getMessage());
    }

    @Test
    public void Atv5Test_AuthUser_ValidEmail() {
        assertDoesNotThrow(() -> {
            Passenger p = new Passenger("f135220@dac.unicamp.br");
            assertNotNull(p);
        });
    }

    @Test
    public void Atv5Test_AuthUser_EmailWithSpaces() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger(" f135220@dac.unicamp.br");
        });
        // Dependendo da implementação, pode ser vazio ou domínio inválido
        // Ajuste a mensagem conforme a implementação real
    }

    @Test
    public void Atv5Test_AuthUser_EmailUpperCaseDomain() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("f135220@DAC.UNICAMP.BR");
        });
        assertEquals("O email deve terminar com @dac.unicamp.br", exception.getMessage());
    }

    @Test
    public void Atv5Test_AuthUser_EmailWithSpecialCharFirst() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("_f135220@dac.unicamp.br");
        });
        assertEquals("O primeiro caractere do email deve ser uma letra", exception.getMessage());
    }
}