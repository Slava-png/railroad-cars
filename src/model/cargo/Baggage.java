package model.cargo;

public class Baggage extends Cargo {
    private Passenger person;
    private String baggageType;

    public Baggage(int weight, Passenger person, String baggageType) {
        super(weight);
        this.person = person;
        this.baggageType = baggageType;
    }

    @Override
    public String toString() {
        return "    Baggage: " +
                "\n      id: " + getId() +
                "\n      person: {id: " + person.getId() + ", name: " + person.getName() + "}" +
                "\n      baggage type: " + baggageType;
    }
}
