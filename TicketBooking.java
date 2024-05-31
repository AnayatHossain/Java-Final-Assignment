import java.util.LinkedList;
import java.util.Queue;

class TicketBookingSystem {
    private Queue<String> ticketRequests = new LinkedList<>();

    public void addBookingRequest(String customerName) {
        ticketRequests.offer(customerName);
    }

    public void processBookings() {
        while (!ticketRequests.isEmpty()) {
            String customer = ticketRequests.poll();
            System.out.println("Booking processed for: " + customer);
        }
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();
        bookingSystem.addBookingRequest("Anayat");
        bookingSystem.addBookingRequest("Murad");
        bookingSystem.addBookingRequest("Sahajuddin");

        bookingSystem.processBookings();
    }
}
