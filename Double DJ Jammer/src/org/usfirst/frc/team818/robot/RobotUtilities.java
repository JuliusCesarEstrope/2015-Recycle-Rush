package org.usfirst.frc.team818.robot;


public class RobotUtilities {
	
	public static double floorSmall(double value) {
		if (Math.abs(value) < 0.1) {
			return 0;
		} else {
			return value;
		}
	}
	
}