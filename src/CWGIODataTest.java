import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CWGIODataTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintFileData() {
					try{
					          String sourcePath= "/Users/Mrinalini/Desktop/Test1.txt";
					          FileReader file =new FileReader(sourcePath);
					          BufferedReader source = new BufferedReader(file);
					          String a,input="";
					          while((a=source.readLine())!=null){
					        					  input= input+a+'\n';
					        				     }
					          CWGIOData object2 = new CWGIOData();
					          object2.printFileData();
					          assertEquals(input,CWGIOData.aString);   
					    }catch(Exception e){
					           System.out.println("Error in testPrintFileData()");
					    }
	}

	@Test
	public void testInitialMatix() {
				try{
					     String sourcePath= "/Users/Mrinalini/Desktop/Test1.txt";
				             Scanner input = new Scanner(new File(sourcePath));
				             int vertices = input.nextInt();
				             int edges= input.nextInt();
				             int x[][]= new int[edges][edges];
				             for (int i = 0; i <edges; i++) {
				        					  x[input.nextInt()][input.nextInt()]=1; 
				        				     }
				              for (int p = vertices - 1; p >= 0; p--) {
				        		  for (int q = p - 1; q>= 0; q--) {
				        							 x[p][q] = x[q][p];
				        						 }
				        					 }
				              for(int m=0;m<vertices;m++){
				                	  for(int n =0;n<vertices;n++){
								                        if(x[m][n]==0)
								                        	 x[m][n]=1;
								                        else
								                        	 x[m][n]=0;
				                					 }
				               						x[m][m]=0;
				        				  }
				             CWGIOData object1 = new CWGIODatan();
				             object1.initialMatrix();
				             Assert.assertArrayEquals(input, CWGIOData.X);
				  }catch(Exception e){
				             System.out.println("Error in testInitialMatrix()")
			        	
		  }
}
