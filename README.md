## algorithm 문제풀이

#### 2020.9.13
ID: PICNIC
<br>출처: 알고리즘문제해결전략
<br>전략: 완전탐색

#### 2020.10.10
ID: E. Cycle Game
<br>ID: G. Hotspots
<br>ID: I. Project Teams
<br>출처: 2020 ICPC Preliminary

#### 2020.10.13
ID: BOARDCOVER
<br>출처: 알고리즘문제해결전략
<br>전략: 완전탐색
<br>기록: 일단 성능을 신경쓰지 않고
동작하는 완전탐색 알고리즘을 만들었다.
하지만 입력이 큰 하나의 테스트 케이스에 대해서
15분이 지나도 답을 내지 못했다.
무의미한 재귀를 막도록 간단한 코드를 추가하여
개선한 결과 같은 입력에 대해 10초만에 답을 냈다.

이 문제의 경우 테스트 입력을 일일이 손으로 입력하기 번거로워서
처음으로 Scanner 대신 파일 입출력을 이용하였는데
매우 편리했다. 종종 써먹어야겠다.

#### 2020.10.15
BOARDCOVER 문제를 10초도 아니고 바로 답이 나오도록 개선했다.
불필요하고 엄청나게 큰 반복이 있었다.

#### 2020.11.14
ID: TRAVERSAL
<br>출처: 알고리즘문제해결전략
<br>전략: 트리순회
<br>기록: 트리라는 자료구조 자체가 재귀적임을 기억하자.

#### 2020.11.15
ID: NERD2
<br>출처: 알고리즘문제해결전략
<br>전략: 트리
<br>기록: 입력마다 계산을 해야하는 문제다. 새로운 입력이 들어올 때마다
기존의 입력과 비교해야 한다. 가장 먼저 새로운 입력과 기존의 모든 입력을 비교해볼까 했지만
시간복잡도가 `O(n^2)`라서 시간 안에 풀 수 없을 것 같았다. 그래서 기존의 모든 입력과
비교해야 하는지 생각해보았다.

대회에 참여할 수 없는 사람은 두 가지 값이 모두 다른 어떤 사람보다
적은 사람이다. 즉, A와 B가 있을 때 A의 두 가지 값이 B의 두 가지 값보다 작다면 A는
대회에 참여할 수 없다. 그럼 새로운 사람 C가 들어왔을 때 C는 A, B 둘 모두와 비교해야할까?
A와의 비교는 의미가 없다. A와 비교했을 때 둘 중 하나의 값이 A 보다 크다고 하더라도
B보다 작은 경우 무의미하기 때문이다. 따라서 새로운 입력은 B와 비교하면 된다.
(대회에 참여할 수 없는 사람은 반드시 다른 사람에 의해 가려짐을 알 수 있다.)

이를 어떤 자료구조로 표현할 수 있을까 생각해보았다. 처음엔 배열을 떠올렸다.
각각의 인덱스가 참가자를 가리키게 하고, 배열의 값이 그 참가자를 가리고 있는 참가자를 가리키게 하면
될 것 같았다. 하지만 배열을 사용할 경우 어떤 참가자가 참가할 수 있는지를 바로 구분할 수 없기 때문에
최악의 경우 매번 배열의 길이 만큼을 돌면서 어떤 참가자가 참가할 수 있는지 검사해야 해서 느릴 것 같았다.
그래서 트리를 떠올렸다.

노드(참가자)는 자식 노드와 두 가지 값을 갖게 한 다음, 루트 노드만을 담아둘 Set을 만들었다.
Set을 돌면서 루트 노드와 입력 노드를 비교하여 루트 노드가 더 크다면 입력 노드를
자식 노드 중 하나로 만들고, 입력 노드가 더 크다면 입력 노드를 루트 노드의 부모로 만들고,
그렇지 않은 경우 입력 노드를 새로운 루트 노드로 만들어 Set에 추가하도록 구현하였다.

다음엔 더 간결하게 핵심 아이디어만 써보자.  

#### 2020.11.20
ID: EDITORWARS
<br>출처: 알고리즘문제해결전략
<br>전략: 트리
<br>기록: Disjoint set 문제. Set의 크기를 최대로 하는 것이 목표이므로
set의 종류는 두 개 밖에 없었지만, 어떤 set에도 속할 수 있는 두 개의 input이 주어진 경우
새로운 set을 추가하였다. 어떻게 추가하느냐에 따라서 끝에 가서 합치면 되기 때문이다.
(기존의 set에 input을 추가할 경우 input마다 두 개의 경우가 가능하고, 따라서 약
2^input 개의 경우가 생기는데 모두 따져보려면 재귀함수로 풀어야 할 것 같다.)

