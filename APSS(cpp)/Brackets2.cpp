#include <iostream>
#include <string>
#include <stack>

/*
633p ID: BRACKETS2

test input
3
()()
({[}])
({}[(){}])

test output
yes
no
yes

*/

using namespace std;

int main() {
	
	string open = "({[";
	string close = ")}]";
	string input;
	stack<char> stk;
	bool answer = true;
	int num_test = 0;
	cin >> num_test;

	for (int i = 0; i < num_test; i++) {
		cin >> input;
		for (int i = 0; i < input.size(); i++) {
			char ch = input.at(i);
			if (open.find(ch) < 3 && open.find(ch) >= 0) { // ���� ��ȣ
				stk.push(ch);
			}
			else { // �ݴ� ��ȣ
				if (stk.empty()) { // ���� ��ȣ�� ���ٸ� false
					answer = false;
					break;
				}
				else if (close.find(ch) == open.find(stk.top())) { // ���� ��ȣ�� ���� ������ ��� ����
					stk.pop();
					continue;
				}
				else { // ���� ��ȣ�� ���� ���� ������ false
					answer = false;
					break;
				}
			}
		}

		if (!stk.empty()) // ���� ��ȣ�� ���� ������ false
			answer = false;
		
		// print
		if (answer)
			cout << "YES" << endl;
		else
			cout << "NO" << endl;

		// init
		answer = true;
		while (!stk.empty())
			stk.pop();
	}

	return 1;

}