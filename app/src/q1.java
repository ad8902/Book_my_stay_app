import java.util.*;

/**
 * Book My Stay App
 * Use Case 7: Add-On Service Selection
 *
 * Demonstrates optional service selection using
 * Map and List data structures.
 *
 * @author Muskan
 * @version 7.0
 */

// Service class
class Service {
    private String serviceName;
    private double cost;

    public Service(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String toString() {
        return serviceName + " (₹" + cost + ")";
    }
}

public class q1 {

    public static void main(String[] args) {

        // Reservation ID
        String reservationId = "RES101";

        // Selected services list
        List<Service> selectedServices = new ArrayList<>();

        selectedServices.add(new Service("Breakfast", 500));
        selectedServices.add(new Service("Airport Pickup", 1200));
        selectedServices.add(new Service("Spa Access", 1500));

        // Mapping reservation -> services
        Map<String, List<Service>> reservationServices = new HashMap<>();
        reservationServices.put(reservationId, selectedServices);

        // Calculate total add-on cost
