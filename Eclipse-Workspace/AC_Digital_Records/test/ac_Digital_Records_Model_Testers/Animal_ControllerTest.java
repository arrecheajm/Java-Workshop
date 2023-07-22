package ac_Digital_Records_Model_Testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ac_Digital_Records_Controllers.Animal_Controller;
import ac_Digital_Records_Models.Collection;

/**
 * @author jma_u
 *
 */
public class Animal_ControllerTest {
	public static final String INITIALS = "JA";
	
	Collection animalInventory;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		Mockito.when()
	}

	@Test
	public void instantiateCollectionTest() {
		assertTrue(true);
		animalInventory = new Collection(Animal_Controller.getNewAnimal(INITIALS));
	}

}
