package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;

import edu.wpi.first.wpilibj.Timer;


public class DriveTimed extends CommandBase {
	
	private Timer timer;
	
	private double speedLeft;
	private double speedCenter;
	private double speedRight;
	private double time;
	
	public DriveTimed(double speedLeft, double speedCenter, double speedRight, double time) {
		requires(drive);
		this.speedLeft = speedLeft;
		this.speedCenter = speedCenter;
		this.speedRight = speedRight;
		this.time = time;
	}

	protected void initialize() {
		RobotLog.putMessage("Driving accordingly for a time");
		timer = new Timer();
		timer.start();
		drive.setMotors(speedLeft, speedCenter, speedRight);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}

	protected void end() {
		drive.setMotors(0, 0, 0);
	}

	protected void interrupted() {
		drive.setMotors(0, 0, 0);
	}
}
