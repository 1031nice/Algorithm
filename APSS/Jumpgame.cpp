#include <iostream>

using namespace std;

bool func(int[7][7], int[7][7], int, int);

int main() {

	int arr[7][7] = { {2, 5, 1, 6, 1, 4, 1},
					  {6, 1, 1, 2, 2, 9, 3},
					  {7, 2, 3, 2, 1, 3, 1},
					  {1, 1, 3, 1, 7, 1, 2},
					  {4, 1, 2, 3, 4, 1, 3},
					  {3, 3, 1, 2, 3, 4, 1},
					  {1, 5, 2, 9, 4, 7, 0} };

	int mem[7][7];
	for (int i = 0; i < 7; i++) {
		for (int j = 0; j < 7; j++) {
			mem[i][j] = -1;
		}
	}

	if (func(mem, arr, 0, 0))
		cout << "경로가 있습니다" << endl;
	else
		cout << "경로가 없습니다" << endl;

	return 0;
}

bool func(int mem[7][7], int arr[7][7], int i, int j) {
	// out of range
	if (i >= 7 || j >= 7 || i < 0 || j < 0)
		return false;
	if (i == 6 && j == 6)
		return true;
	if (mem[i][j] == 0) // false
		return false;
	if(func(mem, arr, i+arr[i][j], j) || func(mem, arr, i, j + arr[i][j]))
		return true;
	mem[i][j] = 0;
	return false;

}











//bool func(int mem[7][7], int arr[7][7], int i, int j) {
//	if (i >= 7 || j >= 7 || i < 0 || j < 0)
//		return false;
//	if (mem[i][j] == 0)
//		return false;
//	if (i == 6 && j == 6)
//		return true;
//	if (func(mem, arr, i + arr[i][j], j) || func(mem, arr, i, j + arr[i][j]))
//		return true;
//	mem[i][j] = 0;
//	return false;
//}