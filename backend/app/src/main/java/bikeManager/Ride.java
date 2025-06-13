package bikeManager;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.common.base.Objects;

import utils.LocalDateTimeAdapter;


@XmlRootElement(name = "ride")
public class Ride {
    
    private String rideId;
    private String passengerId;
    private Passenger passenger;

    private Plan plan;

    private String bikeId;
    private String status;

    private Location pickupLocation;
    private Location dropLocation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private float distance;
    private long durationTime; // duração da corrida em segundos


    //Adicionar os métodos da classe Ride
    public Ride(Passenger passenger) {
        this.passenger = passenger;
        this.passengerId = passenger.getPassengerId();
    }


    public Ride(String passengerId) {
        this.passengerId = passengerId;
    }


    /**
     * Requests a ride by a passenger.
     * 
     * @param pickupLocation  the location where the passenger wants to be picked up
     * @param dropLocation    the location where the passenger wants to be dropped off
     * 
     * The ride status is set to "REQUESTED".
     * The startTime is set to the current time.
     * 
     * A message is printed to the console with the information of the ride.
     */

    public void requestRide(Location pickupLocation, Location dropLocation, Plan plan) {

        this.rideId = UUID.randomUUID().toString();
        this.pickupLocation = pickupLocation;
        this.dropLocation= dropLocation;
        this.startTime = LocalDateTime.now();
        this.plan = plan;


        // Validação: saldo do passageiro deve ser suficiente para o plano solicitado
        if (this.passenger == null && (this.passengerId == null || this.passengerId.isEmpty())) {
            throw new IllegalStateException("Passageiro não encontrado para validação de saldo.");
        }
        if (this.plan == null) {
            throw new IllegalStateException("Plano não informado.");
        }
        float passengerBalance = this.passenger.getBalance();
        float planValue = this.plan.getPrice();
        if (passengerBalance < planValue) {
            throw new IllegalArgumentException("Saldo insuficiente para o plano solicitado. Saldo: " + passengerBalance + ", Valor do plano: " + planValue);
        }


        System.out.println("Corrida chamada por pessoa passageira " + this.passengerId + " de " + pickupLocation + " para " + dropLocation);
        this.updateRideStatus("CHAMADA", null);

        this.distance = this.calculateDistance();

    }


    /**
     * Returns a Location given a location name.
     * 
     * @param locationName  the name of the location
     * 
     * If the location is not found, a default value of AEROPORTO is returned.
     * 
     * @return a Location object
     */
    private Location returnLocation(String locationName) {
        return Location.valueOfName(locationName);

    }


    /**
     * Calculates the distance between the pickup and drop locations.
     * 
     * The distance is calculated as the Euclidean distance between the two points.
     * 
     * @return the calculated distance.
     */
    public float calculateDistance() {
        
        int x_pickup = pickupLocation.getX();
        int y_pickup = pickupLocation.getY();

        int x_drop = dropLocation.getX();
        int y_drop = dropLocation.getY();

        float distance = (float) Math.sqrt(Math.pow(x_drop - x_pickup, 2) + Math.pow(y_drop - y_pickup, 2));
        distance = Math.round(distance * 100) / 100.0f;
        System.out.println(("Distância calculada: " + distance));
        return distance;
    }

   
    public long getDurationTime() {
        return durationTime;
    }


    public void setDurationTime(long durationTime) {
        this.durationTime = durationTime;
    }


    public void updateRideStatus(String status, String bikeId) {
        this.status = status;

        if (status.equals("ACEITA")) {
            this.bikeId = bikeId;
            System.out.println(("Bicicleta utilizada: " + this.bikeId));
        } else {
            System.out.println("Status da viagem: " + this.status);
        }

    }


    public long calculateDurationTime(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null || endTime == null) {
            throw new IllegalStateException("Start time or end time is not set.");
        }
        long durationTime = (java.time.Duration.between(startTime, endTime).getSeconds())/60;

        return durationTime;
    }


    public void completeRide(LocalDateTime endTime) {
        this.endTime = endTime;
        this.status = "FINALIZADA";
        this.distance = this.calculateDistance();
        this.durationTime = this.calculateDurationTime(this.startTime, this.endTime);
        System.out.println("Corrida " + this.rideId + " finalizada com sucesso.");
        System.out.println("Distância percorrida: " + this.distance + " km");
        System.out.println("Tempo de início: " + this.startTime);
        System.out.println("Tempo de fim: " + this.endTime);

    }


    @XmlElement(name = "pickupLocation")
    public Location getPickLocation(){
        return this.pickupLocation;
    }


    /**
     * Sets the pickup location of this ride.
     * @param pickupLocation The new pickup location.
     */
    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @XmlElement(name = "dropLocation")
    public Location getDropLocation(){
        return this.dropLocation;
    }


    /**
     * Sets the drop location of this ride.
     * @param dropLocation The new drop location.
     */
    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }


    /**
     * Gets the ID of this ride.
     * 
     * @return the ID of this ride (a UUID)
     */
    @XmlElement(name = "rideId")
    public String getRideId() {
        return this.rideId;
    }


    public void setRideId(String rideId){
        this.rideId = rideId;
    }


    /**
     * Gets the start time of this ride.
     * 
     * @return the start time of this ride (a LocalDateTime)
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement(name = "startTime")
    public LocalDateTime getStartTime() {
        return this.startTime;
    }


    /**
     * Gets the distance of this ride.
     * 
     * @return the distance of this ride (a float)
     */
    @XmlElement(name = "rideDistance")
    public float getRideDistance() {
        return this.distance;
    }


    @XmlElement(name = "passengerId")
    public String getPassengerId() {
        return passengerId;
    }


    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }


    @XmlElement(name = "cabbieId")
    public String getBikeId() {
        return bikeId;
    }


    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }


    @XmlElement(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(name = "distance")
    public float getDistance() {
        return distance;
    }
    
    public void setDistance(float distance) {
        this.distance = distance;
    }


    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        
        Ride pas = (Ride) o;
        return Objects.equal(this.rideId, pas.getRideId());
    }
    

    @Override
    public String toString() {
        return "Ride: " + this.rideId;
    }
}
