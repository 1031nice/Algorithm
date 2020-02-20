#include <iostream>
#include <queue>
#include <math.h>

/*
ID: ITES (635p)

test input
3
8791 20
5265 5000
3578452 5000000

test output
1
4
1049
*/

using namespace std;

int main() {

	queue<int> q;
	int N = 0;
	int K = 0;
	long long int A[5000];
	// make input
	for (int i = 0; i < 5000; i++) {
		if (i == 0)
			A[i] = 1983;
		else
			A[i] = (A[i - 1] * 214013 + 2531011) % (long long int)pow(2, 32);
	}
	int num_test = 0;
	cin >> num_test;

	/******************** start ********************/
	for(int i=0; i<num_test; i++){

		cin >> K;
		cin >> N;
		int count = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			int input = A[i] % 10000 + 1;
			q.push(input);
			sum += input;
			if (sum > K) { // q의 모든 합이 K보다 크면, K보다 같거나 작을 때까지 가장 오래된 원소부터 pop
				while (sum > K) {
					sum	-= q.front();
					q.pop();
				}
			}
			if (sum == K) { // q의 모든 합이 K와 같으면 count 증가하고 가장 오래된 원소 한 번만 pop
				count++;
				sum -= q.front();
				q.pop();
			}
		}

		// print
		cout << count << endl;

		// init q
		while(!q.empty())
			q.pop();

	}

	return 1;

}