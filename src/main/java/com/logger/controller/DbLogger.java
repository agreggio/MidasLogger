/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logger.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Alejandro Greggio
 */
public class DbLogger {
    
	private static Connection connection;
	private static Properties connectionProps;
	private static Statement statament;

	public static void executeUpdate(Map dbParams, String updateQuery) throws SQLException {
		try {
			connectionProps = new Properties();
			connectionProps.put("user", dbParams.get("user"));
			connectionProps.put("password", dbParams.get("password"));
			connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")+ ":" + dbParams.get("portNumber") + "/", connectionProps);
			statament = connection.createStatement();
			statament.executeUpdate(updateQuery);
		} finally {
			connection.close();
			statament.close();
		}
	}
    
}
