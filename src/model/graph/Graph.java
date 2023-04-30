package model.graph;

import java.util.*;

public class Graph {
    private Map<String, Node> nodeMap = new HashMap<>();
    private Map<Node, List<Edge>> edgeMap = new HashMap<>();

    public Map<String, Node> getNodeMap() {
        return nodeMap;
    }

    public Set<String> getNamesOfStations() {
        return nodeMap.keySet();
    }

    public Map<Node, List<Edge>> getEdgeMap() {
        return edgeMap;
    }

    public List<Edge> getEdges(Node node) {
        return edgeMap.get(node);
    }

    public Node getNodeByName(String name) {
        Node node = nodeMap.get(name);

        if (node == null) {
//            System.out.println("There is no such station as " + name);
            return null;
        }
        return node;
    }

    public void addNode(Node node) {
        if (nodeMap.containsKey(node.getName())) {
            System.out.println("Such station already exists in your list");
            return;
        }

        nodeMap.put(node.getName(), node);
    }

    public void addNode(String name) {
        addNode(new Node(name));
    }

    public Node removeNode(String station) {
        Node removedNode = null;
        if (nodeMap.containsKey(station)) {
            removedNode = nodeMap.get(station);
            nodeMap.remove(station);
        }
        return removedNode;
    }

    public void addEdge(Edge edge) {
        List<Edge> edges;
        Node source = edge.getSource();

        if (edgeMap.get(source) == null) {
            edges = new ArrayList<>();
        } else {
            edges = edgeMap.get(source);
        }

        edges.add(edge);
        edgeMap.put(source, edges);
    }

    public void addEdge(String sourceName, String destinationName, int weight) {
        Node source = getNodeByName(sourceName);
        Node destination = getNodeByName(destinationName);

        addEdge(new Edge(source, destination, weight));
    }

    public void addEdge(Node source, Node destination, int weight) {
        addEdge(new Edge(source, destination, weight));
    }

    public void addMultipleEdges(String sourceName, String destinationNames, String weights) {
        Node source = getNodeByName(sourceName);
        String[] strings = destinationNames.split(" ");
        String[] mass = weights.split(" ");

        for (int i = 0; i < strings.length; i++) {
            addEdge(source, getNodeByName(strings[i]), Integer.parseInt(mass[i]));
        }
    }

    public Edge removeEdge(Edge edge) {
        Edge removedEdge = null;

        if (edgeMap.get(edge.getSource()).contains(edge)) {
            removedEdge = edge;
            edgeMap.get(edge.getSource()).remove(edge);
        }

        return removedEdge;
    }

    public List<Node> dijkstra(Node source, Node destination) {
        Map<Node, Double> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        Set<Node> visitedNodes = new HashSet<>();

        distances.put(source, 0.0);

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(source);

        while (!queue.isEmpty()) {
            // takes first element, and deletes it from queue
            Node currentNode = queue.poll();
            if (currentNode == destination) {
                // build path by using hashmap previousNodes
                return buildPath(destination, previousNodes);
            }

            // nodes which was visited (using them path is build)
            visitedNodes.add(currentNode);

            edgeMap.get(currentNode);

            for (Edge edge : edgeMap.get(currentNode)) {
                Node neighbor = edge.getDestination();
                // check if this node is already checked (present among other in set)
                if (visitedNodes.contains(neighbor)) {
                    continue;
                }

                // calculate distance from beginning till this point of path
                double tentativeDistance = distances.get(currentNode) + edge.getWeight();
                // get distance from map or (if it doesn't exist) infinity
                if (tentativeDistance < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, tentativeDistance);
                    previousNodes.put(neighbor, currentNode);
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Node> buildPath(Node destination, Map<Node, Node> previousNodes) {
        List<Node> path = new ArrayList<>();
        Node currentNode = destination;

        while (previousNodes.containsKey(currentNode)) {
            path.add(0, currentNode);
            currentNode = previousNodes.get(currentNode);
        }

        path.add(0, currentNode);
        return path;
    }

    public List<Edge> getShortestPath(Node source, Node destination) {
        List<Node> dijkstra = dijkstra(source, destination);
        List<Edge> edgesList = new ArrayList<>();

        for (int i = 0; i < dijkstra.size() - 1; i++) {
            List<Edge> edges = edgeMap.get(dijkstra.get(i));

            for (Edge edge: edges) {
                if (edge.getSource().equals(dijkstra.get(i)) && edge.getDestination().equals(dijkstra.get(i+1))) {
                    edgesList.add(edge);
                    break;
                }
            }
        }

        return edgesList;
    }
}
