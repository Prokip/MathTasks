package transportations;

import java.util.Comparator;
import java.util.Objects;

class Node implements Comparator<Node> {

    public int node;
    public int cost;

    public Node() {
    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
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
