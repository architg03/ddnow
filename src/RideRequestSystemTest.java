public class RideRequestSystemTest {

    public static void main(String[] args) {
        // Create the system
        RideRequestSystem system = new RideRequestSystem();

        // Add some drivers
        system.addDriver(new Driver("Driver1", "Location1", 3));
        system.addDriver(new Driver("Driver2", "Location2", 2));

        // Add some guest requests
        system.addGuestRequest(new GuestRequest("Request1", 5, 1, "PickupLocation1"));
        system.addGuestRequest(new GuestRequest("Request2", 10, 2, "PickupLocation2"));
        system.addGuestRequest(new GuestRequest("Request3", 3, 1, "PickupLocation3"));
        // Add tests for requests above driver capacities
        // Assign requests to drivers
        system.enhancedAssignRequestsToDrivers();

        // Check
        for (Driver driver : system.getDrivers()) {
            System.out.println("Driver ID: " + driver.getDriverId() + ", Queue: " + driver.getLocalQueue());
        }
    }
}