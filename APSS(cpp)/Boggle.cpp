#include <iostream>
#include <string>

char table[5][5] = {'U', 'R', 'L', 'P', 'M',
					'X', 'P', 'R', 'E', 'T', 
					'G', 'I', 'A', 'E', 'T', 
					'X', 'T', 'N', 'Z', 'Y', 
					'X', 'O', 'Q', 'R', 'S', };

int x_direction[8] = { -1, -1, 0, 1, 1, 1, 0, -1 };
int y_direction[8] = { 0, 1, 1, 1, 0, -1, -1, -1 };

bool hasWord(int x, int y, std::string word) {
	// base case
	if (x >= 5 || y >= 5 || x < 0 || y < 0)
		return false;
	if (word.size() == 0)
		return true;
	if (table[x][y] == word.at(0)) {
		std::cout << "[debug] " << table[x][y] << std::endl;
		for (int i = 0; i < 8; i++) {
			std::cout << "[debug] " << word.substr(1, word.size()) << std::endl;
			if (hasWord(x + x_direction[i], y + y_direction[i], word.substr(1, word.size())))
				return true;
		}
	}
	return false;
}

int main() {
	std::string returnV = hasWord(1, 2, "RLP") ? "true" : "false";
	std::cout << returnV;
	return 0;
}