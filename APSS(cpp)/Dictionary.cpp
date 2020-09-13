#include <iostream>
#include <list>

using namespace std;


int main() {
	const int LENGTH_OF_ALPHABET = 26;
	char arr[LENGTH_OF_ALPHABET];
	for (int i = 0; i < LENGTH_OF_ALPHABET; i++) {
		arr[i] = 97+i;
	}



	return 1;
}

// 문자열을 검사할 함수
void check_str(char arr[], string str) {
	for (int i = 0; i < str.size(); i++) {
		if (isNewChar(arr, 26, str[i])) {
			
		}
	}
}

bool isNewChar(char arr[], int size, char ch) {
	for (int i = 0; i < size; i++) {
		if (arr[i] == ch || arr[i] - 32 == ch) // match !
			return false;
		else
			return true;
	}
}