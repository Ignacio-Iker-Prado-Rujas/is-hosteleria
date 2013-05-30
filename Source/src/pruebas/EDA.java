package pruebas;

public class EDA {

	boolean isValid(int solution[], int k) {
		for (int i = 0; i < k; i++) {
			if (solution[i] == solution[k]
					|| abs(solution[k] - solution[i]) == k - i)
				return false;
		}
		return true;
	}

	boolean isSolution(int k, int n) {
		return k == (n - 1);
	}

	void printSolution(int solution[], int n){
	cout << "Solution: ";
	for(int i = 0; i < n; i++)
	cout << solution[i] << " ";
	cout << endl;
	}
;

	void nQueens(int solution[], int k, int n) {
		for (int i = 0; i < n; i++) {
			solution[k] = i;
			if (isValid(solution, k)) {
				if (isSolution(k, n)) {
					printSolution(k, n);

				} else {
					nQueens(solution, k + 1, n);
				}
			}
		}
	}

	void nQueens(int n){
	int solution[n];
	nQueens(solution, 0, n);
	}

	int main() {
		nQueens(8);
		return 0;
	}

}
