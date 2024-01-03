import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String driverId;
    private String currentLocation;
    private int vehicleCapacity;
    private List<GuestRequest> localQueue;

    public Driver(String driverId, String currentLocation, int vehicleCapacity) {
        this.driverId = driverId;
        this.currentLocation = currentLocation;
        this.vehicleCapacity = vehicleCapacity;
        this.localQueue = new ArrayList<>();
    }

    // Method to add a guest request to the local queue
    public void addGuestRequestToQueue(GuestRequest request) {
        if (localQueue.size() < vehicleCapacity) {
            localQueue.add(request);
        } else {
            // Handle the case where the vehicle is at capacity
            System.out.println("Cannot add more guests. Vehicle at capacity.");
        }
    }

    // Method to remove a guest request from the local queue
    public void removeGuestRequestFromQueue(GuestRequest request) {
        localQueue.remove(request);
    }

    // Method to update the driver's current location
    public void updateCurrentLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    // Getters
    public String getDriverId() {
        return driverId;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public List<GuestRequest> getLocalQueue() {
        return localQueue;
    }

    // Setters
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setVehicleCapacity(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", vehicleCapacity=" + vehicleCapacity +
                ", localQueue=" + localQueue +
                '}';
    }
}
