package bikeManager;

import com.google.common.base.Objects;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Bike")
public class Bike {
    private String bikeId;
    private boolean isBusy;
    private Location location;
    private float rate;


    public Bike() {
    }


    public void register(String bikeId) {
        this.bikeId = bikeId;
        this.isBusy = false;
        System.out.println("Bicicleta " + this.bikeId + "registrada com sucesso");
    }

    public void register() {
        this.bikeId = UUID.randomUUID().toString();
        this.isBusy = false;
        System.out.println("Bicicleta " + this.bikeId + " registrada com sucesso");
    }


    public void update(String field, String newValue){

        boolean validField = true;

        switch (field) {
            case "bikeId":
                this.bikeId = newValue;
                break;
            case "isBusy":
                this.isBusy = Boolean.parseBoolean(newValue);
                break;
            case "rate":
                this.rate = Float.parseFloat(newValue);
                break;
            default:
                validField = false;
                System.out.println("Campo inválido");
                break;
        }

        if (validField) {
            System.out.println("Campo " + field + " foi atualizado com sucesso!");
        }

        return;
    }


    @XmlElement(name = "bikeId")
    public String getBikeId() {
        return bikeId;
    }


    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }


    @XmlElement(name = "isBusy")
    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }


    @XmlElement(name = "rate")
    public float getRate() {
        return rate;
    }


    public void setRate(float rate) {
        this.rate = rate;
    }


    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Bike)) {
            return false;
        }
        Bike bike = (Bike) o;
        return Objects.equal(bikeId, bike.bikeId);
    }


    public String toString() {
        return "Bike{" +
                "bikeId='" + bikeId + '\'' +
                ", isBusy=" + isBusy +
                ", rate=" + rate +
                '}';
    }    
    
}




