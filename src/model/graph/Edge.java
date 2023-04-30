package model.graph;

import model.IdGenerator;

public class Edge {
    private final int id;
    private final Node source;
    private final Node destination;
    private final int weight;
    private volatile boolean isUsedByLocomotive;

    public Edge(Node source, Node destination, int weight) {
        this.id = IdGenerator.getId();
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public synchronized boolean isUsedByLocomotive() {
        return isUsedByLocomotive;
    }

    public synchronized void setUsedByLocomotive(boolean usedByLocomotive) {
        isUsedByLocomotive = usedByLocomotive;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "id='" + id + '\'' +
                ", source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
