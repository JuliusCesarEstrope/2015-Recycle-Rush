package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;

import edu.wpi.first.wpilibj.Timer;


public class GathererCloseCommand extends CommandBase {
	
	private boolean timed;
	
	private Timer timer;
	
	public GathererCloseCommand(boolean timed) {
		requires(gathererArms);
		this.timed = timed;
	}

	protected void initialize() {
		if (!gathererArms.leftInnerLimit() && !gathererArms.rightInnerLimit()) {
			RobotLog.putMessage("Closing the gatherer");
			gathererArms.close();
			if (timed) {
				timer = new Timer();
				timer.start();
			}
		} else {
			RobotLog.putMessage("Tried closing, but the limit has been reached");
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return (timed) ? (gathererArms.leftInnerLimit() || gathererArms.rightInnerLimit() || timer.hasPeriodPassed(1.5)) : (gathererArms.leftInnerLimit() || gathererArms.rightInnerLimit());
	}

	protected void end() {
		gathererArms.stopArms();
	}

	protected void interrupted() {
		gathererArms.stopArms();
	}
}
