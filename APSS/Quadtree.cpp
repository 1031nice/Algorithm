#include <iostream>
#include <string>

using namespace std;

string func(string);

int main() {
	string input = "w";
	cout << "input1: " << input << " [result]: " << func(input) << endl;
	string input2 = "xbwwb";
	cout << "input2: " << input2 << " [result]: " << func(input2) << endl;
	string input3 = "xbwxwbbwb";
	cout << "input3: " << input3 << " [result]: " << func(input3) << endl;
	string input4 = "xxwwwbxwxwbbbwwxxxwwbbbwwwwbb";
	cout << "input4: " << input4 << " [result]: " << func(input4) << endl;
	return 1;
}

string func(string str) {
	string arr[4] = { "", };
	int arr_i = 0;
	int count = str.size();
	for (int i = 0; i < count && arr_i < 4; i++) { // 문자열의 모든 문자를 검사
		if (str.at(i) == 'x') { // xbwwb
			string str2 = func(str.substr(i + 1));
			arr[arr_i] = str.at(i) + str2;
			i = i + str2.size();
		}
		else { // 'w', 'b'
			arr[arr_i] = str[i];
		}
		arr_i++;
	}
	string ret = arr[2] + arr[3] + arr[0] + arr[1]; // 3 4 1 2
	return ret;
}