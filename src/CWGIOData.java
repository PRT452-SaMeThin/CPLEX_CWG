

import ilog.concert.*;
import ilog.cplex.*;
import java.io.*;
import java.util.Scanner;

public class CWGIOData {

	// Function for output data in file
	public String aString = "";
	public static void printFileData() {
		try {
			File fileName = new File(CWGGlobal.pathName);
			Scanner fileInput = new Scanner(fileName);
			
			boolean Hola = true;
			while (fileInput.hasNext()) {

				if (Hola) {
					aString = aString + fileInput.next() + " ";
					Hola = false;
				} else {
					aString = aString + fileInput.next() + "\n";
					Hola = true;
				}

			}
			fileInput.close();

			System.out.println(aString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Initialize Matrix
	public static void initialMatix() {
		try {
			File fileName = new File(CWGGlobal.pathName);
			Scanner fileInput = new Scanner(fileName);
			// numVertices = 0;
			// numEdges = 0;
			CWGGlobal.numVertices = fileInput.nextInt();
			CWGGlobal.numEdges = fileInput.nextInt();
			CWGGlobal.X = new int[CWGGlobal.numVertices][CWGGlobal.numVertices];

			for (int i = 0; i < CWGGlobal.numVertices; i++) {
				for (int j = 0; j < CWGGlobal.numVertices; j++) {
					CWGGlobal.X[i][j] = 1;
				}
				CWGGlobal.X[i][i] = 0;
			}

			for (int i = 0; i < CWGGlobal.numEdges; i++) {
				CWGGlobal.X[fileInput.nextInt()][fileInput.nextInt()] = 0;
			}
			for (int i = CWGGlobal.numVertices - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					CWGGlobal.X[i][j] = CWGGlobal.X[j][i];
				}
			}
			fileInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Function for input our data
	public static void printInputMatrix() {
		try {

			for (int i = 0; i < CWGGlobal.numVertices; i++) {
				for (int j = 0; j < CWGGlobal.numVertices; j++) {
					System.out.print(CWGGlobal.X[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
