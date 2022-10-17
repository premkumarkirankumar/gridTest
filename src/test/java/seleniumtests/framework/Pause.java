package seleniumtests.framework;

import java.util.concurrent.TimeUnit;

public class Pause {
	
	public void forTimeout(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			//nothing
		}
	}

}
