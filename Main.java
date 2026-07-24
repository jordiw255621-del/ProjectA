import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

  // represents how many rows and columns for the seats for the venue
  static final int ROW_COUNT = 10;
  static final int COLUMN_COUNT = 10;
  static final int NUM_OF_DAYS = 31;
  private List<Booking> bookings;
  private Map<Integer, Booking> dateToBooking;

  Main() {
    // initialise dateToBooking with 31 empty slots
    this.dateToBooking = new HashMap<>();
    for (int i = 1; i < NUM_OF_DAYS + 1; i++) {
      this.dateToBooking.put(i, null);
    }
  }

  // used for Making new Booking or modifying existing booking
  public void makeBooking(Booking booking) {
    if (booking == null) {
      System.out.println("Invalid booking");
    } else if (!this.dateToBooking.containsKey(booking.getDate())) {
      System.out.println("Invalid date (Must be 1 - 31)");
    } else if (this.dateToBooking.get(booking.getDate()) != null) {
      System.out.println("Booking already exists");
    } else {
      this.dateToBooking.put(booking.getDate(), booking);
    }
  }

  public void removeBooking(Booking booking) {
    if (this.dateToBooking.containsKey(booking.getDate())) {
      this.dateToBooking.put(booking.getDate(), null);
    }
  }

}

class Menu {

}
