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
			if (open.find(ch) < 3 && open.find(ch) >= 0) { // 여는 괄호
				stk.push(ch);
			}
			else { // 닫는 괄호
				if (stk.empty()) { // 여는 괄호가 없다면 false
					answer = false;
					break;
				}
				else if (close.find(ch) == open.find(stk.top())) { // 여는 괄호와 쌍이 맞으면 계속 진행
					stk.pop();
					continue;
				}
				else { // 여는 괄호와 쌍이 맞지 않으면 false
					answer = false;
					break;
				}
			}
		}

		if (!stk.empty()) // 여는 괄호가 남아 있으면 false
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