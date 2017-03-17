package org.usfirst.frc.team818.robot.unused;

import org.usfirst.frc.team818.robot.commands.CommandBase;


public class CameraDirectionCommand extends CommandBase {
	
	private int direction;
	
	public CameraDirectionCommand(int direction) {
		requires(cameraServo);
		this.direction = direction;
	}

	protected void initialize() {
	}

	protected void execute() {
		switch(direction) {
			case 0:
				cameraServo.up();
				break;
			case 1:
				cameraServo.right();
				break;
			case 2:
				cameraServo.down();
				break;
			case 3:
				cameraServo.left();
				break;
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
