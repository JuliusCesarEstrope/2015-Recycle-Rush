package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class ExtenderExtendCommand extends CommandBase {
	
	public ExtenderExtendCommand() {
		requires(extender);
	}

	protected void initialize() {
		if (!extender.outerLimit()) {
			RobotLog.putMessage("Extending the extender");
			extender.extend();
		} else {
			RobotLog.putMessage("Tried extending, but the limit has been reached");
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return (extender.outerLimit());
	}

	protected void end() {
		extender.stop();
	}

	protected void interrupted() {
		extender.stop();
	}
}
