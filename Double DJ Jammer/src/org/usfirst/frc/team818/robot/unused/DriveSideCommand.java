package org.usfirst.frc.team818.robot.unused;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team818.robot.Constants;
import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.commands.CommandBase;


public class DriveSideCommand extends CommandBase {
	
	private double speed;
	
	public DriveSideCommand() {
		requires(drive);
	}

	protected void initialize() {
		RobotLog.putMessage("Switching to side drive");
		SmartDashboard.putString("Drive Type", "Going perfectly sideways");
		speed = 0;
	}

	protected void execute() {
		
		speed = oi.rightX();
		
		if (Math.abs(speed) < 0.1) speed = 0;
		if (oi.driveSlow()) speed *= Constants.slowConstant;
		
		drive.setMotors(0, speed, 0);
		
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
