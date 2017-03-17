/*package org.usfirst.frc.team818.robot.unused;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.RobotUtilities;


public class DriveHaloCommand extends CommandBase {
	
	private double slowConstant;
	private double speedX;
	private double speedY;
	private double speedLeft;
	private double speedFront;
	private double speedBack;
	private double speedRight;
	
	public DriveHaloCommand() {
		requires(drive);
		slowConstant = Constants.slowConstant;
	}

	protected void initialize() {
		
		RobotLog.putMessage("Enabling halo drive");
		SmartDashboard.putString("Drive Type", "Master Chief in Control");
		
		speedLeft = 0;
		speedFront = 0;
		speedBack = 0;
		speedRight = 0;
		
		drive.resetGyro();
		
	}

	protected void execute() {
		
		speedX = oi.rightX();
		speedY = oi.leftY();
		speedFront = oi.leftX();
		speedBack = oi.leftX();
		
		speedX = RobotUtilities.floorSmall(speedX);
		speedY = RobotUtilities.floorSmall(speedY);
		speedFront = RobotUtilities.floorSmall(speedFront);
		speedBack = RobotUtilities.floorSmall(speedBack);
		
		speedFront += speedX;
		speedBack -= speedX;
		if (Math.abs(speedFront) > 1) speedFront = (speedFront > 1) ? 1 : -1;
		if (Math.abs(speedBack) > 1) speedBack = (speedBack > 1) ? 1 : -1;
		
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
		
		if (oi.driveSlow()) {
			speedLeft *= slowConstant;
			speedFront *= slowConstant;
			speedBack *= slowConstant;
			speedRight *= slowConstant;
		}
		
		//drive.setMotors(speedLeft, speedFront, speedBack, speedRight);
		
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
*/