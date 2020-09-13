#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int func(vector<int>, int);

int main() { // �����ؼ� �����ٰ� �մϴ�.
	
	int num_case;
	cout << "�׽�Ʈ ���̽�: ";
	cin >> num_case;
	for (int i = 0; i < num_case; i++) {
		int num_fence;
		cout << "��Ÿ�� ��: ";
		cin >> num_fence;
		vector<int> arr(num_fence);
		cout << "��Ÿ�� ����: ";
		for (int i = 0; i < arr.size(); i++) {
			cin >> arr[i];
		}
		int max = func(arr, 0);
		cout << "�ִ� ��Ÿ�� ũ��: " << max << endl;
	}
	return 0;
}

int func(vector<int> arr, int index) {
	if (index >= arr.size())
		return 0;
	int count = 1; // �ڽŰ� ũ�Ⱑ ���ų� ū fence ����
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