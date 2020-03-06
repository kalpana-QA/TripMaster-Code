package com.tripmasters.framework.reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	 private static ExtentReports extent;
	 
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	            //Set HTML reporting file location
	            String workingDir = System.getProperty("user.dir");
	            //if (System.getProperty("os.name").toLowerCase().contains("win")) {
	                extent = new ExtentReports(workingDir + "/target/ExtentReports/ExtentReportResults.html", true);
	                
	                extent.addSystemInfo("ProjectName", "TripMasters");
	                extent.addSystemInfo("Environment", "Web");
	                extent.addSystemInfo("HostOrg", "ImpactQA");
	           // }
//	            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
//	                extent = new ExtentReports(workingDir + "/test-output/ExtentReportResults.html", true);
//	            }
	                
	        }
	        return extent;
	    }
}
