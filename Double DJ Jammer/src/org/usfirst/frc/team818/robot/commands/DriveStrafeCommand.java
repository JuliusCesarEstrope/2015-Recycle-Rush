package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class DriveStrafeCommand extends CommandBase {
	
	private double speed;
	
	public DriveStrafeCommand(double speed) {
		
		requires(drive);
		
		this.speed = speed;
		
	}

	protected void initialize() {
		RobotLog.putMessage("Strafing " + ((speed > 0) ? "right" : "left"));
		drive.setMotors(0, speed, 0);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		drive.setMotors(0, 0, 0);
	}

	protected void interrupted() {
		drive.setMotors(0, 0, 0);
	}
}