예를 들어 set A에 a1,a2,a3가 있고 set B에 b1, b2, b3가 있을 때 새로운 인풋으로 x, y가 들어오면 x와 y를
A 또는 B에 넣는 것이 아니라 새로운 set C(경우에 따라 set D까지)를 만들었다.
이때 C는 A에도 더해질 수 있고, B에 더해져도 상관없다. 목표는 최댓값이므로
A와 B중 더 큰 값에 C를 더하면 된다. 최종적으로 A-B, C-D, E-F, G-H, ... 이런 식의 set이 만들어졌을 경우
짝지어진 것중 인원이 가장 많은 것만 골라 더하면 최댓값을 구할 수 있다.

#### 2021.1.3
ID: FESTIVAL(6p)
<br>출처: 알고리즘문제해결전략
<br>전략: 완전탐색, 구간합
<br>기록: 구간합을 구할 때 단순하게 생각하면 세 개의 반복문이 필요하다.

* 구간의 시작지점을 나타내는 반복문(시작지점이 계속 움직이므로)
* 구간의 끝지점을 나타내는 반복문(끝지점이 계속 움직이므로)
* 정해진 구간을 순회할 반복문

이 문제도 세 개의 반복문이 필요할 것 같지만 시작지점을 나타내는 반복문과
끝지점을 나타내는 동시에 구간을 순회하는 하는 반복문, 총 두 개의 반복문으로 문제를 해결했다.
끝지점이 한 칸씩 이동할 때마다 이전 구간을 매번 중복 계산할 필요 없이
이동된 끝지점만 더해주면 되기 때문에 반복문 세 개를 쓸 때보다 훨씬 빠를 것 같다.

구간의 끝지점만 더해나가더라도 어쨌든 처음 한 번은 구간을 처음부터 순회하면서 합을 구해두어야 하는데
이 경우 두 번째 반복문을 시작지점부터 끝지점까지 순회하게 만든 뒤 경우에 따라 조건문을 추가해주면 된다.
구간의 길이가 최소 3이어야 한다면 두 번째 반복문이 세 번 실행됐을 때부터 무언가를 하도록 해주면 된다.

#### 2021.1.4
ID: BOGGLE(150p)
<br>출처: 알고리즘문제해결전략
<br>전략: 완전탐색
<br>기록: 8개의 방향을 배열로 나타내는 테크닉을 기억해두자. 또, 이런 유형의 재귀함수를 구현할 때
인덱스 검사의 순서와 정답 검사 위치에 따라 불필요한 반복이 더 생길 수도,
운이 더 나쁘면 답이 틀리는 경우가 발생할 수도 있다는 점을 조심하자.

