package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class DriveTankish extends CommandBase {
	
	private double speedLeft;
	private double speedCenter;
	private double speedRight;
	
	public DriveTankish() {
		requires(drive);
	}

	protected void initialize() {
		RobotLog.putMessage("Driving in a tankish manner");
		speedLeft = 0;
		speedCenter = 0;
		speedRight = 0;
	}

	protected void execute() {
		speedLeft = oi.leftY();
		speedCenter = oi.leftX();
		speedRight = oi.rightY();
		drive.setMotors(speedLeft, speedCenter, speedRight);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		oi.tankishEnabled = false;
		drive.setMotors(0, 0, 0);
	}

	protected void interrupted() {
		oi.tankishEnabled = false;
		drive.setMotors(0, 0, 0);
	}
}
