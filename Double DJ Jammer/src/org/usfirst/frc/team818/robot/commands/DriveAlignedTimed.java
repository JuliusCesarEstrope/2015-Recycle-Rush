package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveAlignedTimed extends CommandBase {
	
	private Timer timer;
	
	private double CORRECTION = 0.03;
	private double RATIO;
	
	private double angle;
	private double speedLeft;
	private double speedCenter;
	private double speedRight;
	private double speedX;
	private double speedY;
	private double time;
	
	public DriveAlignedTimed(double speedX, double speedY, double time) {
		requires(drive);
		this.speedX = speedX;
		this.speedY = speedY;
		this.time = time;
	}
	
	public DriveAlignedTimed(double speedY, double time) {
		this(0, speedY, time);
	}
	
	protected void initialize() {
		RobotLog.putMessage("Driving in perfect alignment for a specified time");
		RATIO = SmartDashboard.getNumber("Number 1");
		angle = 0;
		speedLeft = 0;
		speedCenter = 0;
		speedRight = 0;
		drive.resetGyro();
		timer = new Timer();
		timer.start();
	}

	protected void execute() {
		
		angle = drive.gyroAngle();

		speedLeft = speedY;
		speedCenter = speedX;
		speedRight = speedY;
		
		if (speedX > 0) {
			if (speedY > 0) {
				speedLeft -= (RATIO * speedX);
			} else {
				speedRight += (RATIO * speedX);
			}
		} else {
			if (speedY > 0) {
				speedRight += (RATIO * speedX);
			} else {
				speedLeft -= (RATIO * speedX);
			}
		}
		
		if (speedLeft != 0) speedLeft -= CORRECTION * angle;
		
		drive.setMotors(speedLeft, speedCenter, speedRight);
		
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
