
public class RandomSurfer {
	public static double[] surfAndGetRanks(double[][] transitionMatrix, int turns) {
		int page = 0;
		int[] freq = new int[transitionMatrix.length];
		for (int t = 0; t < turns; t++) {
			double sum = 0.0;
			for (int j = 0; j < transitionMatrix.length; j++) {
				sum += transitionMatrix[page][j];
				if (Math.random() < sum) {
					page = j;
					break;
				}
			}
			freq[page]++;
		}
		double[] result = new double[transitionMatrix.length]; 
		for (int i = 0; i < transitionMatrix.length; i++)
			result[i] = (double) freq[i] / turns;
		return result;
	}
}
