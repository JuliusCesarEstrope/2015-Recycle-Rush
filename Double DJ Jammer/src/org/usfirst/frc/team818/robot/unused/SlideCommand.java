package org.usfirst.frc.team818.robot.unused;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team818.robot.RobotLog;
import org.usfirst.frc.team818.robot.commands.CommandBase;


public class SlideCommand extends CommandBase {
	
	private double speedX;
	private double speedY;
	
	public SlideCommand() {
		requires(drive);
	}

	protected void initialize() {
		RobotLog.putMessage("Switching to slide drive");
		SmartDashboard.putString("Drive Type", "Slip 'n Slide");
		speedX = 0;
		speedY = 0;
	}

	protected void execute() {
		
		speedX = oi.rightX();
		speedY = oi.rightY();
		
		if (Math.abs(speedX) < 0.1) speedX = 0;
		if (Math.abs(speedY) < 0.1) speedY = 0;
		
		drive.setMotors(speedY, speedX, speedY);
		
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
