package com.tripmasters.framework.reports;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import com.relevantcodes.extentreports.ExtentReports;
import com.tripmasters.framework.base.TestBase;


public class ExtentManager extends TestBase {

	 private static ExtentReports extent;
	 
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	            //Set HTML reporting file location
	            String workingDir = System.getProperty("user.dir");
	            //if (System.getProperty("os.name").toLowerCase().contains("win")) {

	            
	            //satyam
	            /////////////To Get TimeZone ID's/////////////
//	            String[] availableIDs = TimeZone.getAvailableIDs();
//
//	            for(String id : availableIDs) {
//	                System.out.println("id = " + id);
//	            }

	            //////////////////////////////////////////////
	            
	            ////////////////To Set TimeZone////////////
	            
//	            Calendar calendar = new GregorianCalendar();
//
//	            calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//
//	            calendar.set(Calendar.HOUR_OF_DAY, -8);
//
//	            System.out.println("UTC: " + calendar.get(Calendar.HOUR_OF_DAY));
	          //  System.out.println("UTC: " + calendar.getTimeInMillis());

//	            calendar.setTimeZone(TimeZone.getTimeZone("GMT-4"));
//	            System.out.println("USA: " + calendar.get(Calendar.HOUR_OF_DAY));
//	            System.out.println("USA: " + calendar.getTime());

//	            calendar.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//	            System.out.println("NYC: " + calendar.get(Calendar.HOUR_OF_DAY));
//	            System.out.println("NYC: " + calendar.getTime());
//	            ///////////////////////////////////////////
//	            Locale locale = new Locale("en", "US");
//	            DateFormat dateFormat = DateFormat.getDateTimeInstance(
//	                    DateFormat.DEFAULT,DateFormat.DEFAULT, locale);
//
//	            String dateUsa = dateFormat.format(new Date());
//	            System.out.println(dateUsa);
	            //////
	           String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	                extent = new ExtentReports(workingDir + "/target/ExtentReports/" + timestamp +".html", true);
	                extent.addSystemInfo("User Name", "IQA");

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
