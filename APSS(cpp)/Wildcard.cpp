#include <iostream>
#include <vector>

using namespace std;

bool func(string, string);

int main() {
	
	int test_case;
	string expression;
	cout << "test case: "; cin >> test_case;

	for (int i = 0; i < test_case; i++) {
		vector<string> answer;
		cout << "*****test case " << i+1 << "*****" << endl; cout << "expression: ";
		cin >> expression;
		int num_input_string;
		cout << "number of input string: ";
		cin >> num_input_string;
		for (int i = 0; i < num_input_string; i++) {
			string input;
			cout << "input string " << i+1 << ": ";
			cin >> input;
			if(func(expression, input))
				answer.push_back(input);
		}
		cout << "******" << endl;
		for (int i = 0; i < answer.size(); i++) {
			cout << answer[i] << endl;
		}
	}

	return 0;
}

bool func(string expression, string input) {
	if (expression.size() == 0 && input.size() == 0)
		return true;
	else if (expression.size() == 0)
		return false;
	else if (input.size() == 0) {
		for (int i = 0; i < expression.size(); i++) {
			if (expression[i] != '*') // exp가 모두 '*'여야만 이 경우가 참일 수 있다
				return false;
		}
		return true;
	}
	else if (expression.size() == 1 && expression[0] == '*')
		return true;
	if (expression[0] == '?' || expression[0] == input[0])
		return func(expression.substr(1), input.substr(1));
	else { // '*' case '*' 다음에오는 문자(ex) a)가 중요
		if (expression[0] != '*')
			return false;
		if (expression.size() == 1)
			return false;
		for(int i=0; i < input.size(); i++) {
			if (input[i] == expression[1]) { // *p*, papa
				if (func(expression.substr(1), input.substr(i)))
					return true;
			}
		}
		return false;
	}
}