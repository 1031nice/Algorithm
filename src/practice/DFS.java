package practice;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {

        // initialization
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> node1 = new ArrayList<>();
        node1.add(1); node1.add(3); node1.add(4); node1.add(5);
        List<Integer> node2 = new ArrayList<>();
        node2.add(2); node2.add(3); node2.add(4); node2.add(5);
        List<Integer> node3 = new ArrayList<>();
        node3.add(3); node3.add(1); node3.add(2);
        List<Integer> node4 = new ArrayList<>();
        node4.add(4); node4.add(1); node4.add(2);
        List<Integer> node5 = new ArrayList<>();
        node5.add(5); node5.add(1); node5.add(2);
        graph.add(node1); graph.add(node2); graph.add(node3); graph.add(node4); graph.add(node5);

        int [] visited = new int [graph.size()];

        // 연결되지 않은 그래프가 있을 수 있으므로
        for(int i=0; i<graph.size(); i++) {
            dfs(graph, 0, visited);
        }

    }

    static void dfs(List<List<Integer>> graph, int start, int [] visited) {
        List<Integer> startNode = graph.get(start);
        for(int j=0; j<startNode.size(); j++) {
            int value = startNode.get(j);
            if (visited[value - 1] == 0) {
                System.out.print(value + " ");
                visited[value - 1] = 1;
                dfs(graph, value - 1, visited);
            }
        }
    }


}
