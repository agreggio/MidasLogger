/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger.model;


import java.util.Map;
import java.util.logging.Logger;



   public class JobLogger {
	private final  boolean logToFile;
	private final boolean logToConsole;
	private final boolean logMessage;
	private final boolean logWarning;
	private final boolean logError;
	private final boolean logToDatabase;
	private final Map paramsMap;
	private static Logger logger;


    public JobLogger(boolean logToFile, boolean logToConsole, boolean logMessage, boolean logWarning, boolean logError, boolean logToDatabase, Map paramsMap, String nameLogger) {
        this.logToFile = logToFile;
        this.logToConsole = logToConsole;
        this.logMessage = logMessage;
        this.logWarning = logWarning;
        this.logError = logError;
        this.logToDatabase = logToDatabase;
        this.paramsMap = paramsMap;
        JobLogger.logger = Logger.getLogger(nameLogger);
    }

    public boolean isLogToFile() {
        return logToFile;
    }

    public boolean isLogToConsole() {
        return logToConsole;
    }

    public boolean isLogMessage() {
        return logMessage;
    }

    public boolean isLogWarning() {
        return logWarning;
    }

    public boolean isLogError() {
        return logError;
    }

    public boolean isLogToDatabase() {
        return logToDatabase;
    }

    public Map getParamsMap() {
        return paramsMap;
    }

    public Logger getLogger() {
        return logger;
    }
        
        

   }
