## algorithm 문제풀이

#### 9/13
ID: PICNIC
<br>출처: 알고리즘문제해결전략
<br>전략: 완전탐색

#### 10/10
ID: E. Cycle Game
<br>ID: G. Hotspots
<br>ID: I. Project Teams
<br>출처: 2020 ICPC Preliminary

#### 10/13
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

#### 10/15
BOARDCOVER 문제를 10초도 아니고 바로 답이 나오도록 개선했다.
불필요하고 엄청나게 큰 반복이 있었다.