/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger.controller;

import java.util.logging.ConsoleHandler;

/**
 *
 * @author Alejandro Greggio
 */
public class ConsoleLogger {

    public static ConsoleHandler getConsoleLogger() {

        return new ConsoleHandler();

    }

}
