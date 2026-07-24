import java.util.ArrayList;
import java.util.List;

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
