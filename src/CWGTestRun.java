// This Class is just for testing purpose. Please ignore it.

public class CWGTestRun {
	
	static int numVertices = CWGGlobal.numEdges;
	static int X[][] = CWGGlobal.X;
	
public static void countNum() {

		for (int i = 0; i < numVertices; i++) {
			for (int k = i + 1; k < numVertices; k++) {
				for (int j = 0; j < numVertices; j++) {
					if (i != j && j != k) {
						if (X[i][k] > X[i][j] + X[j][k]) {
							
						}
						
					}

				}
			}
		}
	}
	
	
	public static void printEdges() {
		for (int i = 0; i < numVertices - 1; i++) {
			for (int j = i + 1; j < numVertices; j++) {
				System.out.println("X[" + i + "][" + j + "]: " + X[i][j] + " ");
				// Check if the edge exists
				if (CWGAlgo.checkEdgeExist(i, j)) {
					//y = 1;
				} else {
					//y = -1;
				}
				//System.out.println(y*X[i][j]);
			}
		}
	}
	
	public static void printObj() {
		for (int i = 0; i < numVertices - 1; i++) {
			for (int j = i + 1; j < numVertices; j++) {
				System.out.println("X[" + i + "][" + j + "]: " + X[i][j] + " ");
				// Check if the edge exists
				if (CWGAlgo.checkEdgeExist(i, j)) {
					//y = 1;
				} else {
					//y = -1;
				}
				//System.out.println(y*X[i][j]);
			}
		}
	}

}
