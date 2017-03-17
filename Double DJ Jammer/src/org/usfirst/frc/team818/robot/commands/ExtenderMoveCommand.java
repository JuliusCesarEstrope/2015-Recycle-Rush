package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class ExtenderMoveCommand extends CommandBase{
	
	private double axisValue;
	private double speed;
	
	public ExtenderMoveCommand() {
		requires(extender);
	}

	protected void initialize() {
		RobotLog.putMessage("Moving the extender variably");
		speed = 0;
	}

	protected void execute() {
		
		axisValue = oi.extenderAxis();
		speed = (axisValue > 0) ? ((axisValue - 0.65) / 0.35) : ((axisValue + 0.65) / 0.35);
		if (!((extender.outerLimit() && speed > 0) || (extender.innerLimit() && speed < 0))) {
			extender.setSpeed(speed);
		} else {
			extender.stop();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		extender.stop();
	}

	protected void interrupted() {
		extender.stop();
	}
	
}
