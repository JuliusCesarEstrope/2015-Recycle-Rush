package org.usfirst.frc.team818.robot.commands;

import org.usfirst.frc.team818.robot.RobotLog;


public class TowerHomeCommand extends CommandBase {
	
	public TowerHomeCommand() {
		requires(tower);
	}

	protected void initialize() {
		if (!towerPositioning.atHome()) {
			RobotLog.putMessage("I'm going home, I'm going home . . .");
			if (towerPositioning.homeDirection() == 1) {
				RobotLog.putMessage("Getting home by upscaling");
				tower.up();
			} else {
				RobotLog.putMessage("Getting home by downscaling");
				tower.down();
			}
		}
	}

	protected void execute() {
		if (towerPositioning.lowerLimit()) {
			RobotLog.putMessage("Something went wrong, switching direction");
			tower.up();
		} else if (towerPositioning.upperLimit()) {
			RobotLog.putMessage("Something went wrong, switching direction");
			tower.down();
		}
	}

	protected boolean isFinished() {
		return towerPositioning.atHome();
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
