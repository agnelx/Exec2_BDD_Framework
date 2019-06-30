package manager;

import dataProvider.configFileReader;



public class FileReaderManager {
	 
	 private static FileReaderManager fileReaderManager = new FileReaderManager();
	 private static configFileReader configFile;
	 
	 private FileReaderManager() {
	 }
	 
	 public static FileReaderManager getInstance( ) {
	       return fileReaderManager;
	 }
	 
	 public configFileReader getConfigReader() {
	 return (configFile == null) ? new configFileReader() : configFile;
	 }
	}