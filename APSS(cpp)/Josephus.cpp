#include <vector>
#include <iostream>

/*
620p
test input
2
6 3
40 3
test output
3 5
11 26
*/

int main() {
	
	int num_test;
	int num_soldier;
	int step;

	std::cin >> num_test;

	while (num_test) {
		std::cin >> num_soldier;
		std::vector<int> soldiers(num_soldier);
		// init vector
		for (int i = 0; i < num_soldier; i++) {
			soldiers[i] = i + 1;
		}
		std::cin >> step;
		std::cout << "step: " << step << std::endl;

		int ptr = 0; // point place where last people dead
		int kill_index = 0;

		// kill index 0 (always start index 0)
		soldiers.erase(soldiers.begin());
		ptr = kill_index - 1;
		while (soldiers.size() > 2) {
			kill_index = (ptr + step) % soldiers.size();
			if(kill_index == 0)
				soldiers.erase(soldiers.begin());
			else
				soldiers.erase(soldiers.begin() + kill_index);
			std::cout << std::endl;
			ptr = kill_index - 1;
		}

		// print answer
		for (int i = 0; i < soldiers.size(); i++)
			std::cout << soldiers[i] << " ";
		std::cout << std::endl;
	}
	return 1;
}