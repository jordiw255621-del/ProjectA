import java.util.ArrayList;
import java.util.List;

public class Booking implements costable{ 
    private int date; // could be int (1 - 31 for each day of month) or create custome Date obj
    private Artist artist;
    private List<Equipment> hiredEquipment;
    private Ticket[] seats;
    static final double BASE_HIRE_PRICE = 100.0;

    public Booking() {
        this.hiredEquipment = new ArrayList<>();
        this.artist = new Artist();
        this.seats = new Ticket[Main.COLUMN_COUNT * Main.ROW_COUNT];
    }

    public Booking(Artist artist) {
        this.hiredEquipment = new ArrayList<>();
        this.artist = artist;
        this.seats = new Ticket[Main.COLUMN_COUNT * Main.ROW_COUNT];
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
                // Would print out updated cost, by either subtracting from a "total cost"
                // or calling "getPrice()" function
                return;
            }
            System.out.println(equipmentName + " not in hired equipment");
        }
    }

    public boolean isTicketSold(int seatNum) { // seatnum = 1 - 100
        if (seatNum >= this.seats.length || seatNum < 1) {
            return false;
        }
        return this.seats[seatNum - 1].getIsSold();
    }

    public void printHiredEquipment() {
        for (Equipment e : this.hiredEquipment) {
            System.out.println(e); //this will work once Equipment.toString() exists
        }
    }
    public void printSeatView() {

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
    GENERAL, VIP, IDK;
}

interface costable {

    public double getPrice();
}
