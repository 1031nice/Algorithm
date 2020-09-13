import java.util.Scanner;

public class PICNIC {

    public static void main(String[] args) {
        int numOfTestCases = 0;
        int numOfStudents = 0;
        int numOfPairs = 0;

        // 입력
        Scanner scanner = new Scanner(System.in);
        numOfTestCases = scanner.nextInt();
        int[] answers = new int[numOfTestCases];
        for(int i=0; i<numOfTestCases; i++) {
            numOfStudents = scanner.nextInt();
            numOfPairs = scanner.nextInt();
            int friends[][] = new int[numOfPairs][2];
            boolean hasFriend[] = new boolean[numOfStudents]; // 짝이 맺어졌으면 true
            for(int row=0; row<numOfPairs; row++){
                for(int col=0; col<2; col++){
                    friends[row][col] = scanner.nextInt();
                }
            }
            answers[i] = count(friends, hasFriend, numOfPairs, 0);
        }

        // 출력
        for(int i=0; i<answers.length; i++){
            System.out.println(answers[i]);
        }
    }

    public static int count(int[][] friends, boolean[] hasFriend, int numOfPairs, int index){
        int ret = 0;
        // 모두 짝을 가진 경우
        if(isAllFriend(hasFriend))
            return 1;
        else{
            for(int i=index; i<numOfPairs; i++) {
                // 해당 인덱스의 짝을 고를 수 있는 경우
                if (take(friends, hasFriend, i)) {
                    ret += count(friends, hasFriend, numOfPairs, i+1);
                    untake(friends, hasFriend, i);

                }
                // 친구가 겹쳐서 해당 인덱스의 짝을 못 고르는 경우
                else {
                    continue;
                }
            }
        }
        return ret;
    }

    private static void untake(int[][] friends, boolean[] hasFriend, int index) {
        hasFriend[friends[index][0]] = false;
        hasFriend[friends[index][1]] = false;
    }

    private static boolean take(int[][] friends, boolean[] hasFriend, int index) {
        if(hasFriend[friends[index][0]] || hasFriend[friends[index][1]])
            return false;
        else{
            hasFriend[friends[index][0]] = true;
            hasFriend[friends[index][1]] = true;
            return true;
        }
    }

    public static boolean isAllFriend(boolean[] hasFriend) {
        for(int i=0; i<hasFriend.length; i++){
            if(!hasFriend[i])
                return false;
        }
        return true;
    }

}
