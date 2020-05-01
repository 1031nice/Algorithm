#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int func(vector<int>, int);

int main() { // 무식해서 못쓴다고 합니다.
	
	int num_case;
	cout << "테스트 케이스: ";
	cin >> num_case;
	for (int i = 0; i < num_case; i++) {
		int num_fence;
		cout << "울타리 수: ";
		cin >> num_fence;
		vector<int> arr(num_fence);
		cout << "울타리 높이: ";
		for (int i = 0; i < arr.size(); i++) {
			cin >> arr[i];
		}
		int max = func(arr, 0);
		cout << "최대 울타리 크기: " << max << endl;
	}
	return 0;
}

int func(vector<int> arr, int index) {
	if (index >= arr.size())
		return 0;
	int count = 1; // 자신과 크기가 같거나 큰 fence 개수
	for (int i = index-1; i >= 0; i--) {
		if (arr[i] >= arr[index]) count++;
		else break;
	}
	for (int i = index + 1; i < arr.size(); i++) {
		if (arr[i] >= arr[index]) count++;
		else break;
	}
	int ret = count * arr[index];
	return max(ret, func(arr, index + 1));
}