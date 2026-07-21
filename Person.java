import java.util.ArrayList;
import java.util.List;

// the parent class that branches out to Fan and Artist classes
abstract class Person {
    private String name;
    private String email;

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    // every person has a role but only the child classes actually know what it is
    public abstract String getRole();

    public String toString() {
        return getRole() + ": " + this.name + " (" + this.email + ")";
    }
}

// the fan is just a normal user who buys/reserves tickets to shows
class Fan extends Person {
    private List<Ticket> purchasedTickets;

    Fan(String name, String email) {
        super(name, email);
        this.purchasedTickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        this.purchasedTickets.add(ticket);
    }

    public List<Ticket> getPurchasedTickets() {
        return this.purchasedTickets;
    }

    @Override
    public String getRole() {
        return "Fan";
    }
}

// the artist is who actually books the slot + picks their gear for the show
class Artist extends Person {
    private String genre;
    private List<Equipment> requestedEquipment;

    // no args constructor so Booking can make a placeholder artist for now
    Artist() {
        this("Unknown", "unknown@gmail.com", "Unspecified");
    }

    Artist(String name, String email, String genre) {
        super(name, email);
        this.genre = genre;
        this.requestedEquipment = new ArrayList<>();
    }

    public void addEquipment(Equipment item) {
        this.requestedEquipment.add(item);
    }

    public List<Equipment> getRequestedEquipment() {
        return this.requestedEquipment;
    }

    public String getGenre() {
        return this.genre;
    }

    @Override
    public String getRole() {
        return "Artist";
    }
}
