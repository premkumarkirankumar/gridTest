package seleniumtests;

import org.testng.annotations.Test;

public class SeleniumTests15 extends BaseTest {
	
	@Test
	public void test() {

		Workflow workflow = new Workflow(driver);
		workflow.purchaseProducts();
		
	}
	
}
;
