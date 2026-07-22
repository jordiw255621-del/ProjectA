import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Booking implements costable {
    private int date; // could be int (1 - 31 for each day of month) or create custome Date obj
    private Artist artist;
    private List<Equipment> hiredEquipment;
    private List<Song> songProgram;
    private Ticket[] seats;
    static final double BASE_HIRE_PRICE = 100.0;

    public Booking() {
        this.hiredEquipment = new ArrayList<>();
        this.artist = new Artist();
        this.seats = new Ticket[Main.COLUMN_COUNT * Main.ROW_COUNT];
        this.songProgram = new ArrayList<>();
    }

    public Booking(Artist artist) {
        this.hiredEquipment = new ArrayList<>();
        this.artist = artist;
        this.seats = new Ticket[Main.COLUMN_COUNT * Main.ROW_COUNT];
    }

    public int getDate() {
        return this.date;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public List<Equipment> getHiredEquipment() {
        return this.hiredEquipment;
    }

    public void addEquipment(Equipment newEquipment) {
        this.hiredEquipment.add(newEquipment);
    }

    public void removeEquipment(String equipmentName) {
        for (int i = 0; i < this.hiredEquipment.size(); i++) {
            if (this.hiredEquipment.get(i).getName().equals(equipmentName)) {
                this.hiredEquipment.remove(i);
                System.out.println("Removed " + equipmentName);
                System.out.println("New Hire Price: " + this.getPrice());
                return;
            }
            System.out.println(equipmentName + " not in hired equipment");
        }
    }

    public void addSong(Song song) {
        this.songProgram.add(song);
    }

    // Removes ALL matches of song in songProgram List
    public void removeSong(Song song) {
        if (song == null) {
            return;
        }
        for (int i = this.songProgram.size() - 1; i >= 0; i--) {
            if (this.songProgram.get(i).getName().equals(song.getName())) {
                this.songProgram.remove(i);
            }
        }
    }

    // Removes ALL matches of song in songProgram List
    public void removeSong(String songName) {
        for (int i = this.songProgram.size() - 1; i >= 0; i--) {
            if (this.songProgram.get(i).getName().equals(songName)) {
                this.songProgram.remove(i);
            }
        }
    }

    // Removes song by number (1 - songProgram.size())
    public void removeSong(int songNum) {
        if (songNum > this.songProgram.size()
                || songNum < 1) {
            System.out.println("Invalid song number");
            return;
        }
        String removedSongName = this.songProgram.get(songNum + 1).getName();
        this.songProgram.remove(songNum + 1);
        System.out.println("removed " + removedSongName);
    }

    public void modifySongOrder(Song[] newSongOrder) {
        this.songProgram = new ArrayList<Song>(Arrays.asList(newSongOrder));
    }

    public boolean isTicketSold(int seatNum) { // seatnum = 1 - 100
        if (seatNum >= this.seats.length || seatNum < 1) {
            return false;
        }
        return this.seats[seatNum - 1].getIsSold();
    }

    public void printHiredEquipment() {
        for (Equipment e : this.hiredEquipment) {
            System.out.println(e); // this will work once Equipment.toString() exists
        }
    }

    public void printSeatView() {
        // for (int )

    }

    public double getPrice() {
        double price = BASE_HIRE_PRICE;
        for (Equipment e : this.hiredEquipment) {
            price += e.getPrice();
        }
        return price;
    }

    public void sellTicket(int ticketNumber) {
        this.seats[ticketNumber - 1].setIsSold(true);
    }

}

class Ticket {
    private final int seatNumber;
    private double price;
    private boolean isSold;
    private TicketType ticketType;

    public Ticket(int seatNumber, TicketType ticketType) {
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
        this.price = 0;
        this.isSold = false;
    }

    public boolean getIsSold() {
        return this.isSold;
    }

    public void setIsSold(boolean bool) {
        this.isSold = bool;
    }

    public void printDetails() {
    }

    public String toString() {
        if (isSold) {
            return "X";
        }
        return "O";
    }
}

enum TicketType {
    GENERAL(100.0), VIP(150.0), VIPPLUS(200.0);

    private double price;

    TicketType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}

interface costable {

    public double getPrice();
}
