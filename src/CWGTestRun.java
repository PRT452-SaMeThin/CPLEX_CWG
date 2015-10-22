import java.io.File;
import java.util.Scanner;

import ilog.concert.*;
import ilog.cplex.*;

public class CWGTestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialMatix();
		printInputMatrix();
		printMatrixList();
		model1();
	}

	//private static int Ncol = numVertices * (numVertices - 1) / 2;
	public static int[][] X;
	public static int numVertices;
	public static int numEdges;
	static String pathName = "/Users/Sancho/Desktop/test.txt";

	public static void printMatrixList() {

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
	}
	
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
				if (checkExist(i, j)) {
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
				if (checkExist(i, j)) {
					//y = 1;
				} else {
					//y = -1;
				}
				//System.out.println(y*X[i][j]);
			}
		}
	}
	
	// Initialize Matrix
	public static void initialMatix() {
		try {
			File fileName = new File(pathName);
			Scanner fileInput = new Scanner(fileName);
			//numVertices = 0;
			//numEdges = 0;
			numVertices = fileInput.nextInt();
			numEdges = fileInput.nextInt();
			X = new int[numVertices][numVertices];
			
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					X[i][j] = 1;
				}
				X[i][i] = 0;
			}
			
			for (int i = 0; i < numEdges; i++) {
				X[fileInput.nextInt()][fileInput.nextInt()] = 0;
			}
			for (int i = numVertices - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					X[i][j] = X[j][i];
				}
			}
			fileInput.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	// Function for input our data
	public static void printInputMatrix() {
		try {
			
			
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					System.out.print(X[i][j] + " ");
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Function for output data in file
	public static void printFileData(){
		try {
			File fileName = new File(pathName);
			Scanner fileInput = new Scanner(fileName);
			String aString = "";
			boolean Hola = true;
			while (fileInput.hasNext()) {
				
				if (Hola) {
					aString = aString + fileInput.next() + " ";
					Hola = false;
				}
				else {
					aString = aString + fileInput.next() + "\n";
					Hola = true;
				}
				
			}
			fileInput.close();
			
			System.out.println(aString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkExist(int i, int j) {
		if (X[i][j] == 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void model1() {
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
					if (checkExist(i, j)) {
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

}
