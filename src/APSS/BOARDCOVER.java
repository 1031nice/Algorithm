package APSS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;

public class BOARDCOVER {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./src/APSS/input.txt"));
        ListIterator<String> iterator = lines.listIterator();
        int numOfTestCases = Integer.parseInt(iterator.next());
        int [] answers = new int[numOfTestCases];
        int row;
        int col;
        char [][] arr;

        for(int i=0; i<numOfTestCases; i++){
            row = Integer.parseInt(iterator.next());
            col = Integer.parseInt(iterator.next());
            arr = new char [row][col];
            int count = 0;

            for(int p=0; p<row; p++){
                String line;
                while(true){
                    line = iterator.next();
                    if(!line.isEmpty()) break;
                }
                for(int q=0; q<col; q++){
                    arr[p][q] = line.charAt(q);
                    if(arr[p][q] == '.') count++;
                }
            }

            if(count % 3 != 0)
                answers[i] = 0;
            else {
                answers[i] = func(arr, 0, count);
            }
        }

        for(int i=0; i<answers.length; i++)
            System.out.println(answers[i]);
    }

    private static int func(char[][] arr, int index, int count) {
        if(index >= arr.length * arr[0].length)
            return 0;
        else if(check(arr, index))
            return 0;
        else if(count == 0)
            return 1;
        else {
            int ret = 0;
            for(int i=index; i<arr.length * arr[0].length; i++) {
                if(arr[i / arr[0].length][i % arr[0].length] == '#')
                    continue;
                if (pick(arr, i, 1)) { // 1사분면 모양
                    ret += func(arr, i+1, count - 3);
                    unpick(arr, i, 1);
                }
                if (pick(arr, i, 2)) { // 2사분면 모양
                    ret += func(arr, i+1, count - 3);
                    unpick(arr, i, 2);
                }
                if (pick(arr, i, 3)) { // 3사분면 모양
                    ret += func(arr, i+1, count - 3);
                    unpick(arr, i, 3);
                }
                if (pick(arr, i, 4)) { // 4사분면 모양
                    ret += func(arr, i+1, count - 3);
                    unpick(arr, i, 4);
                }
            }
            return ret;
        }
    }

    private static boolean check(char[][] arr, int index) {
        int row = index / arr[0].length;
        int col = index % arr[0].length;
        if(row < 2)
            return false;
        else{
            for(int i=0; i<arr[0].length; i++){
                if(arr[row-2][i] == '.')
                    return true;
            }
            return false;
        }
    }

    private static void unpick(char[][] arr, int index, int dir) {
        int row = index / arr[0].length;
        int col = index % arr[0].length;
        switch (dir) {
            case 1:
                arr[row][col] = '.';
                arr[row - 1][col] = '.';
                arr[row][col + 1] = '.';
                break;
            case 2:
                arr[row][col] = '.';
                arr[row + 1][col] = '.';
                arr[row][col + 1] = '.';
                break;
            case 3:
                arr[row][col] = '.';
                arr[row + 1][col] = '.';
                arr[row][col - 1] = '.';
                break;
            case 4:
                arr[row][col] = '.';
                arr[row - 1][col] = '.';
                arr[row][col - 1] = '.';
                break;
        }
    }

    private static boolean pick(char[][] arr, int index, int dir) {
        int row = index / arr[0].length;
        int col = index % arr[0].length;
        switch (dir) {
            case 1:
                if (row - 1 < 0 || col + 1 >= arr[0].length || arr[row-1][col] == '#' || arr[row][col+1] == '#')
                    return false;
                else {
                    arr[row][col] = '#';
                    arr[row - 1][col] = '#';
                    arr[row][col + 1] = '#';
                    return true;
                }
            case 2:
                if (row + 1 >= arr.length || col + 1 >= arr[0].length || arr[row+1][col] == '#' || arr[row][col+1] == '#')
                    return false;
                else {
                    arr[row][col] = '#';
                    arr[row + 1][col] = '#';
                    arr[row][col + 1] = '#';
                    return true;
                }
            case 3:
                if (row + 1 >= arr.length || col - 1 < 0 || arr[row+1][col] == '#' || arr[row][col-1] == '#')
                    return false;
                else {
                    arr[row][col] = '#';
                    arr[row + 1][col] = '#';
                    arr[row][col - 1] = '#';
                    return true;
                }
            case 4:
                if (row - 1 < 0 || col - 1 < 0 || arr[row-1][col] == '#' || arr[row][col-1] == '#')
                    return false;
                else {
                    arr[row][col] = '#';
                    arr[row - 1][col] = '#';
                    arr[row][col - 1] = '#';
                    return true;
                }
            default:
                return false;
        }
    }

}
