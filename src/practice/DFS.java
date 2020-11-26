package practice;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {


        // adj list initialization
        List<List<Integer>> adjList = new ArrayList<>();
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
        adjList.add(node1); adjList.add(node2); adjList.add(node3); adjList.add(node4); adjList.add(node5);
        int [] visited = new int [adjList.size()];
        // dfs all graph(연결되지 않은 그래프가 있을 수 있으므로)
        for(int i=0; i<adjList.size(); i++) {
            dfsForAdjList(adjList, 0, visited);
        }

        // adj matrix initialization
        int numOfNodes = 5;
        int [][] adjMatrix = {{0, 0, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}};
        visited = new int [numOfNodes];
        dfsForAdjMatrix(adjMatrix, 0, visited);
    }

    private static void dfsForAdjMatrix(int[][] adjMatrix, int start, int[] visited) {
        for(int i=0; i<adjMatrix.length; i++){
            if(visited[start] == 0) {
                System.out.print(start + 1 + " ");
                visited[start] = 1;
            }
            if(adjMatrix[start][i] != 0 && visited[i] == 0) {
                System.out.print(i + 1 + " ");
                visited[i] = 1;
                dfsForAdjMatrix(adjMatrix, i, visited);
            }
        }
    }

    static void dfsForAdjList(List<List<Integer>> adjList, int start, int [] visited) {
        List<Integer> startNode = adjList.get(start);
        for(int j=0; j<startNode.size(); j++) {
            int value = startNode.get(j);
            if (visited[value - 1] == 0) {
                System.out.print(value + " ");
                visited[value - 1] = 1;
                dfsForAdjList(adjList, value - 1, visited);
            }
        }
    }


}
