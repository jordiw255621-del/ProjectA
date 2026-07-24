
// the fan is just a normal user who buys/reserves tickets to shows

import java.util.ArrayList;
import java.util.List;

public class Fan extends Person {
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
