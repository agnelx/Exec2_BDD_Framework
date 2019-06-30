package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import java.nio.file.Path;
import java.nio.file.Paths;


public class configFileReader {

	private Properties properties;
	private final String propertyFilePath = "config/config.properties";

	public configFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {

		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the config.properties file.");

	}

	public long getImplicitlyWait() {
		String implicitwait = properties.getProperty("implicitwait");
		if (implicitwait != null)
			return Long.parseLong(implicitwait);
		else
			throw new RuntimeException("implicitwait not specified in the config.properties file.");
	}

	public String getReportConfigPath() {
		Path currentUsersHomeDir = Paths.get(System.getProperty("user.dir"));
		Path reportConfig = Paths.get(properties.getProperty("reportConfigPath"));
		Path reportConfigAppend = (currentUsersHomeDir.resolve(reportConfig));
		String reportConfigPath =reportConfigAppend.toString();
		
		
		if (reportConfig != null )
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the config.properties file for the Key:reportConfigPath");
	}
	
	public static String getReportTargetPath(){
		Path currentUsersHomeDir = Paths.get(System.getProperty("user.dir"));
		String targetreportConfig = "target/cucumber-reports/report.html";
		Path targetreportConfigAppend = (currentUsersHomeDir.resolve(targetreportConfig));
		String targetreportPath =targetreportConfigAppend.toString();
		
		
		if (targetreportPath != null )
			return targetreportPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the config.properties file for the Key:reportConfigPath");
	}

}
