import java.util.ArrayList;
import java.util.List;

public class RideRequestSystem {
    private List<Driver> drivers;
    private GuestRequestQueue guestRequests;

    public RideRequestSystem() {
        this.drivers = new ArrayList<>();
        this.guestRequests = new GuestRequestQueue();
    }

    // Method to add a driver
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    // Method to add a guest request
    public void addGuestRequest(GuestRequest request) {
        guestRequests.addRequest(request);
    }
    // Getter for the drivers list
    public List<Driver> getDrivers() {
        return drivers;
    }

    // Core logic to assign requests to drivers
    public void enhancedAssignRequestsToDrivers() {
        while (!guestRequests.isEmpty()) {
            for (Driver driver : drivers) {
                if (isDriverAvailable(driver)) {
                    assignRequestsToDriver(driver);
                }
            }
        }
    }

    private boolean isDriverAvailable(Driver driver) {
        return driver.getLocalQueue().size() < driver.getVehicleCapacity();
    }

    private void assignRequestsToDriver(Driver driver) {
        while (!guestRequests.isEmpty() && driver.getLocalQueue().size() < driver.getVehicleCapacity()) {
            GuestRequest request = findOptimalRequestForDriver(driver);
            if (request != null) {
                driver.addGuestRequestToQueue(request);
                guestRequests.remove(request); // Assuming a method to remove a specific request
            } else {
                break; // No suitable request found for this driver
            }
        }
    }

    private GuestRequest findOptimalRequestForDriver(Driver driver) {
        GuestRequest optimalRequest = null;
        int minETA = Integer.MAX_VALUE;

        List<GuestRequest> requests = guestRequests.asList(); // Get a list of requests for iteration
        for (GuestRequest request : requests) {
            if (canAccommodateRequest(driver, request)) {
                int eta = calculateETA(driver.getCurrentLocation(), request.getPickupLocation());
                if (eta < minETA) {
                    minETA = eta;
                    optimalRequest = request;
                }
            }
        }
        return optimalRequest;
    }


    private boolean canAccommodateRequest(Driver driver, GuestRequest request) {
        return driver.getVehicleCapacity() - driver.getLocalQueue().size() >= request.getNumberOfGuests();
    }

    // ADd some method to calculate ETA with Google Maps API
    private int calculateETA(String driverLocation, String requestLocation) {
        // ETA calculation
        return 0;
    }

}
