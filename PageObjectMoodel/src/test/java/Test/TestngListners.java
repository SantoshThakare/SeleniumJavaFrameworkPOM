package Test;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.Reporter;

public class TestngListners implements ISuiteListener{
	 public void onStart(ISuite suite) {
		 Reporter.log("Suite started" + suite.getName(),true); 
	 }
	 public void onFinish(ISuite suite) {
		 Reporter.log("Suite finished" + suite.getName(),true); 
	 }
	 

}
