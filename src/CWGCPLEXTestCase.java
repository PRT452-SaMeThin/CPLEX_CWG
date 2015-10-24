import ilog.concert.*;
import ilog.cplex.*;

public class CWGCPLEXTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cplexTest();
	}
	
	public static void cplexTest() {
		try {
			IloCplex cplex = new IloCplex();
			
			// Variables
			IloNumVar x = cplex.numVar(0, Double.MAX_VALUE, "x");
			IloNumVar y = cplex.numVar(0, Double.MAX_VALUE, "y");
			
			// Expressions
			IloLinearNumExpr objective = cplex.linearNumExpr();
			objective.addTerm(0.12, x);
			objective.addTerm(0.15, y);
			
			// Define objective
			cplex.addMinimize(objective);
			
			// Define constraints
			cplex.addGe(cplex.sum(cplex.prod(60, x), cplex.prod(60, y)), 300);
			cplex.addGe(cplex.sum(cplex.prod(12, x), cplex.prod(6, y)), 36);
			cplex.addGe(cplex.sum(cplex.prod(10, x), cplex.prod(30, y)), 90);
			
			// Solve
			if (cplex.solve()) {
				System.out.println("Objective = " + cplex.getObjValue());
				System.out.println("x = " + cplex.getValue(x));
				System.out.println("y = " + cplex.getValue(y));
			}
			else {
				System.out.println("The model cannot be solved!");
			}
			cplex.end();
			
			
		}
		catch (IloException e) {
			e.printStackTrace();
		}
	}

}
