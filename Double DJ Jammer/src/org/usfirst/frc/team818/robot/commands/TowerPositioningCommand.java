package org.usfirst.frc.team818.robot.commands;


public class TowerPositioningCommand extends CommandBase {
	
	public TowerPositioningCommand() {
		requires(towerPositioning);
	}

	protected void initialize() {
		towerPositioning.setHomeDirection(-towerPositioning.towerMovingDirection());
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
