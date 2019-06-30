package runner;

import java.io.*;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import manager.FileReaderManager;


 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/SampleFeature",
		 glue= {"stepDefinitions"},
		 plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" } ,
		 monochrome = true
 )

public class SampleTestRunner {

	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 
	 
	 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", System.getProperty("os.name") );
     Reporter.setSystemInfo("Selenium", "3.141.59");
     Reporter.setSystemInfo("Maven", "3.5.3");
     Reporter.setSystemInfo("Java Version", System.getProperty("java.runtime.version"));
     Reporter.setSystemInfo("Java compiler", System.getProperty("java.compiler"));
     
	 }
	
	
	
}
