
public class Transition {
	public static double[][] find(int N, int[][] counts, int[] outDegree) {
		double[][] result = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				double p = .90*counts[i][j]/outDegree[i] + .10/N;
				result[i][j] = p;
			}			
		}
		return result;
	}
}
