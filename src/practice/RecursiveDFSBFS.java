package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class RecursiveDFSBFS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int test = 0; test < testCases; test++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int [][] board = new int[row][col];
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solveWithRecursive(board, 0, 0));
            System.out.println(solveWithDFS(board, new Point(0, 0)));
            System.out.println(solveWithBFS(board, new Point(0, 0)));
        }
    }

    static class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static boolean solveWithBFS(int[][] board, Point start) {
        boolean flag = false;
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.col >= board[0].length || poll.row >= board.length)
                continue;
            else if(poll.col == board[0].length - 1 && poll.row == board.length - 1) {
                // 만약 하나 찾는 게 아니라 최솟값을 찾는 거라면
                // 밖에 최솟값 저장해둘 변수 하나 선언해두고 계속 그 변수와 비교한 뒤
                // 이대로 break 하는 것이 아니라 끝까지 진행하면 됨
                flag = true;
                break;
            }
            int jump = board[poll.row][poll.col];
            queue.add(new Point(poll.row + jump, poll.col));
            queue.add(new Point(poll.row, poll.col + jump));
        }
        return flag;
    }

    private static boolean solveWithDFS(int[][] board, Point start) {
        boolean flag = false;
        Stack<Point> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            Point pop = stack.pop();
            if (pop.col >= board[0].length || pop.row >= board.length)
                continue;
            else if(pop.col == board[0].length - 1 && pop.row == board.length - 1) {
                // 만약 하나 찾는 게 아니라 최솟값을 찾는 거라면
                // 밖에 최솟값 저장해둘 변수 하나 선언해두고 계속 그 변수와 비교한 뒤
                // 이대로 break 하는 것이 아니라 끝까지 진행하면 됨
                flag = true;
                break;
            }
            int jump = board[pop.row][pop.col];
            stack.push(new Point(pop.row + jump, pop.col));
            stack.push(new Point(pop.row, pop.col + jump));
        }
        return flag;
    }

    private static boolean solveWithRecursive(int[][] board, int row, int col) {
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0)
            return false;
        else if(row == board.length-1 && col == board[0].length-1)
            return true;
        return solveWithRecursive(board, row, col + board[row][col]) ||
                solveWithRecursive(board, row + board[row][col], col);
    }

}
