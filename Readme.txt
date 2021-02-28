Ex0 Readme

This project deals with the construction of graphs starting from the creation of the nodes and ribs in the graph, continues with the creation of the graph itself (such as connecting the nodes in the graph and more) and basic algorithms related to the graph (paths in the parent link graph and more).
A graph is made up of three interfaces arranged according to the hierarchy from the creation of a node to the execution of an algorithm on the graph.


                                               ***Introduction:***
 --NodeData class:--
This implements node_data
 that represent various actions that can be performed about node in graph.

 --Geaph_DS class:--
  This implementation graph
 Which is literally different methods of operations on the graph (underectional unweighted) itself and on vertices in the graph
 It should support a large number of nodes (over 10 ^ 6, with average degree of 10).

 --Graph_Algo class:--
This class implement graph_algorithms and apply basics algorithms of graph theory.


                                         ***Functions implements:***
I will explain here about some key functions that I think require explanation:

  --NodeData class:--

data structures: HashMap-using the above data structure helps us to distinguish certain data by key.
And saves run times because values can be obtained from the data structures in O(1) and will affect run times of functions.

public NodeData()-a default constructor that brings us initial values for a node.

public void setkey(int key)-receives a key associated with this node.

  --Geaph_DS class:--

data structures: HashMap-using the above data structure helps us to distinguish certain data by key.
And saves run times because values can be obtained from the data structures in O(1) and will affect run times of functions.
Functions affected by this: hasEdge, addNode, connect, getV, getV(int node_id), removeNode, removeEdge.

public void connect(int node1, int node2)- Connecting a edge between node1 and node 2 by their key(if there is a edge between them nothing is done).

  --Graph_Algo class:--

data structures: Queue-Using the queue allows us to use the Last in First out method, and allows us to get the information we need in O (1).
                          Arraylist-So that we can return the objects in order from beginning to end.

public void BFS(node_data node)- Bfs algorithm,
Algorithm that receives a given node The algorithm marks each node in the graph in relation to its relative position, starting from the given node, the node enters the queue, then its neighbors enter the queue, after all its neighbors enter the queue it takes out the parent node, and marks its position in the graph and its info value Goes through each node once, and so on in the form of spreading on the graph.

public void init(graph g)- The method will point to the given graph.

public graph copy()-The function creates a copy of a given graph, it passes each node in the graph and creates a copy for it,
Then appropriate to each node the appropriate list of neighbors, these actions are done by deep copying.


public boolean isConnected()- The method checks whether the graph is linked and it marks all the nodes of the graph by calling the Bfs method,
After marking, it goes through all the nodes in the graph again and checks if there is an unmarked node, ie that it is not in the same
Tying component.
If there is such a node the graph is not a link and will return false instead of true.

public int shortestPathDist(int src, int dest)-The method receives key values of two node and calculates the distance between them as follows, it sends the start value (src) to the Bfs method which marks all the values of the nodes in the graph, the method returns the tag value of the dest, if there is a path between src and dest returns the path length The shortest otherwise you will return -1.

public List<node_data> shortestPath(int src, int dest)-The method returns the route nodes between src and dest if there is a normal route between them,
It sends the start and end value of the track to the method
public int shortestPathDist (int src, int dest)
It then goes over the shortest route route from the end to the beginning and adds the route junctions to the arraylist which it will return.


Author @Shilo Elimelech







