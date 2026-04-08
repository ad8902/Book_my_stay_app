import java.util.*;

/**
 * Book My Stay App
 * Use Case 8: Booking History & Reporting
 *
 * Demonstrates booking history tracking and report generation.
 *
 * @author Muskan
 * @version 8.0
 */

// Reservation class
class Reservation {
    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId +
                ", Guest: " + guestName +
                ", Room Type: " + roomType;
    }
}

// Report service class
class BookingReportService {
    public void generateReport(List<Reservation> history) {
        System.out.println("\n--- Booking History Report ---");

        for (Reservation reservation : history) {
            System.out.println(reservation);
        }

        System.out.println("\nTotal Confirmed Bookings: " + history.size());
    }
}

public class q1 {

    public static void main(String[] args) {

        // Booking history list (ordered)
        List<Reservation> bookingHistory = new ArrayList<>();

        // Add confirmed bookings
        bookingHistory.add(new Reservation("RES101", "Aarav", "Single"));
        bookingHistory.add(new Reservation("RES102", "Diya", "Double"));
        bookingHistory.add(new Reservation("RES103", "Rohan", "Suite"));

        System.out.println("Welcome to Book My Stay App");
        System.out.println("Hotel Booking System v8.0");

        // Admin requests report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(bookingHistory);
    }
}
