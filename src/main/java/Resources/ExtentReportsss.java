package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsss {
	public static ExtentReports getReports() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter ss=new ExtentSparkReporter(path);
		ss.config().setDocumentTitle("Testing");
		ss.config().setReportName("Web Automation Testing");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(ss);
		extent.setSystemInfo("Hareesh", "Testing");
		return extent;
	}

}
