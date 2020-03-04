/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger.controller;

import com.logger.model.JobLogger;
import java.util.logging.Level;

/**
 *
 * @author agreggio
 */
public class LevelLogger implements ILevel {

	@Override
	public  void Message(String messageText, JobLogger jobLogger) {
		jobLogger.getLogger().log(Level.INFO, messageText);
	}

	@Override
	public void Warning(String messageText, JobLogger jobLogger) {
                jobLogger.getLogger().log(Level.WARNING, messageText);
	}

	@Override
	public void Error(String messageText, JobLogger jobLogger) {
		jobLogger.getLogger().log(Level.SEVERE, messageText);
	}
        

 
    
}
