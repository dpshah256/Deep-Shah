package com.launchings;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class Extentmanager extends BaseTest
{
public static ExtentReports report;
public static ExtentReports getInstance()
{
	
	if(report==null)
	{
		report = new ExtentReports(projectpath+"//Htmlfolder//reports.html");
		report.loadConfig(new File(projectpath+"//extentreportconfig.xml//"));
		report.addSystemInfo("selenium language binding","3.141.59").addSystemInfo("environment", mainProp.getProperty("env"));
	}
	return report;
	
}
	
	
}
