package transportations;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {

    int dist[];
    Set<Integer> visited;
    PriorityQueue<Node> priorityQueue;
    int vertices;
    List<List<Node>> nestedNodes;

    public Graph(int vertices) {
        this.vertices = vertices;
        dist = new int[vertices];
        visited = new HashSet<>();
        priorityQueue = new PriorityQueue<>(vertices, new Node());
    }


    // Dijkstra's Algorithm implementation
    public void algorithmDijkstra(List<List<Node>> nestedNodes, int source) {
        this.nestedNodes = nestedNodes;

        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        // First add source node to PriorityQueue
        priorityQueue.add(new Node(source, 0));

        // Distance to the source from itself is 0
        dist[source] = 0;
        while (visited.size() != vertices) {

            // VisitedNode is removed from PriorityQueue and has min distance
            int visitedNode = priorityQueue.remove().node;

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
            if (!visited.contains(visitedNeighbor.node)) {
                int newDistance = dist[visitedNode] + visitedNeighbor.cost;

                // Compare distances
                if (newDistance < dist[visitedNeighbor.node]) {
                    dist[visitedNeighbor.node] = newDistance;
                }

                // Add the current vertex to the PriorityQueue
                priorityQueue.add(new Node(visitedNeighbor.node, dist[visitedNeighbor.node]));
            }
        }
    }


}
