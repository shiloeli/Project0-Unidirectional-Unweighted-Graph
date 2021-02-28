package ex0;

import java.util.Collection;
import java.util.HashMap;


/**
 * This implementation graph
 * Which is literally different methods of operations on the graph (underectional unweighted) itself and on vertices in the graph
 * It should support a large number of nodes (over 10 ^ 6, with average degree of 10).
 *
 *   Node-Contains all vertices in the graph.
 *   edgeNum-Represents the number of edges in the graph.
 *   MC-Represents the number of changes made to the graph (adding a vertex and more ..).
 */

public class Graph_DS implements graph {

private HashMap<Integer, node_data> Node;
private int edgeNum;
private int MC;


    /**
     * A constructor that initializes the graph variables of the graph.
     */
    public Graph_DS(){
    this.Node=new HashMap<Integer, node_data>();
    this.edgeNum=0;
    this.MC=0;
}

    /**
     * Return the node_data by the node_id.
     *
     * @param key - the node_id.
     * @return the node_data by the node_id, null if none.
     */
    @Override
    public node_data getNode(int key) {
            return Node.get(key);
            }

    /**
     * Returns true if there is a edge between node 1 and node2
     * (ie if the node are neighbor to each other).
     *
     * @param node1 key of the first node.
     * @param node2 key of the second node.
     * @return true if there is a edge between them otherwise false.
     */
    @Override
    public boolean hasEdge(int node1, int node2) {
      return Node.get(node1).hasNi(node2);
    }

    /**
     * Add a new node to a graph with its given node_data and key.
     *
     * @param n node_data of node.
     */
    @Override
    public void addNode(node_data n) {
        if(Node.get(n.getKey())!=null) return;
        Node.put(n.getKey(), n);
        MC++;
    }

    /**
     * Connecting a edge between node1 and node 2 by their key
     * (if there is a edge between them nothing is done).
     *
     * @param node1 key of the first node.
     * @param node2 key of the second node.
     */
    @Override
    public void connect(int node1, int node2) {
        if(node1==node2) return;
        if(Node.get(node1)==null||Node.get(node2)==null) return;
        if(Node.get(node1).hasNi(node2)) return;
        Node.get(node1).addNi(Node.get(node2));
        Node.get(node2).addNi(Node.get(node1));
        edgeNum++;
        MC++;
    }

    /**
     * This method return a pointer (shallow copy) for the
     * collection representing all the nodes in the graph.
     *
     * @return Collection<node_data>.
     */
    @Override
    public Collection<node_data> getV() {
        return Node.values();
    }

    /**
     * This method return collection representing all the nodes connected to node_id.
     *
     * @param node_id key of a node that we return to its neighbors collection.
     * @return Collection<node_data>.
     */
    @Override
    public Collection<node_data> getV(int node_id) {
        return Node.get(node_id).getNi();
    }

    /**
     * Delete the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     *
     * @param key The ID of the given node.
     * @return the node_data of the deleted node.
     */
    @Override
    public node_data removeNode(int key) {
        if(Node.get(key)==null) return null;
        if(Node.get(key).getNi().size()!=0) {
            node_data []array=Node.get(key).getNi().toArray(new node_data[0]);
            for(int i=0; i< array.length; i++){
                array[i].removeNode(Node.get(key));
                edgeNum--;
            }
        }
        MC++;
        return Node.remove(key);
    }

    /**
     * Deletes the edge from the graph that connects the two given nodes.
     *
     * @param node1 key of the first node.
     * @param node2 key of the second node.
     */
    @Override
    public void removeEdge(int node1, int node2) {
        if(Node.get(node1)==null||Node.get(node2)==null)return;
        if(!Node.get(node1).hasNi(node2))return;
            Node.get(node1).removeNode(Node.get(node2));
            Node.get(node2).removeNode(Node.get(node1));
            MC++;
            edgeNum--;
        }

    /**
     *Return the number of vertices (nodes) in the graph.
     *
     * @return number of nodes.
     */
    @Override
    public int nodeSize() {
        return Node.size();
    }

    /**
     *Return the number of edges (undirectional graph).
     *
     * @return number of edges.
     */
    @Override
    public int edgeSize() {
        return edgeNum;
    }

    /**
     * Return the Mode Count - for testing changes in the graph.
     * Any change in the inner state of the graph should cause an increment in the ModeCount.
     *
     * @return Mode Count.
     */
    @Override
    public int getMC() {
        return MC;
  }
}