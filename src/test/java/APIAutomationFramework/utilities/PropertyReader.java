package APIAutomationFramework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    //Responsibility -- give the value by key

    public static String readKey(String key, String env){
        Properties p = new Properties();
        //class extended from Hashtable

        try {
            if (env.equalsIgnoreCase("QA")) {
                FileInputStream f = new FileInputStream("src/test/resource/data.properties");
                p.load(f);
            } else if (env.equalsIgnoreCase("Stage")) {
                FileInputStream f = new FileInputStream("src/test/resource/dataStage.properties");
                p.load(f);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return p.getProperty(key);
    }
}
