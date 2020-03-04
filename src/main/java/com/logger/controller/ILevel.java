/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger.controller;

import com.logger.model.JobLogger;

/**
 *
 * @author agreggio
 */
interface ILevel {

    public void Error(String messageText, JobLogger jobLogger);

    public void Warning(String messageText, JobLogger jobLogger);

    public void Message(String messageText, JobLogger jobLogger);

}
