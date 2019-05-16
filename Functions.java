import java.util.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;


public class Functions {

    public static void addToPaths(Node target, Node source) {
        if (target.pathsNodes.containsKey(source)) {
            double val = (Double)target.pathsNodes.get(source);
            val += (Double)source.pathsNodes.get(source);
            target.pathsNodes.put(source, val);
        } else {
            target.pathsNodes.put(source, (double)source.numberOfPaths * 1.0D);
        }

        Iterator var6 = source.pathsNodes.keySet().iterator();

        while(var6.hasNext()) {
            Node cur = (Node)var6.next();
            if (target.pathsNodes.containsKey(cur)) {
                double val = (Double)target.pathsNodes.get(cur);
                val += (Double)source.pathsNodes.get(cur);
                target.pathsNodes.put(cur, val);
            } else {
                target.pathsNodes.put(cur, (Double)source.pathsNodes.get(cur));
            }
        }
    }

    public static void modified_BFS(Graph graph) {
        Node cur;
        for(Iterator var1 = graph.Vertices.iterator(); var1.hasNext(); cur.numberOfPaths = 0) {
            cur = (Node)var1.next();
            cur.numberOfPaths = 1;
            BFS(cur);
            Iterator var3 = graph.Vertices.iterator();

            Node x;
            while(var3.hasNext()) {
                x = (Node)var3.next();
                calcLoad(x);
            }

            for(var3 = graph.Vertices.iterator(); var3.hasNext(); x.pathsNodes = new HashMap()) {
                x = (Node)var3.next();
                x.numberOfPaths = 0;
                x.distance = 2147483647;
            }
            cur.distance = 2147483647;
        }
    }

    private static void BFS(Node root) {
        Queue<Node> queue = new ArrayDeque();
        Set<Character> addedToqueue = new HashSet();
        addedToqueue.add(root.id);
        queue.add(root);
        root.distance = 0;

        while(!queue.isEmpty()) {
            Node cur = (Node)((ArrayDeque)queue).removeFirst();
            Iterator var4 = cur.adj.iterator();

            while(var4.hasNext()) {
                Node neighbor = (Node)var4.next();
                if (neighbor.distance >= cur.distance + 1) {
                    neighbor.distance = cur.distance + 1;
                    neighbor.numberOfPaths += cur.numberOfPaths;
                    if (!addedToqueue.contains(neighbor.id)) {
                        queue.add(neighbor);
                        addedToqueue.add(neighbor.id);
                    }
                    if (cur.id != root.id) {
                        addToPaths(neighbor, cur);
                    }
                }
            }
        }
    }

    private static void calcLoad(Node cur) {
        Node x;
        double val;
        for(Iterator var1 = cur.pathsNodes.keySet().iterator(); var1.hasNext(); x.load += val / (double)cur.numberOfPaths) {
            x = (Node)var1.next();
            val = (Double)cur.pathsNodes.get(x);
        }
    }
}

