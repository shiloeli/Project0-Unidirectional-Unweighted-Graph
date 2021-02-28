package ex0;

import java.util.*;

/**
 * This class implement graph_algorithms and apply basics algorithms of graph theory
 * clone(); (copy)
 * init(graph);
 * isConnected();
 * int shortestPathDist(int src, int dest);
 * List<node_data> shortestPath(int src, int dest);
 *
 * graph- Is an abstract representation of a set of nodes,
 * where each pair of node in the set may be linked together.
 */

public class Graph_Algo implements graph_algorithms {

    private graph graph;

    /**
     * A constructor that points to a new graph.
     */
    public Graph_Algo() {
        this.graph = new Graph_DS();
    }

    /**
     * Bfs algorithm, an algorithm that marks each node in a graph
     * relative to its relative position in the graph,
     * The algorithm will get a first node and mark in the tag
     * of the other nodes the locations according to the given node.
     *
     * @param node The node from which the algorithm will start.
     */
    public void BFS(node_data node) {
        Collection<node_data> c = this.graph.getV();
        Iterator<node_data> i = this.graph.getV().iterator();
        while (i.hasNext()) {
            node_data temp = i.next();
            temp.setInfo("white");
            temp.setTag(-1);
        }
        Queue<node_data> q =new LinkedList<node_data>();;
        node.setTag(0);
        node.setInfo("black");
        q.add(node);
        while (!q.isEmpty()) {
            Collection<node_data> c3 = node.getNi();
            Iterator<node_data> i3 = c3.iterator();
            while (i3.hasNext()) {
                node_data neighbor = i3.next();
                if (neighbor.getInfo().equalsIgnoreCase("white")) {
                    q.add(neighbor);
                    neighbor.setTag(node.getTag() + 1);
                    neighbor.setInfo("black");
                }
            }
            q.poll();
            node = q.peek();
        }
    }

    /**
     The method will point to the given graph.
     *
     * @param g The graph we will point to
     */
    @Override
    public void init(graph g) {
        this.graph = g;
    }

    /**
     *Make a copy of the given graph using deep copying.
     *
     * @return The copy of the graph.
     */
    @Override
    public graph copy() {
        graph copy = new Graph_DS();
        Collection<node_data> c = this.graph.getV();
        Iterator<node_data> i = c.iterator();
        while (i.hasNext()) {
            node_data temp = i.next();
            NodeData n = new NodeData();
            n.setkey(temp.getKey());
            n.setInfo(temp.getInfo());
            n.setTag(temp.getTag());
            copy.addNode(n);
        }
        Collection<node_data> c2 = copy.getV();
        Iterator<node_data> i2 = c2.iterator();
        while (i2.hasNext()) {
            node_data temp2 = i2.next();
            Collection<node_data> c3 = this.graph.getNode(temp2.getKey()).getNi();
            Iterator<node_data> i3 = c3.iterator();
            while (i3.hasNext()) {
                copy.connect(temp2.getKey(), i3.next().getKey());
            }
        }
        return copy;
    }

    /**
     * Returns true if and only if there is a valid edge from each node
     * to any other node in the graph, i.e. if the entire graph is linked.
     *
     * @return true if the graph is linked, otherwise false.
     */
    @Override
    public boolean isConnected() {
        int size = graph.getV().size();
        if (size == 0) return true;
        Collection<node_data> c = this.graph.getV();
        Iterator<node_data> i = this.graph.getV().iterator();
        BFS(i.next());
        Collection<node_data> c2 = this.graph.getV();
        Iterator<node_data> i2 = this.graph.getV().iterator();
        while (i2.hasNext()) {
            if (i2.next().getInfo().equalsIgnoreCase("white")) return false;
        }
        return true;
    }

    /**
     * Returns the length of the shortest path between src to dest,
     * if there is no correct path between them return -1.
     *
     * @param src - start node.
     * @param dest - end (target) node.
     * @return The length of the path.
     */
    @Override
    public int shortestPathDist(int src, int dest) {
        if (graph.getNode(src) == null || graph.getNode(dest) == null) return -1;
        BFS(graph.getNode(src));
                return graph.getNode(dest).getTag();
    }

    /**
     * returns the the shortest path between src to dest - as an ordered List of nodes:
     * src--> n1-->n2-->...dest.
     * If no such path exists return null.
     *
     *
     * @param src - start node.
     * @param dest - end (target) node.
     * @return The short path, if it does not exist will return null.
     */
    @Override
    public List<node_data> shortestPath(int src, int dest) {
        int n = shortestPathDist(src, dest);
        ArrayList<node_data> path = new ArrayList<node_data>();
        if (n == -1) return null;
        node_data newVer = graph.getNode(dest);
        Iterator<node_data> Ni = newVer.getNi().iterator();
        path.add(newVer);
        while (newVer.getTag() != 0) {
            while (Ni.hasNext()) {
                node_data temp = Ni.next();
                if (temp.getTag() + 1 == newVer.getTag()) {
                    newVer = temp;
                    break;
                }
            }
            Ni = newVer.getNi().iterator();
            path.add(newVer);
        }
        ArrayList<node_data> pathNew = new ArrayList<node_data>();
        int j = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            pathNew.add(j++, path.get(i));
        }
        return pathNew;
    }


}
