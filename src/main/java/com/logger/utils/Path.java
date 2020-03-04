/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger.utils;

/**
 *
 * @author Alejandro Greggio
 */
public class Path {

    //obtiene la unidad principal, colocar en una carpeta utils
    public static String getPath() {
        String dp = System.getProperty("user.home");
        dp = dp.substring(0, 1);
        dp = dp + ":" + '\\';
        return dp;
    }

}
