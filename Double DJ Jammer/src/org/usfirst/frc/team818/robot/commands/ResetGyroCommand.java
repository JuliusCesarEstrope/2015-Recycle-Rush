package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.commands.CommandBase;


public class ResetGyroCommand extends CommandBase {

	protected void initialize() {
		drive.resetGyro();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
