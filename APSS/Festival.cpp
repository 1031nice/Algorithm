#include <iostream>
#include <vector>
#include <iomanip>
 
/*
1.1.2 (6p)

test input
2
6 3
1 2 3 1 2 3
6 2
1 2 3 1 2 3

test output
1.7500000000
1.5009000000
*/

int main() {

	int numOfCase;
	int numOfDay;
	int numOfTeam;

	std::cin >> numOfCase;
	std::vector<float> answers(numOfCase);
	for (int i = 0; i < numOfCase; i++) {
		std::cin >> numOfDay;
		std::vector<int> costs(numOfDay);
		std::cin >> numOfTeam;
		for (int j = 0; j < numOfDay; j++) {
			std::cin >> costs[j];
		}
		float sum = 0.0f;
		float min = INT_MAX;
		for (int p = 0; p <= numOfDay - numOfTeam; p++) {
			for (int q = numOfTeam - 1 + p; q < numOfDay; q++) {
				for (int r = p; r <= q; r++) {
					sum += costs[r];
				}
				sum /= (q - p + 1);
				if (min > sum)
					min = sum;
				sum = 0.0f;
			}
		}
		answers[i] = min;
	}

	// print
	std::cout << std::fixed;
	std::cout.precision(10);
	for (int i = 0; i < numOfCase; i++)
		std::cout << answers[i] << std::endl;

	return 0;
}