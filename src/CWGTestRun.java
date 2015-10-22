import ilog.concert.*;
import ilog.cplex.*;

public class CWGTestRun {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMatrix();
		//tryIOData();
	}
	private static int numVertices = 5;
	private static int[][] X = new int[numVertices][numVertices];
	private static int Ncol = numVertices * (numVertices -1 ) / 2;
	
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
		
		for (int i=0; i< numVertices; i++) {
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
			//IloNumVar Xij = cplex.numVar(0, 1, "Xij");

			// Define constraint  0 <= Xij <= 1 
			for (int i = 1; i < Ncol + 1; i++) {
				IloNumVar Xij = cplex.numVar(0, 1, "Xij");;
			}
						
						
			// Expressions
			IloLinearNumExpr objective = cplex.linearNumExpr();
			objective.addTerm(1, Xij);
			objective.addTerm(-1, Xij);
			
			
			// Define objective
			cplex.addMinimize(objective);
			
			
			// Define constraints Xik <= Xij + Xjk
			for (int i = 0; i < numVertices; i++) {
				for (int k = i + 1; k < numVertices; k++) {
					for (int j = 0; j < numVertices; j++) {
						if (i != j && j != k) {
							objective.addTerm(1, Xij);
							//objective.addTerm(-1, Xjk);
						}
						
					}
				}
			}
			
			
			
		}
		catch (IloException exc) {
			exc.printStackTrace();
		}
	}
	
	
	
	
}
