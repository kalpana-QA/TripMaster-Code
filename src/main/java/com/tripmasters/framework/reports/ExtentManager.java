package com.tripmasters.framework.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.tripmasters.framework.base.TestBase;

public class ExtentManager extends TestBase {
	
	 private static ExtentReports extent;
	 
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	            //Set HTML reporting file location
	            String workingDir = System.getProperty("user.dir");
	            //if (System.getProperty("os.name").toLowerCase().contains("win")) {
	               String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	                extent = new ExtentReports(workingDir + "/target/ExtentReports/" + timeStamp + ".html", true);

	                extent.addSystemInfo("ProjectName", "TripMasters");
	                extent.addSystemInfo("Environment", platform);
	                extent.addSystemInfo("HostOrg", "ImpactQA");
	           // }
//	            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
//	                extent = new ExtentReports(workingDir + "/test-output/ExtentReportResults.html", true);
//	            }
	                
	        }
	        return extent;
	    }
}
