package ex0.test;

import ex0.*;

import java.util.List;
public class tester {

        public static void main(String []args) {
            graph g = new Graph_DS();
            graph_algorithms ga = new Graph_Algo();
            ga.init(g);
            for (int i = 0; i < 10; i++) {
                NodeData n = new NodeData();
                n.setkey(i);
                g.addNode(n);
            }
            node_data nodes[] = g.getV().toArray(new node_data[0]);
            for (int j = 0; j < 8; j++) {
                g.connect(nodes[j].getKey(), nodes[j + 1].getKey());
            }
            System.out.println(ga.isConnected());
            System.out.println(ga.shortestPath(1,1));
           System.out.println(ga.shortestPath(1,1));
           System.out.println(ga.shortestPathDist(3,2));
            List<node_data> ls=ga.shortestPath(1,9);
            System.out.println(ls.size());
            for(int i=0; i<ls.size();i++)
                System.out.println(ls.get(i).getKey());
        }
    }

