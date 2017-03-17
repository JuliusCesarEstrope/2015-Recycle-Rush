package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.RobotUtilities;
import org.usfirst.frc.team818.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveAligned extends CommandBase {
	
	private double CORRECTION = 0.03;
	private double RATIO;
	
	private double angle;
	private double speedLeft;
	private double speedCenter;
	private double speedRight;
	private double speedX;
	private double speedY;
	
	private int direction;
	
	public DriveAligned(int direction) {
		requires(drive);
		this.direction = direction;
	}
	
	public DriveAligned() {
		this(0);
	}
	
	protected void initialize() {
		RobotLog.putMessage("Driving in perfect alignment");
		RATIO = SmartDashboard.getNumber("Number 1");
		angle = 0;
		speedLeft = 0;
		speedCenter = 0;
		speedRight = 0;
		speedX = 0;
		speedY = 0;
		drive.resetGyro();
	}

	protected void execute() {
		
		angle = drive.gyroAngle();
		RobotLog.putMessage("" + angle);
		speedX = RobotUtilities.floorSmall((direction <= 0) ? (oi.leftX()) : 0);
		speedY = RobotUtilities.floorSmall((direction >= 0) ? (oi.leftY()) : 0);
		
		speedLeft = speedY - (RATIO * speedX);
		speedCenter = speedX;
		speedRight = speedY + (RATIO * speedX);
		
		if (speedLeft > 1) {
			speedRight -= (speedLeft - 1);
			speedLeft = 1;
		} else if (speedLeft < -1) {
			speedRight -= (speedLeft + 1);
			speedLeft = -1;
		} else if (speedRight > 1) {
			speedLeft -= (speedRight - 1);
			speedRight = 1;
		} else if (speedRight < -1) {
			speedLeft -= (speedRight + 1);
			speedRight = -1;
		}
		
		/*if (speedX > 0) {
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
		}*/
		
		/*if (speedX > 0) {
			if (angle > 0) {
				speedLeft -= (RATIO * speedX);
				speedRight += (RATIO * speedX);
			} else {
				speedLeft += (RATIO * speedX);
				speedRight -= (RATIO * speedX);
			}
		} else {
			if (angle > 0) {
				speedLeft += (RATIO * speedX);
				speedRight -= (RATIO * speedX);
			} else {
				speedLeft -= (RATIO * speedX);
				speedRight += (RATIO * speedX);
			}
		}*/
		
		if (speedLeft != 0) speedLeft -= CORRECTION * angle;
		
		drive.setMotors(speedLeft, speedCenter, speedRight);
		
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
