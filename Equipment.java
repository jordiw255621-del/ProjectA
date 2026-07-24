class Equipment implements Costable {
    private String name;
    private EquipmentType equipmentType;
    private double hireCost; // cost per gear

    // just uses whatever the default price is for that type of gear
    Equipment(String name, EquipmentType equipmentType) {
        this.name = name;
        this.equipmentType = equipmentType;
        this.hireCost = equipmentType.getDefaultPrice();
    }

    // Overloading the constructor so we can set our own custom price, eg, the
    // artist wants different gear
    Equipment(String name, EquipmentType equipmentType, double hireCost) {
        this.name = name;
        this.equipmentType = equipmentType;
        this.hireCost = hireCost;

    }

    public String getName() {
        return this.name;
    }

    public EquipmentType getEquipmentType() {
        return this.equipmentType;
    }

    // need this cause we implement costable, booking uses it to add up total cost
    public double getPrice() {
        return this.hireCost;
    }

    // Still need a toString() method for the GUI

}

// list of equipment that artists can choose for their set
enum EquipmentType {
    DRUM_KIT(150.00),
    PIANO(300.00),
    SPEAKER(80.00),
    MICROPHONE(25.00);

    private final double defaultPrice;

    EquipmentType(double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public double getDefaultPrice() {
        return this.defaultPrice;
    }
}
