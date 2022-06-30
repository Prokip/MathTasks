package transportations;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {

    int[] distance;
    Set<Integer> visited;
    PriorityQueue<Node> priorityQueue;
    int vertices;
    List<List<Node>> nestedNodes;

    public Graph(int vertices) {
        this.vertices = vertices;
        distance = new int[vertices];
        visited = new HashSet<>();
        priorityQueue = new PriorityQueue<>(vertices, new Node());
    }


    // Dijkstra's Algorithm implementation
    public void algorithmDijkstra(List<List<Node>> nestedNodes, int source) {
        this.nestedNodes = nestedNodes;

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // First add source node to PriorityQueue
        priorityQueue.add(new Node(source, 0));

        // Distance to the source from itself is 0
        distance[source] = 0;
        while (visited.size() != vertices) {

            // VisitedNode is removed from PriorityQueue and has min distance
            int visitedNode = priorityQueue.remove().getNode();

            // Add node to finalized list as visited
            visited.add(visitedNode);
            nodesNeighbors(visitedNode);
        }
    }

    // This methods processes all neighbours of the just visited node
    private void nodesNeighbors(int visitedNode) {

        // Process all neighbouring nodes of visitedNode
        for (int i = 0; i < nestedNodes.get(visitedNode).size(); i++) {
            Node visitedNeighbor = nestedNodes.get(visitedNode).get(i);

            //  Proceed only if current node is not in visited
            if (!visited.contains(visitedNeighbor.getNode())) {
                int newDistance = distance[visitedNode] + visitedNeighbor.getCost();

                // Compare distances
                if (newDistance < distance[visitedNeighbor.getNode()]) {
                    distance[visitedNeighbor.getNode()] = newDistance;
                }

                // Add the current vertex to the PriorityQueue
                priorityQueue.add(new Node(visitedNeighbor.getNode(), distance[visitedNeighbor.getNode()]));
            }
        }
    }


}
