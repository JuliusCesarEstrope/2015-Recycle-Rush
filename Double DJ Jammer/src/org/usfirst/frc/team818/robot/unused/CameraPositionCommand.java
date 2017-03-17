package org.usfirst.frc.team818.robot.unused;

import org.usfirst.frc.team818.robot.commands.CommandBase;


public class CameraPositionCommand extends CommandBase {
	
	private double positionX;
	private double positionY;
	
	public CameraPositionCommand(double userPositionX, double userPositionY) {
		requires(cameraServo);
		positionX = userPositionX;
		positionY = userPositionY;
	}

	protected void initialize() {
		cameraServo.setPosition(positionX, positionY);
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
