public class GuestRequest {
    private String requestId;
    private int waitTime; // in minutes
    private int numberOfGuests;
    private String pickupLocation;

    public GuestRequest(String requestId, int waitTime, int numberOfGuests, String pickupLocation) {
        this.requestId = requestId;
        this.waitTime = waitTime;
        this.numberOfGuests = numberOfGuests;
        this.pickupLocation = pickupLocation;
    }

    // Getters
    public String getRequestId() {
        return requestId;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    // Setters
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public boolean isEmpty()
    {
        if (numberOfGuests == 0)
            return true;
        else
            return false;
    }
    @Override
    public String toString() {
        return "GuestRequest{" +
                "requestId='" + requestId + '\'' +
                ", waitTime=" + waitTime +
                ", numberOfGuests=" + numberOfGuests +
                ", pickupLocation='" + pickupLocation + '\'' +
                '}';
    }
}