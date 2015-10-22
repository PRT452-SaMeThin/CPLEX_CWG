import java.io.File;
import java.util.Scanner;

public class CWGIOData {
	
	public static void main() {

		printInputMatrix();
	}
	
	private static int numVertices;
	public static int getNumVertices() {
		return numVertices;
	}

	private static int numEdges;
	public static int[][] X;
	public static int[][] Y;
	


	public static void setX(int[][] x) {
		X = x;
	}

	static String pathName = "/Users/Sancho/Desktop/test1.txt";
	
	// Function for input our data
	public static void printInputMatrix() {
		try {
			File fileName = new File(pathName);
			Scanner fileInput = new Scanner(fileName);
			//numVertices = 0;
			//numEdges = 0;
			numVertices = fileInput.nextInt();
			numEdges = fileInput.nextInt();
			Y = new int[numVertices][numVertices];
			
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					Y[i][j] = 1;
				}
				Y[i][i] = 0;
			}
			
			for (int i = 0; i < numEdges; i++) {
				Y[fileInput.nextInt()][fileInput.nextInt()] = 0;
			}
			for (int i = numVertices - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					Y[i][j] = Y[j][i];
				}
			}
			
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					System.out.print(Y[i][j] + " ");
				}
				System.out.println();
			}
			
			//int[] elementValue = new int[numEdges*2];
			
			//for (int i = 0; i < numEdges*2; i++) {
			//	elementValue[i] = fileInput.nextInt();
			//}
			
			fileInput.close();
			//System.out.println(numVertices);
			//System.out.println(numEdges);
			
			//for (int j = 0; j < numEdges*2; j++) {
			//	System.out.println(elementValue[j]);
			//}
			X = Y;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Function for output our data
	public void outputData() {
		try {
			
			File fileName = new File(pathName);
			Scanner fileInput = new Scanner(fileName);
			String aString = "";
			while (fileInput.hasNext()) {
				aString += fileInput.next();
			}
			fileInput.close();
			
			System.out.println(aString);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void printData(){
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

	public static int[][] getX() {
		return X;
	}
}
