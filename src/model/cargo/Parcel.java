package model.cargo;

public class Parcel extends Cargo {
    private String from;
    private String to;
    private Passenger owner;

    public Parcel(int weight, String from, String to, Passenger owner) {
        super(weight);
        this.from = from;
        this.to = to;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "    Parcel: " +
                "\n      id: " + getId() +
                "\n      from address: " + from + '\'' +
                "\n      to address: " + to + '\'' +
                "\n      owner: {id: " + owner.getId() + ", name: " + owner.getName() + "}";
    }
}
