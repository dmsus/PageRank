public class PageRank {
	public static void main(String[] args) {
		In input = new In(args[0]);
		int N = input.readInt();
		int stepCount = input.readInt();
		int[][] counts = new int[N][N];
		int[] outDegree = new int[N];
		while (!input.isEmpty()) {
			int i = input.readInt();
			int j = input.readInt();
			outDegree[i]++;
			counts[i][j]++;
		}
		double[][] transitionMatrix = Transition.find(N, counts, outDegree);
		double[] ranks = RandomSurfer.surfAndGetRanks(transitionMatrix, stepCount);
		visualize(ranks);
	}
	
	private static void visualize(double[] ranks) {
		StdDraw.setXscale(-1, ranks.length);
		StdDraw.setYscale(0, 1);
		StdDraw.setPenRadius(.5/ranks.length);
		for (int k = 0; k < ranks.length; k++)
			StdDraw.line(k, 0, k, ranks[k]);
	}
}
