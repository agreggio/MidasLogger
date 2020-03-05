package com.logger.test;



import static com.logger.controller.LogMessage.LogMessage;
import com.logger.model.JobLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicApplicationTests {

    private final Map<String, String> paramsMap = new HashMap<String, String>();
    JobLogger jobLogger;

    @Test
    public void testConsole() {
        paramsMap.put("folderLog", "temp");
        paramsMap.put("fileLog", "logError.txt");

        jobLogger = new JobLogger(false, true, true, true, true, false, paramsMap, "MyLog");
        try {
            LogMessage("testConsole", jobLogger);
        } catch (Exception ex) {
            Logger.getLogger(BasicApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testFile() {
        paramsMap.put("folderLog", "temp");
        paramsMap.put("fileLog", "logError.txt");

        jobLogger = new JobLogger(true, false, false, true, false, false, paramsMap, "MyLog");
        try {
            LogMessage("testFile", jobLogger);
        } catch (Exception ex) {
            Logger.getLogger(BasicApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testDbLogger() {
        paramsMap.put("folderLog", "temp");
        paramsMap.put("fileLog", "logError.txt");

        jobLogger = new JobLogger(false, false, true, true, true, true, paramsMap, "MyLog");
        try {
            LogMessage("testDbLogger", jobLogger);
        } catch (Exception ex) {
            Logger.getLogger(BasicApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testAll() {
        paramsMap.put("folderLog", "temp");
        paramsMap.put("fileLog", "logError.txt");

        jobLogger = new JobLogger(true, true, true, true, true, true, paramsMap, "MyLog");
        try {
            LogMessage("testAll", jobLogger);
        } catch (Exception ex) {
            Logger.getLogger(BasicApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
