import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GuestRequestQueue {
    private PriorityQueue<GuestRequest> queue;

    public GuestRequestQueue() {
        // compares guest requests based on wait time
        this.queue = new PriorityQueue<>(Comparator.comparingInt(GuestRequest::getWaitTime));
    }
    public void remove(GuestRequest request) {
        queue.remove(request);
    }
    public List<GuestRequest> asList() {
        return new ArrayList<>(queue);
    }

    // Adds a guest request to the queue
    public void addRequest(GuestRequest request) {
        queue.add(request);
    }

    // Retrieves and removes the head of this queue, or returns null if this queue is empty
    public GuestRequest getNextRequest() {
        return queue.poll();
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Returns the number of elements in the queue
    public int size() {
        return queue.size();
    }

    // Clears all elements from the queue
    public void clear() {
        queue.clear();
    }

    // Peek at the head of the queue without removing it, returns null if the queue is empty
    public GuestRequest peekNextRequest() {
        return queue.peek();
    }

    @Override
    public String toString() {
        return "GuestRequestQueue{" +
                "queue=" + queue +
                '}';
    }
}