#### 2021.1.6
BOARDCOVER 알고리즘 개선
* 도형을 채울 때 방향의 표현을 `switch`문(코드)에서 배열(데이터)로 변경
```java
// before
private static boolean pick(char[][] arr, int index, int type) {
    int row = index / arr[0].length;
    int col = index % arr[0].length;
    switch (type) {
        case 1:
            if (row - 1 < 0 || col + 1 >= arr[0].length || arr[row][col] == '#' || arr[row-1][col] == '#' || arr[row][col+1] == '#')
                return false;
            else {
                arr[row][col] = '#';
                arr[row - 1][col] = '#';
                arr[row][col + 1] = '#';
                return true;
            }
        case 2:
            if (row + 1 >= arr.length || col + 1 >= arr[0].length || arr[row][col] == '#' || arr[row+1][col] == '#' || arr[row][col+1] == '#')
                return false;
            else {
                arr[row][col] = '#';
                arr[row + 1][col] = '#';
                arr[row][col + 1] = '#';
                return true;
            }
        case 3:
            if (row + 1 >= arr.length || col - 1 < 0 || arr[row][col] == '#' || arr[row+1][col] == '#' || arr[row][col-1] == '#')
                return false;
            else {
                arr[row][col] = '#';
                arr[row + 1][col] = '#';
                arr[row][col - 1] = '#';
                return true;
            }
        case 4:
            if (row - 1 < 0 || col - 1 < 0 || arr[row][col] == '#' || arr[row-1][col] == '#' || arr[row][col-1] == '#')
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

private static void unpick(char[][] arr, int index, int type) {
    int row = index / arr[0].length;
    int col = index % arr[0].length;
    switch (type) {
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

// after
public static int[][][] coverType = {
    {{0, 0}, {-1, 0}, {0, 1}},
    {{0, 0}, {1, 0}, {0, 1}},
    {{0, 0}, {1, 0}, {0, -1}},
    {{0, 0}, {-1, 0}, {0, -1}}
};

private static boolean pick(char[][] arr, int index, int type) {
    int row = index / arr[0].length;
    int col = index % arr[0].length;
    for(int i=0; i<3; i++) {
        int newRow = row + coverType[type - 1][i][0];
        int newCol = col + coverType[type - 1][i][1];
        if(newRow >= arr.length || newRow < 0 || newCol >= arr[0].length || newCol < 0)
            return false;
        if(arr[newRow][newCol] == '#')
            return false;
    }
    for(int i=0; i<3; i++){
        arr[row + coverType[type-1][i][0]][col + coverType[type-1][i][1]] = '#';
    }
    return true;
}

private static void unpick(char[][] arr, int index, int type) {
    int row = index / arr[0].length;
    int col = index % arr[0].length;
    for(int i=0; i<3; i++){
        arr[row + coverType[type-1][i][0]][col + coverType[type-1][i][1]] = '.';
    }
}
```

* pick()과 unpick()을 set()이라는 하나의 함수로 통합
<br>장점: 두 함수의 차이점을 매개변수로 빼낸 뒤 하나의 함수로 합쳤다.
두 함수의 코드가 비슷하여 중복되는 부분이 많았기 때문에 억지스러움 없이 합칠 수 있었고,
합침으로써 많은 코드의 중복을 제거하였다.
<br><br>단점: 하지만 덜 명시적인 코드가 되었다고 생각한다. pick과 unpick은 이름만 보고도
무엇을 하는지 알 수 있는데, set은 매개변수로 무엇을 주는지를 확인해야 어떤 일을 하는지
알 수 있기 때문이다. 또한 unpick은 pick이 호출되었을 때만 호출되는 함수이므로
pick과 unpick이 분리되어있을 때는 조건의 검사를 pick에서만 해주면 unpick에서는
조건 검사를 해줄 필요가 없었는데(unpick은 반드시 pick이 호출되어야만 호출되므로
pick에서 이미 조건 검사를 해주었기 때문), 두 함수를 합치다보니 unpick 과정에서도 조건 검사가 들어가게 되었다.
즉, unpick마다 매번 불필요한 조건 검사가 진행된다.    
```java
// before
private static boolean pick(char[][] arr, int index, int type) {
    int row = index / arr[0].length;
    int col = index % arr[0].length;
    for(int i=0; i<3; i++) {
        int newRow = row + coverType[type - 1][i][0];
        int newCol = col + coverType[type - 1][i][1];
        if(newRow >= arr.length || newRow < 0 || newCol >= arr[0].length || newCol < 0)
            return false;
        if(arr[newRow][newCol] == '#')
            return false;
    }
    for(int i=0; i<3; i++){
        arr[row + coverType[type-1][i][0]][col + coverType[type-1][i][1]] = '#';
    }
    return true;
}

private static void unpick(char[][] arr, int index, int type) {
    int row = index / arr[0].length;
    int col = index % arr[0].length;
    for(int i=0; i<3; i++){
        arr[row + coverType[type-1][i][0]][col + coverType[type-1][i][1]] = '.';
    }
}

// after
private static boolean set(char[][] arr, int index, int type, char delta) {
    int row = index / arr[0].length;
    int col = index % arr[0].length;
    for(int i=0; i<3; i++) {
        int newRow = row + coverType[type - 1][i][0];
        int newCol = col + coverType[type - 1][i][1];
        if(newRow >= arr.length || newRow < 0 || newCol >= arr[0].length || newCol < 0)
            return false;
        if(arr[newRow][newCol] == delta)
            return false;
    }
    for(int i=0; i<3; i++){
        arr[row + coverType[type-1][i][0]][col + coverType[type-1][i][1]] = delta;
    }
    return true;
}
```