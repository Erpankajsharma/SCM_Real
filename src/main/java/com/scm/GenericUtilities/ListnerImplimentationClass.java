package com.scm.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListnerImplimentationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onFinish(ITestContext context) {
		
		// consolidated the report
		report.flush();
	}

	public void onStart(ITestContext context) {
		
		//configure the Report
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("SCM Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Pankaj Sharma");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		String Failedscript = result.getMethod().getMethodName();
		
		String FS = Failedscript+ new JavaUtility().getSystemDateAndTimeInFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File path = new File("./FScript/"+FS+".png");
		String filePath = path.getAbsolutePath();
		try {
			FileUtils.copyFile(src, path);
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("--TestScript execution failed--");
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" --skipped");
		Reporter.log("--TestScript execution skipped--");
	}

	public void onTestStart(ITestResult result) {
		
		//Execution starts from here
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"-----> TestScript execution started.");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"----> Passed");
		Reporter.log(methodName+"-----> TestScript execution successful");
		
	}
	
	

}
