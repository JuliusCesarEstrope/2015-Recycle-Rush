package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team818.robot.commands.CommandBase;


public class AutoCenterCommand extends CommandBase {
	
	private Timer timer;
	
	public AutoCenterCommand() {
		requires(drive);
		requires(camera);
	}
	
	protected void initialize() {
		
		timer = new Timer();
		
		
		
		timer.start();
		
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return timer.hasPeriodPassed(1.0);
	}

	protected void end() {
		drive.setMotors(0, 0);
	}

	protected void interrupted() {
		drive.setMotors(0, 0);
	}
}
