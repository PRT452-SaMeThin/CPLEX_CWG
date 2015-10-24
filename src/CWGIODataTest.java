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
					            String a="4 4\n0 1\n0 2\n1 2\n2 3\n"; // this values tends to change according to the input
					            CWGIOData object2 = new CWGIOData();
					            object2.printFileData();
					            assertEquals(a,CWGIOData.aString);   
					    }catch(Exception e){
					            System.out.println("Error in testPrintFileData()");
					    }
	}

	@Test
	public void testInitialMatix() {
					try{
				            int numVer = 4;
				            int input[][] = new int[numVer][numVer];
				            for (int i = 0; i < numVer; i++) {
				                for (int j = 0; j < numVer; j++) {
				                                                 if((i==0)&&(j==3)){input[i][j]=1;}
				                                            else if((i==1)&&(j==3)){input[i][j]=1;}
				                                            else if((i==3)&&(j==1)){input[i][j]=1;}
				                                            else if((i==3)&&(j==0)){input[i][j]=1;}
				                                            else{input[i][j]=0;}
				                    }
				            }
				            CWGIOData object1 = new CWGIODatan();
				            object1.initialMatrix();
				            Assert.assertArrayEquals(input, CWGIOData.X);
				        }catch(Exception e){
				            System.out.println("Error in testInitialMatrix()")
			        	
		  }
}
