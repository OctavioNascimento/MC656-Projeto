package databaseManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import bikeManager.Bike;
import bikeManager.Passenger;
import bikeManager.Ride;
import bikeManager.RidePayment;

import exceptions.*;

import exceptions.UnsupportedObjectTypeException;

@XmlRootElement(name="database")
public class Database{
    private List<Bike> bikes = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<RidePayment> payments = new ArrayList<>();
    
    private final File file = new File("./app/data/database.xml");


    public Database(){
    }

    public Database(boolean load){
        if(load){
            this.load();
        }
    }
    
    @XmlElementWrapper(name="passengers")
    @XmlElement(name="passenger")
    public List<Passenger> getPassengers(){
        return this.passengers;
    }

    @XmlElementWrapper(name="cabbies")
    @XmlElement(name="cabbie")
    public List<Bike> getBikes(){
        return this.bikes;
    }

    @XmlElementWrapper(name="rides")
    @XmlElement(name="ride")
    public List<Ride> getRides(){
        return this.rides;
    }

    @XmlElementWrapper(name="payments")
    @XmlElement(name="payment")
    public List<RidePayment> getPayments(){
        return this.payments;
    }




    /**
     * Inserts an object into the database.
     * 
     * @param object the object to be inserted. The object must be of type Cabbie, Passenger, Vehicle, Ride, or RidePayment.
     * 
     * @throws UnsupportedObjectTypeException if the object is not of a supported type.
     */

    public void insert(Object object){
        if(object instanceof Passenger){
            this.passengers.add((Passenger) object);
        }else if(object instanceof Bike){
            this.bikes.add((Bike) object);
        }else if(object instanceof Ride){
            this.rides.add((Ride) object);
        }else if(object instanceof RidePayment){
            this.payments.add((RidePayment) object);
        } else {
            throw new UnsupportedObjectTypeException();
        }

        this.save();
    }


    private <T> void update(T newItem, List<T> data){
        for(int i=0;i<data.size();i++){
            Object item = data.get(i);

            if(item.equals(newItem)){
                data.set(i, newItem);
            }
        }
    }

    public void update(Object object){
        if(object instanceof Passenger){
            this.update((Passenger)object, this.passengers);
        }else if(object instanceof Bike){
            this.update((Bike)object, this.bikes);
        }else if(object instanceof Ride){
            this.update((Ride)object, this.rides);
        }else if(object instanceof RidePayment){
            this.update((RidePayment)object, this.payments);
        }else{
            return;
        }
        this.save();       
    }

    private void save(){
        try{
            JAXBContext context = JAXBContext.newInstance(Database.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            OutputStream outputStream = new FileOutputStream(this.file);
            marshaller.marshal(this, outputStream);
            outputStream.close();
        }catch(JAXBException | IOException e){
            e.printStackTrace();
        }
    }

    private void load(){
        if(file.exists()){
            try{
                JAXBContext context = JAXBContext.newInstance(Database.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                InputStream inputStream = new FileInputStream(this.file);
                Database db = (Database) unmarshaller.unmarshal(inputStream);
                inputStream.close();
                
                this.bikes = db.getBikes();
                this.passengers = db.getPassengers();
                this.rides = db.getRides();
                this.payments = db.getPayments();
            }catch(JAXBException | IOException e){
                e.printStackTrace();
            }
        }
    }


    public Passenger getPassengerByEmail(String email) {
        for (Passenger pass : passengers) {
            if (pass.getEmail().equalsIgnoreCase(email)) {
                return pass;
            }
        }
        return null;
    }
}