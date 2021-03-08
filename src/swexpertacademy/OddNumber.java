package swexpertacademy;

import java.util.Scanner;

public class OddNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int test=0; test<testCases; test++) {
            int sum = 0;
            for (int i=0; i<10; i++) {
                int input = scanner.nextInt();
                if(input % 2 == 0) continue;
                sum += input;
            }
            System.out.println("#" + (test+1) + " " + sum);
        }

    }

}
