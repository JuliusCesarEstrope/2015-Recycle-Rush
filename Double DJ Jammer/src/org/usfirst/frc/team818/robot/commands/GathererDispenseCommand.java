package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class GathererDispenseCommand extends CommandBase {
	
	public GathererDispenseCommand() {
		requires(gathererWheels);
	}

	protected void initialize() {
		RobotLog.putMessage("Dispensing totes");
		gathererWheels.dispense();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		gathererWheels.stopWheels();
	}

	protected void interrupted() {
		gathererWheels.stopWheels();
	}
}
