package APIAutomationFramework.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    public int intialValue =0;
    public static final int maxRunCount =3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(intialValue<maxRunCount){
            intialValue++;
            return true;
        }
        return false;
    }
}
