/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger.controller;

import com.logger.utils.Path;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Alejandro Greggio
 */
public class FileLogger {

    public static FileHandler getFileLogger(Map<String, String> paramsMap) throws IOException {

        //Validar que este carpeta y conmbre de archivo    
        //Crea el directorio si no existe
        if (!paramsMap.get("folderLog").isEmpty() && !paramsMap.get("fileLog").isEmpty()) {

            File path = new File(Path.getPath() + paramsMap.get("folderLog"));
            if (!path.exists()) {
                path.mkdir();
            }
            // Crea el archivo log
            FileHandler fileHandler = new FileHandler(Path.getPath() + paramsMap.get("folderLog") + "/" + paramsMap.get("fileLog"), true); //falta parametro ya que sobreescribe el archivo y solo guarda un log

            // Se especifica que formato usara el manejador (handler)
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            return fileHandler;
        } else {

            return null;
        }

    }

}
