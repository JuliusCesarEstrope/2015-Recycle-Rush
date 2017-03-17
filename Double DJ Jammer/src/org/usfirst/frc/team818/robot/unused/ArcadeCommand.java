package org.usfirst.frc.team818.robot.unused;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.commands.CommandBase;


public class ArcadeCommand extends CommandBase {
	
	private double speedX;
	private double speedY;
	private double speedLeft;
	private double speedRight;
	
	public ArcadeCommand() {
		requires(drive);
	}

	protected void initialize() {
		RobotLog.putMessage("Switching to arcade drive");
		SmartDashboard.putString("Drive Type", "Galaga Drive");
		speedX = 0;
		speedY = 0;
		speedLeft = 0;
		speedRight = 0;
	}

	protected void execute() {
		
		speedX = oi.leftX();
		speedY = oi.rightY();
		
		if (Math.abs(speedX) < 0.1) speedX = 0;
		if (Math.abs(speedY) < 0.1) speedY = 0;
		
		if (speedX > 0) {
			if (speedY > 0) {
				speedLeft = speedY - speedX;
				speedRight = Math.max(speedX,  speedY);
			} else {
				speedLeft = -Math.max(speedX, -speedY);
				speedRight = speedY + speedX;
			}
		} else {
			if (speedY > 0) {
				speedLeft = Math.max(-speedX,  speedY);
				speedRight = speedY + speedX;
			} else {
				speedLeft = speedY - speedX;
				speedRight = -Math.max(-speedX, -speedY);
			}
		}
		
		drive.setMotors(speedLeft, speedRight);
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		drive.setMotors(0, 0);
	}

	protected void interrupted() {
		drive.setMotors(0, 0);
	}
}
