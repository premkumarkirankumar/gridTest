package seleniumtests;

import org.testng.annotations.Test;

public class SeleniumTests13 extends BaseTest {
	
	@Test
	public void test() {

		Workflow workflow = new Workflow(driver);
		workflow.purchaseProducts();
		
	}
	
}
;
