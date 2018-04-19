package abcpack;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
private int retryCount = 0;
private int maxRetryCount = 1;
public boolean retry(ITestResult result)
 {

   if(retryCount < maxRetryCount)
    { 
	   System.out.println("Retrying test " + result.getName() + " for the " + (retryCount+1) + " time(s).");
	   retryCount++; 
	   return true; 
    } 
   return false; 
  } 
} 
