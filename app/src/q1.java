import java.util.*;

/**
 * Book My Stay App
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Demonstrates FIFO booking processing, unique room allocation,
 * and prevention of double-booking.
 *
 * @author Muskan
 * @version 6.0
 */
public class q1 {

    public static void main(String[] args) {

        // Queue for booking requests (FIFO)
        Queue<String> bookingQueue = new LinkedList<>();

        bookingQueue.add("Single");
        bookingQueue.add("Double");
        bookingQueue.add("Suite");

        // Inventory count
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);

        // Stores all allocated room IDs (global uniqueness)
        Set<String> allocatedRoomIds = new HashSet<>();

        // Maps room type -> allocated room IDs
        HashMap<String, Set<String>> roomAllocations = new HashMap<>();

        System.out.println("Welcome to Book My Stay App");
        System.out.println("Hotel Booking System v6.0\n");

        int roomCounter = 101;

        while (!bookingQueue.isEmpty()) {
            String roomType = bookingQueue.poll(); // dequeue FIFO

            int available = inventory.get(roomType);

            if (available > 0) {
                String roomId = roomType.substring(0, 1) + roomCounter;

                // uniqueness check
                if (!allocatedRoomIds.contains(roomId)) {

                    // add room id globally
                    allocatedRoomIds.add(roomId);

                    // add room id to room type map
                    roomAllocations.putIfAbsent(roomType, new HashSet<>());
                    roomAllocations.get(roomType).add(roomId);

                    // decrement inventory immediately
                    inventory.put(roomType, available - 1);

                    System.out.println("Booking Confirmed");
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Allocated Room ID: " + roomId);
                    System.out.println("Remaining: " + inventory.get(roomType));
                    System.out.println();

                    roomCounter++;
                }
            } else {
                System.out.println("No rooms available for " + roomType);
                System.out.println();
            }
        }

        System.out.println("Final Allocations: " + roomAllocations);
    }
}
