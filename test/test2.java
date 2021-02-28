package ex0.test;
import ex0.*;

import java.util.List;

public class test2 {

    public static void main(String[] args){
        //*DO NOT run all three together*
        nodeDataTest();
        graph_DS_Test();
        graphAlgoTest();
        test4();
    }

    public static void nodeDataTest(){
        node_data n = new NodeData();
        node_data n2 = new NodeData();
        node_data n3 = new NodeData();
        node_data n10 = new NodeData();
        node_data empty = null;

        n.setInfo("1");
        n2.setInfo("2");
        n3.setInfo("3");
        n10.setInfo("10");

        n.addNi(n2);
        n2.addNi(n);
        n2.addNi(n);
        n.addNi(n3);
        n.addNi(n10);
        n.addNi(empty);

        System.out.print("Key n: "+n.getKey()+" | Data n: "+n.getInfo()+" | Neighbors: ");
        for(node_data x : n.getNi()){
            System.out.print(x.getKey()+", ");
        }
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Key n2: "+n2.getKey()+" | Data n2: "+n2.getInfo()+" | Tag: "+n2.getTag());
        System.out.println("Key n3: "+n3.getKey()+" | Data n3: "+n3.getInfo()+" | Tag: "+n2.getTag());
        System.out.println("Key n10: "+n10.getKey()+" | Data n10: "+n10.getInfo()+" | Tag: "+n2.getTag());

        System.out.print("n.removeNode(n3)"); n.removeNode(n3);
        System.out.print("Neighbors of n: ");
        for(node_data x : n.getNi()){
            System.out.print(x.getInfo()+" , ");
        }
        System.out.println();
        System.out.println("n.hasNi(n3): "+n.hasNi(n3.getKey()));
        System.out.println("n.hasNi(n2): "+n.hasNi(n2.getKey()));
    }

    public static void graph_DS_Test(){
        node_data n0 = new NodeData();
        node_data n1 = new NodeData();
        node_data n2 = new NodeData();
        node_data n3 = new NodeData();

        graph g1 = new Graph_DS();
        g1.addNode(n0);
        g1.addNode(n1);
        g1.addNode(n2);
        g1.addNode(n3);

        System.out.println("Has Edge: " + g1.hasEdge(n2.getKey(), n3.getKey()));
        g1.connect(n1.getKey(), n2.getKey());
        g1.connect(n2.getKey(), n3.getKey());

        System.out.println("Has Edge after connect: " + g1.hasEdge(n1.getKey(), n2.getKey()));
        System.out.println("edge size: " + g1.edgeSize());
        System.out.println("g1.getMC: "+ g1.getMC());
        System.out.println("getNode(n1).key: " + g1.getNode(n0.getKey()).getKey());

        System.out.println("------------Before remove Node and edges--------------");
        for (node_data x : g1.getV()) {
            System.out.print(x.getKey() + "| N: ");
            for (node_data j : x.getNi()) {
                System.out.print(j.getKey() + ", ");
            }
            System.out.println();
        }
        g1.removeNode(n0.getKey());
        g1.removeNode(n0.getKey());
        g1.removeEdge(1,2);
        g1.removeEdge(0,2);
        g1.removeEdge(3,3);
        System.out.println("------------After remove Node and edges--------------");

        for (node_data x : g1.getV()) {
            System.out.print(x.getKey() + "| N: ");
            for (node_data j : x.getNi()) {
                System.out.print(j.getKey() + ", ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("g1.getMC(): " + g1.getMC());
        System.out.println("g1.nodeSize(): "+g1.nodeSize());
    }

    public static void graphAlgoTest(){
        graph g1 = new Graph_DS();
        node_data n0 = new NodeData();
        node_data n1 = new NodeData();
        node_data n2 = new NodeData();
        node_data n3 = new NodeData();
        node_data n4 = new NodeData();
        node_data n5 = new NodeData();

        g1.addNode(n0);
        g1.addNode(n1);
        g1.addNode(n2);
        g1.addNode(n3);
        g1.addNode(n4);
        g1.addNode(n5);

        g1.connect(0, 1);
        g1.connect(0, 2);
        g1.connect(1, 2);
        g1.connect(2, 3);
        g1.connect(1, 3);
        g1.connect(4, 5);
        g1.connect(4, 3);

        graph_algorithms ga = new Graph_Algo();
        graph copy = ga.copy();

        System.out.println("------------Copy after changes-----------");
        copy.removeNode(2);
        copy.removeNode(2);

        copy.getNode(0).setTag(10);
        copy.getNode(3).setInfo("Black");

        for (node_data x : copy.getV()) {
            System.out.print("Key " + x.getKey() + " = Parent : " + x.getInfo() + ", Distance : " + x.getTag() + " , Neighbor: ");
            for (node_data y : x.getNi()) {
                System.out.print(y.getKey() + ", ");
            }
            System.out.println();
        }

        System.out.println("-----------Original--------------");
        for (node_data x : g1.getV()) {
            System.out.print("Key " + x.getKey() + " = Parent : " + x.getInfo() + ", Distance : " + x.getTag() + " , Neighbor: ");
            for (node_data y : x.getNi()) {
                System.out.print(y.getKey() + ", ");
            }
            System.out.println();
        }
        System.out.println("---------------Connected and Shortest path-----------------");

        graph_algorithms ga1 = new Graph_Algo();
        System.out.println("ga1.shortestPathDist(0,5) : "+ga1.shortestPathDist(0,5));
        System.out.println("ga1.shortestPathDist(0,0) : "+ga1.shortestPathDist(0,0));
        System.out.println("ga1.shortestPathDist(0,7) : "+ga1.shortestPathDist(0,7));
        System.out.println("ga1.shortestPathDist(20,4) : "+ga1.shortestPathDist(20,4));
        System.out.println("isConnected(): "+ga1.isConnected());
        List<node_data> result = ga1.shortestPath(0,5);
        System.out.print("The shortest path between 0 to 5: ");
        for(node_data x : result){
            System.out.print(x.getKey()+" -> ");
        }
        System.out.println();
        List<node_data> result4 = ga1.shortestPath(3,4);
        System.out.print("The shortest path between 3 to 4: ");
        for(node_data x : result4){
            System.out.print(x.getKey()+" -> ");
        }
        System.out.println();
        List<node_data> result2 = ga1.shortestPath(0,0);
        System.out.print("The shortest path between 0 to 0: ");
        for(node_data x : result2){
            System.out.print(x.getKey()+" -> ");
        }
        System.out.println();
        List<node_data> result3 = ga1.shortestPath(0,7);
        System.out.print("The shortest path between 0 to 7: ");
        if(result3 != null) {
            for (node_data x : result3) {
                System.out.print(x.getKey() + " -> ");
            }
        }else{
            System.out.println("There is no path");
        }
        List<node_data> result5 = ga1.shortestPath(10,2);
        System.out.print("The shortest path between 10 to 2: ");
        if(result3 != null) {
            for (node_data x : result5) {
                System.out.print(x.getKey() + " -> ");
            }
        }else{
            System.out.println("There is no path");
        }
    }

    public static void test4(){
        NodeData n0 = new NodeData();
        NodeData n1 = new NodeData();
        Graph_DS g = new Graph_DS();
        g.addNode(n0);
        g.addNode(n1);
        g.connect(n0.getKey(),n1.getKey());

        Graph_Algo ga = new Graph_Algo();
        System.out.println("ga.isConnected(): "+ga.isConnected());
        System.out.println("ga.shortestPath(0,1): "+ga.shortestPathDist(0,1));
        System.out.println("ga.shortestPath(0,1): "+ga.shortestPath(0,1));
    }
}

