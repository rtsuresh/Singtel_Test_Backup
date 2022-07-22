package com.qa.util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.xml.sax.InputSource;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UtilityFunctions {
	
	static int couponcounter=0;
	
	static int receiptcounter=0;
	
	
	public static int getCouponCounter()
	{
		return couponcounter;
	}
	
	public static int getReceiptCounter()
	{
		return receiptcounter;
	}
	
	public static void incrementReceiptCounter()
	{		
		receiptcounter = receiptcounter+ 1;
	}
	
	public static void incrementCouponCounter()
	{
		couponcounter = couponcounter+ 1;
	}
	
	// Explicit Wait
	public static boolean waitforElement(WindowsDriver<WebElement> driver, String elementaccessibilityID,int timeout) throws InterruptedException
	{
		int attempt = 0 ;
		WebElement element = null;
		boolean result = false;
		
		do
		{		
			try
			{
				attempt=attempt+1;
				element =  driver.findElementByAccessibilityId(elementaccessibilityID);			
			}
			catch(Exception e)
			{				
				Thread.sleep(1000);			
			}
			if(element!=null)
			{
				attempt = timeout+1;
				result = true;
			}
		} while (attempt<=timeout);
		
		return result;	
	}
	
	public static boolean waitforElement(WebElement parentelement, String elementname,int timeout) throws InterruptedException
	{
		int attempt = 0 ;
		WebElement element = null;
		boolean result = false;
		
		do
		{		
			try
			{
				attempt=attempt+1;
				element =  parentelement.findElement(By.name(elementname));			
			}
			catch(Exception e)
			{				
				Thread.sleep(1000);			
			}
			if(element!=null)
			{
				attempt = timeout+1;
				result = true;
			}
		} while (attempt<=timeout);
		
		return result;	
	}
	
	public static String dateFormatCurrentDate(String dataformat)
	{		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dataformat);  
		LocalDateTime now = LocalDateTime.now();  
		String CurrentDate = dtf.format(now);
		return CurrentDate;
	}
	
	public static String getReferencePath(String strFileName) throws Exception
	{
		String strPath = System.getProperty("user.dir");
		strPath = new File(strPath + "/..").getCanonicalPath();
		strPath = strPath + "\\YRAPP\\" + TestBase.prop.getProperty("REFERENCEFolder")+"\\"+ strFileName;
		return strPath;
	}
	
	public static String getReceiptFileName() throws Exception
	{
		//incrementReceiptCounter();
		String strPath = System.getProperty("user.dir");
		strPath = new File(strPath + "/..").getCanonicalPath();
		strPath = strPath + "\\YRAPP\\target\\" + TestBase.prop.getProperty("ReceiptFileName")+String.valueOf(getReceiptCounter())+".pdf";
		return strPath;
	}
	
	public static String getCouponFileName() throws Exception
	{
		//incrementCouponCounter();
		String strPath = System.getProperty("user.dir");
		strPath = new File(strPath + "/..").getCanonicalPath();
		strPath = strPath + "\\YRAPP\\target\\" + TestBase.prop.getProperty("CouponFileName")+String.valueOf(getCouponCounter())+".pdf";
		return strPath;
	}
	
	public static String convertPDFtoString(String FilePath) throws Exception
	{
		Thread.sleep(2000);
		  PDDocument document = PDDocument.load(new File(FilePath));
		  AccessPermission ap = document.getCurrentAccessPermission();
	      if (!ap.canExtractContent())
	      {
	          throw new IOException("You do not have permission to extract text");
	      }
	      
	      PDFTextStripper stripper = new PDFTextStripper();
	      //stripper.setSortByPosition(true);
	      String text = stripper.getText(document);
	      return text;
	}
	
	public static String convert(String json, String root) throws Exception {
	      JSONObject jsonObject = new JSONObject(json);
	      String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<"+root+">" + XML.toString(jsonObject) + "</"+root+">";
	      return xml;
	   }
	
	public static Response getAPIResponse(String URL, String Header) {
		 Response getresponse = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON,"Authorization",Header).
		         when().get(URL).then().contentType(ContentType.JSON).extract().response();
		 return getresponse;
	}
	
	public static String getXPathValuefromXML(String XML, String XPath) throws Exception {
		 InputSource source1 = new InputSource(new StringReader(XML));
		 XPathFactory xpathFactory = XPathFactory.newInstance();
		 XPath xpath = xpathFactory.newXPath();
		 String msg = xpath.evaluate(XPath, source1);
		 return(msg);
		
	}
	public static void ifProcessExistsKill(String processname) throws Exception {
	
			String line;
			String pidInfo ="";
		
			Process p =Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
		
			BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));
		
			while ((line = input.readLine()) != null) {
			    pidInfo+=line; 
			}
		
			input.close();
		
			if(pidInfo.contains(processname))
			{
			    // close the process
				Runtime.getRuntime().exec("taskkill /im "+processname+" /f");
			}
			
	
	}
	
	public static Region checkImagePath(String strFileName) throws Exception
	{
		 Region region = null;
		 Pattern pattern = null;
		
		
		
		String path = UtilityFunctions.getReferencePath(strFileName);		
		 Screen s = new Screen();
		 
		 if (strFileName.contentEquals("CouponExists.png") || strFileName.contentEquals("ReceiptExists.png")) 
			 pattern = new Pattern(path).similar(0.7);
		 else
			 pattern = new Pattern(path).exact();
		  
		  region = s.exists(pattern,2);
		 
		 return region;
	}
	
	public static String formatinto2decimals(String strValue) 
	{
		return(String.format("%.2f", Double.parseDouble(strValue))); 	
		 
	}
	
	public static String formatinto2decimals(Double dblvalue) 
	{
		return(String.format("%.2f",dblvalue)); 	
		 
	}
	
	public static String changetoUSLocale(String strValue) throws Exception 
	{
		DecimalFormat df = new DecimalFormat();
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator('.');
		df.setDecimalFormatSymbols(symbols);
		return(String.valueOf(df.parse(strValue)));		 
	}
	
	public static String changetoNonUSLocale(String strValue) throws Exception 
	{
		DecimalFormat df = new DecimalFormat();
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator('.');
		df.setDecimalFormatSymbols(symbols);
		df.setMinimumFractionDigits(2);		
		String strFormattedValue = df.format(Double.parseDouble(strValue));		
		return(strFormattedValue);	 
	}
	
}
