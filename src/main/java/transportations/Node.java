package transportations;

import java.util.Comparator;
import java.util.Objects;

class Node implements Comparator<Node> {

    private int node;
    private int cost;

    public Node() {
    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.cost, node2.cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node1 = (Node) o;
        return node == node1.node &&
                cost == node1.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, cost);
    }
}
