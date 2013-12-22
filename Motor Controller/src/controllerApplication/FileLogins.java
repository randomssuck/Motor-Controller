package controllerApplication;

import java.util.Formatter;

public class FileLogins {
	
	private Formatter file;
	
	public FileLogins(String address) {
		openFile();
		addRecords(address);
		closeFile();
	}
	
	private void openFile() {
		try {
			file = new Formatter("\\logins\\logins.txt");
		}catch(Exception e){
			System.out.println("you have an error");
		}
	}
	
	private void addRecords(String address) {
		file.format("%s", address);
	}
	
	private void closeFile() {
		file.close();
	}
}