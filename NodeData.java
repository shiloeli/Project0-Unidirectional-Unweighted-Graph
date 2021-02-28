package ex0;

import java.util.Collection;
import java.util.HashMap;

/**
 * This implements node_data
 * that represent various actions that can be performed about node in graph,
 *
 * key-this is unique id of node in graph.
 * tag-Specifies the node distance from a particular point.
 * info-the node color that helps us give it a tag value.
 * Ni-stores all of node's neighbors.
 * keyNum-defines us a unique ID for each key.
 */

public class NodeData implements node_data {

    private int key;
    private int tag;
    private String info;
    private HashMap<Integer, node_data> Ni;
    private static int keyNum;


    /**
     * A default constructor that brings us initial values for a node
     */
    public NodeData() {
        this.key = keyNum++;
        this.Ni = new HashMap<Integer, node_data>();
        this.tag=0;
        this.info = "white";
    }

/**
 * Receives a key associated with this node.
 */
    public void setkey(int key) {
        this.key = key;
    }

    /**
     *  Return a key associated with this node,
     *
     * @return key-The unique identifier associated with the node.
     */
    @Override
    public int getKey() {
        return key;
    }

    /**
     *This method will return the collection of all neighbors of the node,
     *
     * @return The collection of neighbors.
     */
    @Override
    public Collection<node_data> getNi() {
        if (Ni != null)
        return Ni.values();
        Ni=new HashMap<Integer, node_data>();
        return Ni.values();
    }

    /**
     * This method will check if the node given by the key is a neighbor of the node,
     *
     * @param key The unique identifier associated with the node.
     * @return True if they are neighbors otherwise false.
     */
    @Override
    public boolean hasNi(int key) {
        if(Ni.get(key)==null) return false;
        return true;
    }

    /**
     * This method adds a given node to the list of neighbors of a particular node
     *
     * @param t The node_data of the node added to the collection.
     */
    @Override
    public void addNi(node_data t) {
        this.Ni.put(t.getKey(), t);
    }

    /**
     * This method deletes a given node from the list of neighboring nodes.
     *
     * @param node node_data.
     */
    @Override
    public void removeNode(node_data node) {
        Ni.remove(node.getKey());
    }

    /**
     *This method returns the feature associated with this node.
     *
     * @return info-attribute of the node.
     */
    @Override
    public String getInfo() {
        return info;
    }

    /**
     *The method changes the info value of the node.
     *
     * @param s This info-attribute of the node.
     */
    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    /**
     * The method returns the relative position of a node in graph.
     *
     * @return tag- a value representing the location of the node in the graph.
     */
    @Override
    public int getTag() {
        return tag;
    }

    /**
     * This method changes the tag value of the node.
     *
     * @param t - the new value of the tag.
     */
    @Override
    public void setTag(int t) {
        this.tag = t;
    }
}