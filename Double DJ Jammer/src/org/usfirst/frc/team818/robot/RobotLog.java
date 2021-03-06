package org.usfirst.frc.team818.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RobotLog{
	
	private static String[] log;
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("[HH:mm:ss]\t");
	private static Date date;
	
	public static void init() {
		
		date = new Date();
		
		log = new String[32];
		
		for (int i = 0; i < 32; i++) {
			log[i] = "";
		}
		
		updateLog();
		
	}
	
	public static void putMessage(String message) {
		
		for(int i = 31; i > 0; i--) {
			log[i] = log[i - 1];
		}
		
		date = new Date();
		
		log[0] = timeFormat.format(date) + message;
		
		updateLog();
		
	}
	
	private static void updateLog() {
		
		String logMessage = "";
		
		for (int i = 0; i < 32; i++) {
			logMessage += "\n" + log[i];
		}
		
		logMessage = logMessage.replaceFirst("\n", "");
		
		try{
			SmartDashboard.putString("Robot Log", logMessage);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.toString());
		}
	}
}
