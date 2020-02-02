package com.tripmasters.framework.utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	 private static ExtentReports extent;
	 
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	            //Set HTML reporting file location
	            String workingDir = System.getProperty("user.dir");
	            //if (System.getProperty("os.name").toLowerCase().contains("win")) {
	                extent = new ExtentReports(workingDir + "\\ExtentReportResults.html", true);
	           // }
//	            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
//	                extent = new ExtentReports(workingDir + "/test-output/ExtentReportResults.html", true);
//	            }
	        }
	        return extent;
	    }
}
