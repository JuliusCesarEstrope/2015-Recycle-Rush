package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class ExtenderRetractCommand extends CommandBase {
	
	public ExtenderRetractCommand() {
		requires(extender);
	}

	protected void initialize() {
		if (!extender.innerLimit()) {
			RobotLog.putMessage("Retracting the extender");
			extender.retract();
		} else {
			RobotLog.putMessage("Tried retracting, but the limit has been reached");
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return (extender.innerLimit());
	}

	protected void end() {
		extender.stop();
	}

	protected void interrupted() {
		extender.stop();
	}
}
