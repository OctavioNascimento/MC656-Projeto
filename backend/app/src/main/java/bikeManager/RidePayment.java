package bikeManager;


import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateTimeAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import exceptions.*;


@XmlRootElement(name="RidePayment")
public class RidePayment implements Payment{
    
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private LocalDateTime rideEndTime;
    private Long rideDurationTime; // duração da corrida em segundos
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;
    private Plan plan;

    public RidePayment(){
        
    }

    /**
     * Constructs a new {@code RidePayment} instance.
     * <p>
     * This constructor initializes a new payment for a ride, generating a unique payment ID and 
     * calculating the amount based on the distance of the ride and the payment method.
     * </p>
     * 
     * @param rideId         The unique identifier for the ride.
     * @param rideStartTime  The start time of the ride. Must not be {@code null}.
     * @param rideDistance   The distance traveled during the ride, in kilometers.
     * @param paymentMethod  The payment method selected by the user (e.g., "credit", "cash").
     * 
     */
    public RidePayment(String rideId, LocalDateTime rideStartTime, LocalDateTime rideEndTime, long rideDurationTime, String paymentMethod, String plan) {
        if (rideId == null || rideId.isEmpty()) {
            throw new IllegalArgumentException("Ride ID cannot be null or empty");
        }
        if (rideStartTime == null || rideEndTime == null) {
            throw new NullPointerException("Ride start time or Ride end time cannot be null");
        }

        this.paymentId = UUID.randomUUID().toString();
        this.rideId = rideId;

        this.rideStartTime = rideStartTime;
        this.rideEndTime = rideEndTime;
        this.rideDurationTime = rideDurationTime;

        this.paymentMethod = this.selectPaymentMethod(paymentMethod);
        this.plan = this.selectPlan(plan);

        if (this.paymentMethod == null) throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
        if (this.plan == null) throw new IllegalArgumentException("Invalid plan: " + plan);


        System.out.println("Forma de pagamento selecionada: " + paymentMethod);
        System.out.println("Plano selecionado: " + plan);

        this.amount = this.calculateValue();
    }


    /**
     * Selects a PaymentOption from a given string.
     * @param paymentMethod the name of the payment method
     * @return the selected PaymentOption
     */
    private PaymentOption selectPaymentMethod(String paymentMethod) {
        return PaymentOption.valueOfName(paymentMethod);
    }

    private Plan selectPlan(String plan) {
        return Plan.valueOfName(plan);
    }


    /**
     * Calculates the total amount of the ride payment.
     * 
     * <p>
     * The amount is calculated based on the ride distance and the payment method selected by the user.
     * The algorithm used is as follows:
     * <ol>
     * <li>Identify the distance range using the following intervals: [0, 5], [5, 10], [10, 15], [15, 20], [20, 25].</li>
     * <li>Select the initial and per km price based on the identified distance range and the time of day (day or night).</li>
     * <li>Calculate the total amount by adding the initial price and the price per km multiplied by the ride distance.</li>
     * <li>Apply the payment method fee to the total amount.</li>
     * </ol>
     * 
     * @return the calculated amount
     */
    public float calculateValue() {

        float _amount = this.paymentMethod.calculatePaymentFee(this.plan.getPrice() + (this.rideDurationTime * 0.25f) + (this.rideDistance * this.paymentMethod.calculatePaymentFee(1.0f)));
        
        this.amount = Math.round(_amount * 100) / 100.0f;

        return this.amount;
    }

    
    /**
     * Processa o pagamento da corrida.
    */
    public void processPayment() {
        System.out.println("Valor da corrida definido: " + this.amount);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }

    public void setRideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }

    public float getRideDistance() {
        return rideDistance;
    }

    public void setRideDistance(float rideDistance) {
        this.rideDistance = rideDistance;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public PaymentOption getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentOption paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
