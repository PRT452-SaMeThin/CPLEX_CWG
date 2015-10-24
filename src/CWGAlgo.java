import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class CWGAlgo {
	
	static int numVertices = CWGGlobal.numVertices;
	static int[][] X = CWGGlobal.X;

	public static void printFixList() {

		for (int i = 0; i < numVertices; i++) {
			for (int k = i + 1; k < numVertices; k++) {
				for (int j = 0; j < numVertices; j++) {
					if (i != j && j != k) {
						if (X[i][k] > X[i][j] + X[j][k]) {
							System.out.print(X[i][k] + "<=" + X[i][j] + "+" + X[j][k] + ": ");
							System.out.println("X[" + i + "][" + k +"] <= X[" + i + "][" + j + "] + X["
									+ j + "][" + k + "]");
						}
						
					}

				}
			}
		}
		System.out.println();
	}
	
	public static void solveCWG() {
		try {
			IloCplex cplex = new IloCplex();
			cplex.getNcols();
			cplex.getNrows();

			// Variables
			IloNumVar[][] x = new IloNumVar[numVertices][numVertices];

			for (int i = 0; i < numVertices; i++) {
				// x[i] = cplex.boolVarArray(i);
				x[i] = cplex.numVarArray(numVertices, 0, 1);
			}

			// Objectives
			IloLinearNumExpr objective = cplex.linearNumExpr();
			int y = 0;
			for (int i = 0; i < numVertices - 1; i++) {
				for (int j = i + 1; j < numVertices; j++) {

					// Check if the edge exists
					if (checkEdgeExist(i, j)) {
						y = 1;
					} else {
						y = -1;
					}
					objective.addTerm(y, x[i][j]);
				}
			}

			// Define objective
			cplex.addMinimize(objective);

			// Define constraints Xik <= Xij + Xjk
			for (int i = 0; i < numVertices; i++) {
				for (int k = i + 1; k < numVertices; k++) {
					for (int j = 0; j < numVertices; j++) {
						if (i != j && j != k) {
							cplex.addLe(x[i][k], cplex.sum(x[i][j], x[j][k]));
						}
					}
				}
			}

			// cplex.setParam(IloCplex.Param.Simplex.Display, 2);

			if (cplex.solve()) {
				System.out.println("Objective = " + cplex.getObjValue());
				System.out.println();
			} else {
				System.out.println("It cannot be solved");
			}

			cplex.end();

		} catch (IloException exc) {
			exc.printStackTrace();
		}
	}

	public static boolean checkEdgeExist(int i, int j) {
		if (X[i][j] == 1) {
			return false;
		} else {
			return true;
		}
	}
}
