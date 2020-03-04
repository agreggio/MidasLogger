/*
Es un log de errores
 */
package com.logger.controller;

import com.logger.model.JobLogger;
import com.logger.utils.Path;
import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class LogMessage {

    public static void LogMessage(String messageText, boolean message, boolean warning, boolean error, JobLogger jobLogger) throws Exception {
        messageText = messageText.trim();

        //anidar los if para evitar evaluar todas las condiciones
        if (messageText == null || messageText.length() == 0) {
            return;
        }
        // si no tiene ninguna de las 3 configuraciones arroja la exceotion, no deberia ser una exepcion ya que no es un error
        if (!jobLogger.isLogToConsole() && !jobLogger.isLogToFile() && !jobLogger.isLogToDatabase()) {
            throw new Exception("Invalid configuration");
        }

        if ((!jobLogger.isLogError() && !jobLogger.isLogMessage() && !jobLogger.isLogWarning()) || (!message && !warning && !error)) {
            throw new Exception("Error or Warning or Message must be specified");
        }

        if (error && jobLogger.isLogError()) {

        }

        if (warning && jobLogger.isLogWarning()) {

        }

        if (message && jobLogger.isLogMessage()) {

        }

        if (jobLogger.isLogToFile()) {
            jobLogger.getLogger().addHandler(FileLogger.getFileLogger(jobLogger.getParamsMap())); //Imprime en el archivo
            jobLogger.getLogger().log(Level.INFO, messageText); //Muestra en la consola "SE REPITE"
        }

        if (jobLogger.isLogToConsole()) {
            jobLogger.getLogger().addHandler(ConsoleLogger.getConsoleLogger());
            jobLogger.getLogger().log(Level.INFO, messageText);
        }

        if (jobLogger.isLogToDatabase()) {
            DbLogger.executeUpdate(jobLogger.getParamsMap(), "insert into Log_Values('" + message + "', " + String.valueOf("") + ")");
        }
    }

}
