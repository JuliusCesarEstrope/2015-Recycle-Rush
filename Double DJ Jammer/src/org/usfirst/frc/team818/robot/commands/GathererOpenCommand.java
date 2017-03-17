package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;

import edu.wpi.first.wpilibj.Timer;


public class GathererOpenCommand extends CommandBase {
	
	private boolean timed;
	
	private Timer timer;
	
	public GathererOpenCommand(boolean timed) {
		requires(gathererArms);
		this.timed = timed;
	}

	protected void initialize() {
		if (!gathererArms.leftOuterLimit() && !gathererArms.rightOuterLimit()) {
			RobotLog.putMessage("Opening the gatherer");
			gathererArms.open();
			if (timed) {
				timer = new Timer();
				timer.start();
			}
		} else {
			RobotLog.putMessage("Tried opening, but the limit has been reached");
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return (timed) ? (gathererArms.leftOuterLimit() || gathererArms.rightOuterLimit() || timer.hasPeriodPassed(1.5)) : (gathererArms.leftOuterLimit() || gathererArms.rightOuterLimit());
	}

	protected void end() {
		gathererArms.stopArms();
	}

	protected void interrupted() {
		gathererArms.stopArms();
	}
}
