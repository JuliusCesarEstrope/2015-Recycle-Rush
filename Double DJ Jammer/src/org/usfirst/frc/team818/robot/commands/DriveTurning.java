package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.RobotUtilities;
import org.usfirst.frc.team818.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTurning extends CommandBase {
	
	private double RATIO;
	
	private double speedLeft;
	private double speedCenter;
	private double speedRight;
	private double speedTurn;
	private double speedX;
	private double speedY;
	
	public DriveTurning() {
		requires(drive);
	}
	
	protected void initialize() {
		RobotLog.putMessage("Driving turningly");
		RATIO = SmartDashboard.getNumber("Number 1");
		speedLeft = 0;
		speedCenter = 0;
		speedRight = 0;
		speedTurn = 0;
		speedX = 0;
		speedY = 0;
	}

	protected void execute() {
		
		speedTurn = RobotUtilities.floorSmall(oi.rightX());
		speedX = RobotUtilities.floorSmall(oi.leftX());
		speedY = RobotUtilities.floorSmall(oi.leftY());
		
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
		
		if (speedTurn > 0) {
			if (speedY > 0) {
				speedLeft = speedLeft - speedTurn;
				speedRight = Math.max(speedTurn,  speedRight);
			} else {
				speedLeft = -Math.max(speedTurn, -speedLeft);
				speedRight = speedRight + speedTurn;
			}
		} else {
			if (speedY > 0) {
				speedLeft = Math.max(-speedTurn,  speedLeft);
				speedRight = speedRight + speedTurn;
			} else {
				speedLeft = speedLeft - speedTurn;
				speedRight = -Math.max(-speedTurn, -speedRight);
			}
		}
		
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
