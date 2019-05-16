import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    char id;
    int numberOfPaths;
    int distance;
    List<Node> adj;
    Map<Node, Double> pathsNodes;
    double load;

    public Node(char Id) {
        this.id = Id;
        this.numberOfPaths = 0;
        this.distance = Integer.MAX_VALUE;
        this.adj = new LinkedList();
        this.pathsNodes = new HashMap();
        this.load = 0.0D;
    }

    public static void addEdge(Node source, Node target) {
        source.adj.add(target);
        target.adj.add(source);
    }
}

