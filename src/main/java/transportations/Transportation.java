package transportations;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class Transportation {

    private final Logger logger = LoggerFactory.getLogger(Transportation.class);

    public void testExecute(Scanner scanner) {

        Map<String, Integer> mapCities = new HashMap<>();

        System.out.println("Please, enter number of tests:");
        int tests = scanner.nextInt();

        // The number of tests
        new Validation().validateNumberOfTests(tests);
        collectAllTests(scanner, mapCities, tests);
    }

    private void collectAllTests(Scanner scanner, Map<String, Integer> mapCities, int tests) {
        logger.info("Program starts tests " + tests);
        for (int k = 0; k < tests; k++) {

            // The number of cities <= 10000
            System.out.println("Enter number of cities:");
            int vertices = scanner.nextInt();
            new Validation().validateNumberOfCities(vertices);

            // Nested list representation of graph
            List<List<Node>> nestedNodes = new ArrayList<>();

            // Initialize neighbor list for every node in the graph
            collectCities(scanner, mapCities, vertices, nestedNodes);

            ArrayList<Node> arrayList = collectPaths(scanner, mapCities);

            getResult(vertices, nestedNodes, arrayList);
        }
    }

    private void getResult(int vertices, List<List<Node>> nestedNodes, ArrayList<Node> arrayList) {
        for (Node node : arrayList) {
            // Call Dijkstra's algorithm method
            Graph graph = new Graph(vertices);
            graph.algorithmDijkstra(nestedNodes, node.node - 1);

            // Print the shortest path from source node to all the nodes
            System.out.println("The shorted path from source city to destination city :");
            System.out.println("Source " + " Destination " + " Distance ");
            System.out.println(node.node + " \t\t\t " + node.cost + " \t\t\t " + graph.dist[node.cost - 1]);
        }
    }

    private ArrayList<Node> collectPaths(Scanner scanner, Map<String, Integer> mapCities) {
        System.out.println("Enter number of paths:");
        int path = scanner.nextInt();
        ArrayList<Node> arrayList = new ArrayList<>(path);
        for (int i = 0; i < path; i++) {
            arrayList.add(new Node(mapCities.get(scanner.next()), mapCities.get(scanner.next())));
        }
        return arrayList;
    }

    private void collectCities(Scanner scanner, Map<String, Integer> mapCities, int vertices, List<List<Node>> nestedNodes) {
        for (int i = 0; i < vertices; i++) {
            List<Node> item = new ArrayList<>();
            nestedNodes.add(item);

            System.out.println("Enter name of city:");
            String str = scanner.next();
            new Validation().validateNameOfCity(str);

            // Collect indexes of a cities connected to names (the index of the first city is 1)
            mapCities.put(str, i + 1);

            collectNeighbors(scanner, nestedNodes, i);
        }
    }

    private void collectNeighbors(Scanner scanner, List<List<Node>> nestedNodes, int i) {
        System.out.println("Enter number of neighbors:");
        int neighbors = scanner.nextInt();
        new Validation().validateNumberOfNeighbors(neighbors);

        for (int j = 0; j < neighbors; j++) {
            nestedNodes.get(i).add(new Node(scanner.nextInt() - 1, scanner.nextInt()));
        }
    }


}


