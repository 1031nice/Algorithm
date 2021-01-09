package APSS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class FENCE {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./src/APSS/inputs/input_FENCE.txt"));
        Iterator<String> iterator = lines.iterator();
        int numOfTests = Integer.parseInt(iterator.next());
        for(int i=0; i<numOfTests; i++){
            int numOfBars = Integer.parseInt(iterator.next());
            int[] bars = new int[numOfBars];
            String [] stringBars = iterator.next().split(" ");
            for(int j=0; j<numOfBars; j++){
                bars[j] = Integer.parseInt(stringBars[j]);
            }
            // -----입력 끝-----

            // -----출력-----
            System.out.println(func(bars));
        }
    }

    private static int func(int[] bars) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<bars.length; i++){
            int left = i-1; int right = i+1;
            int currentBar = bars[i];
            int leftSum = 0; int rightSum = 0;

            // 기준 막대의 왼쪽 구간에서 기준 막대의 길이를 높이로 하는 직사각형의 합 구하기
            while(left >= 0){
                if(bars[left] >= currentBar) {
                    leftSum += currentBar;
                    left--;
                }
                else
                    break;
            }

            // 기준 막대의 오른쪽 구간에서 기준 막대의 길이를 높이로 하는 직사각형의 합 구하기
            while(right < bars.length){
                if(bars[right] >= currentBar) {
                    rightSum += currentBar;
                    right++;
                }
                else
                    break;
            }

            max = Math.max(max, leftSum + rightSum + currentBar);
        }
        return max;
    }

}
