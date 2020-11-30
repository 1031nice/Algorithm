package practice;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {

        // adj list initialization
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> node1 = new ArrayList<>();
        node1.add(2); node1.add(3); node1.add(4);
        List<Integer> node2 = new ArrayList<>();
        node2.add(2); node2.add(3); node2.add(4);
        List<Integer> node3 = new ArrayList<>();
        node3.add(0); node3.add(1);
        List<Integer> node4 = new ArrayList<>();
        node4.add(0); node4.add(1);
        List<Integer> node5 = new ArrayList<>();
        node5.add(0); node5.add(1);
        adjList.add(node1); adjList.add(node2); adjList.add(node3); adjList.add(node4); adjList.add(node5);
        int [] visited = new int [adjList.size()];
        // dfs all graph(연결되지 않은 그래프가 있을 수 있으므로)
        for(int i=0; i<adjList.size(); i++) {
//            if(visited[i] == 0)
//                dfsRecursivelyForAdjList(adjList, i, visited);
        }

        // adj matrix initialization
//        int [][] adjMatrix = {{0, 0, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}};
        int [][] adjMatrix = {{0,1,1,0,0,0,0},
                              {0,0,0,1,0,0,0},
                              {0,1,0,1,1,1,0},
                              {0,0,0,0,1,0,0},
                              {0,0,0,0,0,0,1},
                              {0,0,0,0,0,0,1},
                              {0,0,0,0,0,0,0},};
        int numOfNodes = adjMatrix.length;
        visited = new int [numOfNodes];
        dfsRecursivelyForAdjMatrix(adjMatrix, 0, visited);
    }

    private static void dfsRecursivelyForAdjMatrix(int[][] adjMatrix, int start, int[] visited) {
        System.out.print(start + " ");
        visited[start] = 1;
        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[start][i] != 0 && visited[i] == 0) {
                dfsRecursivelyForAdjMatrix(adjMatrix, i, visited);
            }
        }
    }

    static void dfsRecursivelyForAdjList(List<List<Integer>> adjList, int start, int [] visited) {
        List<Integer> startNode = adjList.get(start);
        System.out.print(start + " ");
        visited[start] = 1;
        for(int j=0; j<startNode.size(); j++) {
            int value = startNode.get(j);
            if (visited[value] == 0) {
                dfsRecursivelyForAdjList(adjList, value, visited);
            }
        }
    }


}
