import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Sancho
 *
 */
public class CWGAlgoTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test method for {@link CWGAlgo#solveCWG()}.
	 */
	@Test
	public void testSolveCWG() {
				    try{
				        int ouput[][] = {{3,3},{0,1},{0,2},{1,2}};
				        CWGIOData object4 = new CWGIOData();
				        object4.initialMatrix();	
				        object4.printFileData();
				        object4.printInputMatrix();
				        CWGAlgo object5 = new CWGAlgo();
				        object5.printFixList();
				      
				    }catch(Exception e){
				        System.out.println("Error in testModel1()");
				    }
	}

	/**
	 * Test method for {@link CWGAlgo#checkEdgeExist(int, int)}.
	 */
	@Test
	public void testCheckEdgeExist() {
					try {
				            int i=0,j=1;
				            CWGIOData object3 = new CWGIOData();
				            object3.printFileData();
				            object3.initialMatrix();
				            CWGAlgo obj = new CWGAlgo();
				            assertTrue(obj.checkExist(i,j));
				        }catch(Exception e){
				             System.out.println("Error in testCheckExist()");
				        }
	}

}
