package org.usfirst.frc.team818.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team818.robot.RobotLog;


public class GathererCollectCommand extends CommandBase {
	
	private Timer timer;
	
	private boolean timed;
	
	public GathererCollectCommand(boolean timed) {
		requires(gathererWheels);
		this.timed = timed;
	}

	protected void initialize() {
		if (timed) {
			RobotLog.putMessage("Collecting totes in a timely manner");
			timer = new Timer();
			timer.start();
		} else {
			RobotLog.putMessage("Collecting totes");
		}
		gathererWheels.collect();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		if (timed) {
			return timer.hasPeriodPassed(3);
		} else {
			return false;
		}
	}

	protected void end() {
		gathererWheels.stopWheels();
	}

	protected void interrupted() {
		gathererWheels.stopWheels();
	}
}
