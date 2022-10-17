package seleniumtests;

import org.testng.annotations.Test;

public class SeleniumTests27 extends BaseTest {
	
	@Test
	public void test() {

		Workflow workflow = new Workflow(driver);
		workflow.purchaseProducts();
		
	}
	
}
;
