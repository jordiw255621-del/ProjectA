import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

  // represents how many rows and columns for the seats for the venue
  static final int ROW_COUNT = 10;
  static final int COLUMN_COUNT = 10;
  static final int NUM_OF_DAYS = 31;
  private List<Person> registeredUsers;
  private Map<Integer, Booking> dateToBooking;

  Main() {

    this.registeredUsers = new ArrayList<>();

    // initialise dateToBooking with 31 empty slots
    this.dateToBooking = new HashMap<>();
    for (int i = 1; i < NUM_OF_DAYS + 1; i++) {
      this.dateToBooking.put(i, null);
    }
  }

  public void addUser(Person person) {
    this.registeredUsers.add(person);
  }

  public void displayUsers() {
    for (Person user : this.registeredUsers) {
      System.out.println(user);
    }
  }

  public void displayArtists() {
    for (Person user : this.registeredUsers) {
      if (user instanceof Artist) {
        System.out.println((Artist) user);
      }
    }
  }

  public void displayFans() {
    for (Person user : this.registeredUsers) {
      if (user instanceof Fan) {
        System.out.println((Fan) user);
      }
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

  public void displayBookings() {
    for (Map.Entry<Integer, Booking> e : this.dateToBooking.entrySet()) {
      if (e.getValue() != null) {
        System.out.println(e.getValue() + ", " + "MONTH," + e.getKey());
      }
    }
  }

}

class Menu {

}
