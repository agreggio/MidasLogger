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

    private static final Map<String, String> paramsMap = new HashMap<String, String>();

    @Test
    public void testConsole() {
        paramsMap.put("carpeta", "asd");
        paramsMap.put("archivo", "logError.txt");

        JobLogger jobLogger = new JobLogger(false, true, true, true, true, false, paramsMap, "MyLog");
        try {
            LogMessage("testConsole", true, true, true, jobLogger);
        } catch (Exception ex) {
            Logger.getLogger(BasicApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testFile() {
        paramsMap.put("carpeta", "asd");
        paramsMap.put("archivo", "logError.txt");

        JobLogger jobLogger = new JobLogger(true, false, true, true, true, false, paramsMap, "MyLog");
        try {
            LogMessage("testFile", true, true, true, jobLogger);
        } catch (Exception ex) {
            Logger.getLogger(BasicApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testDbLogger() {
        paramsMap.put("carpeta", "asd");
        paramsMap.put("archivo", "logError.txt");

        JobLogger jobLogger = new JobLogger(false, false, true, true, true, true, paramsMap, "MyLog");
        try {
            LogMessage("testDbLogger", true, true, true, jobLogger);
        } catch (Exception ex) {
            Logger.getLogger(BasicApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testAll() {
        paramsMap.put("carpeta", "asd");
        paramsMap.put("archivo", "logError.txt");

        JobLogger jobLogger = new JobLogger(true, true, true, true, true, true, paramsMap, "MyLog");
        try {
            LogMessage("testAll", true, true, true, jobLogger);
        } catch (Exception ex) {
            Logger.getLogger(BasicApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
