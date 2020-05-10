#include <iostream>
#include <algorithm>
#define ROW 5
#define COL 5

using namespace std;

int func(int array[ROW][COL], int cache[ROW][COL], int, int);

int main() {

	int array[ROW][COL] = { {6,},
						    {1, 2,},
							{3, 7, 4,},
							{9, 4, 1, 7,},
							{100, 7, 5, 9, 4} };
		
	int cache[ROW][COL] = { {-1,-1,-1,-1,-1},
							{-1,-1,-1,-1,-1},
							{-1,-1,-1,-1,-1},
							{-1,-1,-1,-1,-1},
							{-1,-1,-1,-1,-1} };

	// �ִ� ã��
	int max = func(array, cache, 0, 0);

	cout << max << endl;

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			cout << cache[i][j] << " ";
		}
		cout << endl;
	}

	return 0;
}

int func(int array[ROW][COL], int cache[ROW][COL], int y, int x) {

	if (y >= ROW || x >= COL || x < 0 || y < 0 || x > y) // out of bounds
		return 0;

	else if (y == ROW - 1) { // ����
		cache[y][x] = array[y][x];
		return array[y][x];
	}

	else if (cache[y][x] != -1) // �̹� ���� ��
		return cache[y][x];

	int ret = max(array[y][x] + func(array, cache, y + 1, x), // �Ʒ�
			      array[y][x] + func(array, cache, y + 1, x + 1)); // �Ʒ� ������
	
	cache[y][x] = ret; // ó�� ���� ���̹Ƿ� ĳ�ÿ� ����
	return ret;
}

