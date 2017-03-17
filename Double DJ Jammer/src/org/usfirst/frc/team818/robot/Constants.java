package org.usfirst.frc.team818.robot;


public class Constants {
	
	/* Test robot settings:
	 * motorLeftFront = 11;
	 * motorLeftBack = 1;
	 * motorRightFront = 12;
	 * motorRightBack = 10;
	 * 
	 * Competition robot settings:
	 * motorLeftFront = 3;
	 * motorLeftBack = 4;
	 * motorCenterFront = 2;
	 * motorCenterBack = 5;
	 * motorRightFront = 1;
	 * motorRightBack = 6;
	 * towerMotorPort = 9;
	 * extenderMotorPort = 7;
	 */
	
	public static final boolean testBot = true;
	
	// To make things not break completely
	public static final boolean gyroEnabled = true;
	
	// Needed constants
	public static final double slowConstant = 0.6;
	
	// Joystick ports
	public static final int driverControllerPort = 0;

	
	// Drive motor PWMs
	private static final int motorLeft = 4;
	private static final int motorRight = 6;
	private static final int motorLeft1 = 8;
	private static final int motorRight1 = 10;
	public static final int[] driveMotorPorts = {motorLeft, motorRight, motorLeft1, motorRight1};
	
	// Gyro setup
	public static final int gyroPort = 0;
