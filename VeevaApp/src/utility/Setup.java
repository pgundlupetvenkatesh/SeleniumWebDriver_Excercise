package CallReport;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Setup {
	Properties pro;
	public Setup() {
		try {
			File src = new File("./Config/config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			System.out.println("Possible Defect - "+e.getMessage());
		}
	}
	
	public String getIEDriver() {
		return pro.getProperty("IEDriver");
	}
	
	public String getChromeDriver() {
		return pro.getProperty("ChromeDriver");
	}
	
	public String appUrl() {
		return pro.getProperty("URL");
	}
}