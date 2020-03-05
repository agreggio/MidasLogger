/*
Es un log de errores
 */
package com.logger.controller;

import com.logger.model.JobLogger;



public class LogMessage {

    public static void LogMessage(String messageText, JobLogger jobLogger) throws Exception {
        messageText = messageText.trim();
        
        if (messageText == null || messageText.isEmpty()) {
            return;
        }
        // si no tiene ninguna de las 3 configuraciones arroja la exceotion, no deberia ser una exepcion ya que no es un error
        if (!jobLogger.isLogToConsole() && !jobLogger.isLogToFile() && !jobLogger.isLogToDatabase()) {
            throw new Exception("Invalid configuration");
        }

        if ((!jobLogger.isLogError() && !jobLogger.isLogMessage() && !jobLogger.isLogWarning())) {
            throw new Exception("Error or Warning or Message must be specified");
        }
        
        int valueLevel = 0;
        
        if (jobLogger.isLogMessage()) {
            valueLevel = 1;
        }

        if (jobLogger.isLogError()) {
            valueLevel = 2;
        }

        if (jobLogger.isLogWarning()) {
            valueLevel = 3;
        }

        if (jobLogger.isLogToFile()) {
            jobLogger.getLogger().addHandler(FileLogger.getFileLogger(jobLogger.getParamsMap())); //Imprime en el archivo
        }

        if (jobLogger.isLogToConsole()) {
            jobLogger.getLogger().addHandler(ConsoleLogger.getConsoleLogger());
        }

        if (jobLogger.isLogToDatabase()) {
            DbLogger.executeUpdate(jobLogger.getParamsMap(), "INSERT INTO Log_Values (Message,ValueLevel) VALUES ("+messageText+","+String.valueOf(valueLevel)+");");
        }
        
        LevelLogger levelLogger = new LevelLogger();
        
        if (jobLogger.isLogError()) {
            levelLogger.Error(messageText, jobLogger);
        }

        if (jobLogger.isLogWarning()) {
            levelLogger.Warning(messageText, jobLogger);
        }

        if (jobLogger.isLogMessage()) {
            levelLogger.Message(messageText, jobLogger);
        }
    }
    
}
