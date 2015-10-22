import ilog.concert.*;
import ilog.cplex.*;

public class CWGTestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printMatrix();
		// tryIOData();
		model1();
	}

	private static int numVertices = 5;
	private static int[][] X = new int[numVertices][numVertices];
	private static int Ncol = numVertices * (numVertices - 1) / 2;

	// Set constraint 0 <= Xij <= 1
	public void setConstraint() {
		for (int i = 1; i < Ncol + 1; i++) {

		}
	}

	public static void tryIOData() {
		CWGIOData example1 = new CWGIOData();
		example1.inputData();
	}

	// Print Matrix
	public static void printMatrix() {

		X[1][2] = 1;
		X[1][4] = 1;
		X[0][4] = 1;
		X[2][1] = 1;
		X[2][4] = 1;
		X[4][0] = 1;
		X[4][1] = 1;
		X[4][2] = 1;

		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				System.out.print(X[i][j] + " ");
			}
			System.out.println();
		}
	}

	// CPLEX implement
	public static void model1() {
		try {
			IloCplex cplex = new IloCplex();

			// Variables
			IloNumVar[][] x = new IloNumVar[numVertices][numVertices];
			for (int i = 0; i < numVertices; i++) {
				x[i] = cplex.boolVarArray(i);
				x[i] = cplex.numVarArray(numVertices, 0, 1);
			}

			// Objectives
			IloLinearNumExpr objective = cplex.linearNumExpr();
			for (int i1 = 0; i1 < numVertices - 1; i1++) {
				for (int j = i1 + 1; j < numVertices; j++) {
					
					int y = -1;

					// Check if the edge exists
					if (checkExist(i1, j)) {
						y = 1;
					} else {
						y = -1;
					}
					objective.addTerm(y, x[i1][j]);
				}
			}

			// Define objective
			cplex.addMinimize(objective);

			// Define constraints Xik <= Xij + Xjk
			for (int i1 = 0; i1 < numVertices; i1++) {
				for (int k = i1 + 1; k < numVertices; k++) {
					for (int j = 0; j < numVertices; j++) {
						if (i1 != j && j != k) {
							cplex.addLe(x[i1][k], cplex.sum(x[i1][j], x[j][k]));
						}

					}
				}
			}

			if (cplex.solve()) {
				System.out.println("Objective = " + cplex.getObjValue());
			} else {
				System.out.println("It cannot be solved");
			}

		} catch (IloException exc) {
			exc.printStackTrace();
		}
	}

	public static boolean checkExist(int i, int j) {
		if (X[i][j] == 1) {
			return true;
		} else {
			return false;
		}
	}

}
