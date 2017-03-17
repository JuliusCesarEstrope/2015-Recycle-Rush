/*package org.usfirst.frc.team818.robot.unused;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.RobotUtilities;


public class DriveTankCommand extends CommandBase {
	
	private double slowConstant;
	private double speedLeft;
	private double speedCenter;
	private double speedRight;
	
	public DriveTankCommand() {
		requires(drive);
		slowConstant = Constants.slowConstant;
	}

	protected void initialize() {
		
		RobotLog.putMessage("Switching to tank drive");
		SmartDashboard.putString("Drive Type", "Tankalicious Drive");
		
		speedLeft = 0;
		speedCenter = 0;
		speedRight = 0;
		
	}

	protected void execute() {
		
		speedLeft = oi.leftY();
		speedCenter = (oi.leftX() + oi.rightX()) / 2;
		speedRight = oi.rightY();
		
		speedLeft = RobotUtilities.floorSmall(speedLeft);
		speedCenter = RobotUtilities.floorSmall(speedCenter);
		speedRight = RobotUtilities.floorSmall(speedRight);
		
		if (oi.driveSlow()) {
			speedLeft *= slowConstant;
			speedCenter *= slowConstant;
			speedRight *= slowConstant;
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
*/