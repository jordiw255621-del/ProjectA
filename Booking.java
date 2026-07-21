import java.util.ArrayList;
import java.util.List;

class Booking {
    private List<Equipment> hiredEquipment;
    private Artist artist;

    Booking() {
        this.hiredEquipment = new ArrayList<>();
    }

    Booking(Artist artist) {
        this.hiredEquipment = new ArrayList<>();
        this.artist = artist;
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
}

class Ticket {

}

interface costable {

    public double getPrice();
}
