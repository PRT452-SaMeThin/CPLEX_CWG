import java.io.File;
import java.util.Scanner;

public class CWGIOData {
	
	private int numVertices;
	private int numEdges;
	
	// Function for input our data
	public void inputData() {
		try {
			String pathName = "/Users/Sancho/Desktop/test.txt";
			File fileName = new File(pathName);
			Scanner fileInput = new Scanner(fileName);
			//numVertices = 0;
			//numEdges = 0;
			numVertices = fileInput.nextInt();
			numEdges = fileInput.nextInt();
			
			int[] elementValue = new int[numEdges*2];
			
			for (int i = 0; i < numEdges*2; i++) {
				elementValue[i] = fileInput.nextInt();
			}
			
			fileInput.close();
			System.out.println(numVertices);
			System.out.println(numEdges);
			
			for (int j = 0; j < numEdges*2; j++) {
				System.out.println(elementValue[j]);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Function for output our data
	public void outputData() {
		try {
			String pathName = "/Users/Sancho/Desktop/test.txt";
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

}
