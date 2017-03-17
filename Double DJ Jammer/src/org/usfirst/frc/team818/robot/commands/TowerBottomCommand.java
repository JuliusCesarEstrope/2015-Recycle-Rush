package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class TowerBottomCommand extends CommandBase {
	
	public TowerBottomCommand() {
		requires(tower);
	}

	protected void initialize() {
		if (!towerPositioning.lowerLimit()) {
			RobotLog.putMessage("Minimizing the tower");
			towerPositioning.towerMoving(-1);
			tower.down();
		}  else {
			RobotLog.putMessage("Tried minimizing, but the limit has been reached");
		}
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return (towerPositioning.lowerLimit());
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
