package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class TowerTopCommand extends CommandBase {
	
	public TowerTopCommand() {
		requires(tower);
	}

	protected void initialize() {
		if (!towerPositioning.upperLimit()) {
			RobotLog.putMessage("Maximizing the tower");
			towerPositioning.towerMoving(1);
			tower.up();
		} else {
			RobotLog.putMessage("Tried maximizing, but the limit has been reached");
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return (towerPositioning.upperLimit());
	}

	protected void end() {
		towerPositioning.towerMoving(0);
		tower.stop();
	}

	protected void interrupted() {
		towerPositioning.towerMoving(0);
		tower.stop();
	}
}
