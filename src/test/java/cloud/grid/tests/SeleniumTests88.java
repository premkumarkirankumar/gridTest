package cloud.grid.tests;

import org.testng.annotations.Test;

import cloud.grid.workflow.Workflow;

public class SeleniumTests88 extends BaseTest {
	
	@Test
	public void test() {

		Workflow workflow = new Workflow(driver);
		workflow.purchaseProducts();
		
	}
	
}
;
